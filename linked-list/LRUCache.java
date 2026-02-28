/**
 * LeetCode Problem: 146. LRU Cache
 *
 * Time Complexity:
 *   get  -> O(1)
 *   put  -> O(1)
 *
 * Space Complexity: O(capacity)
 *
 * Core Idea:
 * 1. Use LinkedHashMap with access-order enabled.
 * 2. Override removeEldestEntry to enforce capacity.
 * 3. Accessing a key updates its usage order automatically.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public static void main(String[] args) {

        LRUCache lru = new LRUCache(2);

        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // 1

        lru.put(3, 3);
        System.out.println(lru.get(2)); // -1

        lru.put(4, 4);
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(3)); // 3
        System.out.println(lru.get(4)); // 4
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}