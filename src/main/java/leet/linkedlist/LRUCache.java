package leet.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private final int capacity;
    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
    public static void main(String[] args) {

        LRUCache lru = new LRUCache(2);

        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println("get(1): " + lru.get(1)); // 1

        lru.put(3, 3);
        System.out.println("get(2): " + lru.get(2)); // -1

        lru.put(4, 4);
        System.out.println("get(1): " + lru.get(1)); // -1
        System.out.println("get(3): " + lru.get(3)); // 3
        System.out.println("get(4): " + lru.get(4)); // 4
    }
}
