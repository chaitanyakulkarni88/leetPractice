/**
 * LeetCode Problem: 205. Isomorphic Strings
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Maintain two maps:
 *      - s → t mapping
 *      - t → s reverse mapping
 * 2. Ensure mapping is consistent in both directions.
 * 3. If conflict occurs, return false immediately.
 */
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();

        String s1 = "paper";
        String t1 = "title";

        System.out.println(solution.isIsomorphic(s1, t1));

        String s2 = "badc";
        String t2 = "baba";

        System.out.println(solution.isIsomorphic(s2, t2));
    }

    public boolean isIsomorphic(String s, String t) {
        validateInput(s, t);

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> forwardMap = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (forwardMap.containsKey(c1)) {
                if (forwardMap.get(c1) != c2) {
                    return false;
                }
            } else {
                if (reverseMap.containsKey(c2)) {
                    return false;
                }
                forwardMap.put(c1, c2);
                reverseMap.put(c2, c1);
            }
        }

        return true;
    }

    private void validateInput(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Input strings must not be null.");
        }
    }
}