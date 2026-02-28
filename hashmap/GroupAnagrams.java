/**
 * LeetCode Problem: 49. Group Anagrams
 *
 * Time Complexity: O(n * k log k)
 * Space Complexity: O(n * k)
 *
 * Core Idea:
 * 1. For each string, sort its characters to form a key.
 * 2. Use the sorted string as a map key.
 * 3. Group original strings under the same key.
 */
import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = solution.groupAnagrams(strs);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            anagramMap
                    .computeIfAbsent(key, k -> new ArrayList<>())
                    .add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }
}