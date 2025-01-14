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