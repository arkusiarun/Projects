package assessment.lfuCache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache<K, V> {
    private final int capacity;
    private int minFrequency;
    private final Map<K, Node> cache;
    private final Map<Integer, LinkedHashSet<K>> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    // Get value associated with the key
    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        Node<K,V> node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }

    // Put a key-value pair into the cache
    public void put(K key, V value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (cache.size() >= capacity) {
                evictLFU();
            }
            Node newNode = new Node(key, value, 1);
            cache.put(key, newNode);
            frequencyMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFrequency = 1;
        }
    }

    // Update the frequency of a node
    private void updateFrequency(Node<K,V> node) {
        int currentFrequency = node.frequency;
        frequencyMap.get(currentFrequency).remove(node.key);
        if (frequencyMap.get(currentFrequency).isEmpty()) {
            frequencyMap.remove(currentFrequency);
            if (minFrequency == currentFrequency) {
                minFrequency++;
            }
        }
        node.frequency++;
        frequencyMap.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>()).add(node.key);
    }

    // Evict the least frequently used key
    private void evictLFU() {
        LinkedHashSet<K> keysWithMinFrequency = frequencyMap.get(minFrequency);
        K keyToEvict = keysWithMinFrequency.iterator().next(); // First element in the set
        keysWithMinFrequency.remove(keyToEvict);
        if (keysWithMinFrequency.isEmpty()) {
            frequencyMap.remove(minFrequency);
        }
        cache.remove(keyToEvict);
    }

    // Main method for testing
    public static void main(String[] args) {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(3);
        lfuCache.put(1, "A");
        lfuCache.put(2, "B");
        lfuCache.put(3, "C");

        System.out.println(lfuCache.get(1)); // Output: A
        lfuCache.put(4, "D"); // Evicts key 2 (LFU)

        System.out.println(lfuCache.get(2)); // Output: null
        System.out.println(lfuCache.get(3)); // Output: C
        System.out.println(lfuCache.get(4)); // Output: D
    }
}
