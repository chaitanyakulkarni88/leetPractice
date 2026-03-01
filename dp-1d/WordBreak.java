import java.util.*;

public class WordBreak {

    /*
     * LeetCode Problem: 139 - Word Break
     *
     * Time Complexity  : O(n^2)
     * Space Complexity : O(n)
     *
     * Core Idea:
     * 1. Use DP array where dp[i] = true
     *    if substring s[0...i) can be segmented.
     * 2. For each i, check all j < i.
     * 3. If dp[j] is true and s[j...i) is in dictionary,
     *    then dp[i] = true.
     *
     * Algorithm Pattern: Dynamic Programming
     */

    public static boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null) {
            throw new IllegalArgumentException("Input must not be null.");
        }

        Set<String> dictionary = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");

        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");

        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println("Example 1 → " + wordBreak(s1, dict1));
        System.out.println("Example 2 → " + wordBreak(s2, dict2));
        System.out.println("Example 3 → " + wordBreak(s3, dict3));
    }
}