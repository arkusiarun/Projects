package assessment.lfuCache;

public class Node<K, V> {
    final K key;
    V value;
    int frequency;

    public Node(K key, V value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
}