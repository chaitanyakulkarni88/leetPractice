/*
 * LeetCode Problem: #380 - Insert Delete GetRandom O(1)
 *
 * Time Complexity:
 *   - insert: O(1)
 *   - remove: O(1)
 *   - getRandom: O(1)
 *
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Use ArrayList for O(1) random access.
 * 2. Use HashMap to store value → index.
 * 3. On removal, swap element with last element.
 * 4. Update map and remove last element.
 *
 * Pattern: Hashing + Array Index Manipulation
 */

import java.util.*;

public class RandomizedSet {

    private final List<Integer> elements;
    private final Map<Integer, Integer> indexMap;
    private final Random random;

    public RandomizedSet() {
        elements = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {

        if (indexMap.containsKey(val)) {
            return false;
        }

        indexMap.put(val, elements.size());
        elements.add(val);
        return true;
    }

    public boolean remove(int val) {

        if (!indexMap.containsKey(val)) {
            return false;
        }

        int index = indexMap.get(val);
        int lastElement = elements.get(elements.size() - 1);

        // Swap with last element
        elements.set(index, lastElement);
        indexMap.put(lastElement, index);

        // Remove last
        elements.remove(elements.size() - 1);
        indexMap.remove(val);

        return true;
    }

    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }

    public static void main(String[] args) {

        RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}