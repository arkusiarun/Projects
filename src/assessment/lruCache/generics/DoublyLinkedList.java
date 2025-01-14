package assessment.lruCache.generics;

public class DoublyLinkedList<K, V> {
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
