package assessment.lruCache.generics;

import java.util.*;

public class LRUCache<K, V> {
    private final int capacity;  // Maximum capacity of the cache
    private final Map<K, Node<K, V>> cache;  // HashMap to store key-node mapping
    private final DoublyLinkedList<K, V> list;  // Doubly linked list for LRU order

    // Constructor to initialize LRU cache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new DoublyLinkedList<>();
    }

    // Get a value from the cache
    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;  // Key not found
        }
        Node<K, V> node = cache.get(key);
        list.moveToFront(node);  // Mark as most recently used
        return node.value;
    }

    // Put a key-value pair in the cache
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            // Update existing value and move it to the front
            Node<K, V> node = cache.get(key);
            node.value = value;
            list.moveToFront(node);
        } else {
            // If the cache is full, evict the least recently used item
            if (cache.size() == capacity) {
                Node<K, V> lruNode = list.removeLast();
                cache.remove(lruNode.key);
            }
            // Add the new key-value pair
            Node<K, V> newNode = new Node<>(key, value);
            list.addToFront(newNode);
            cache.put(key, newNode);
        }
    }

    // Node class for the doubly linked list
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Doubly linked list class
    private static class DoublyLinkedList<K, V> {
        private final Node<K, V> head;  // Dummy head node
        private final Node<K, V> tail;  // Dummy tail node

        DoublyLinkedList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }

        // Add a node to the front of the list
        void addToFront(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Remove a node from the list
        void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Move a node to the front of the list
        void moveToFront(Node<K, V> node) {
            removeNode(node);
            addToFront(node);
        }

        // Remove and return the last node
        Node<K, V> removeLast() {
            if (tail.prev == head) {
                return null;  // List is empty
            }
            Node<K, V> lastNode = tail.prev;
            removeNode(lastNode);
            return lastNode;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        lruCache.put(1, "A");
        lruCache.put(2, "B");
        lruCache.put(3, "C");

        System.out.println(lruCache.get(1));  // Output: A
        lruCache.put(4, "D");  // Evicts key 2
        System.out.println(lruCache.get(2));  // Output: null
        lruCache.put(5, "E");  // Evicts key 3

        System.out.println(lruCache.get(1));  // Output: A
        System.out.println(lruCache.get(3));  // Output: null
        System.out.println(lruCache.get(4));  // Output: D
        System.out.println(lruCache.get(5));  // Output: E
    }
}