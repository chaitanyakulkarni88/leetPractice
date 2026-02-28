/*
 * LeetCode Problem: #169 - Majority Element
 *
 * Time Complexity:
 *   - HashMap Approach: O(n)
 *   - Boyer-Moore Approach: O(n)
 *
 * Space Complexity:
 *   - HashMap Approach: O(n)
 *   - Boyer-Moore Approach: O(1)
 *
 * Core Idea:
 * 1. HashMap: Count frequency of each element and return the one > n/2.
 * 2. Boyer-Moore:
 *    - Maintain a candidate and counter.
 *    - Cancel out different elements.
 *    - Majority element survives due to > n/2 frequency.
 *
 * Pattern: Hashing / Boyer-Moore Voting Algorithm
 */

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Approach 1: HashMap
    public int majorityElementUsingHashMap(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int threshold = nums.length / 2;

        for (int num : nums) {
            int count = frequencyMap.getOrDefault(num, 0) + 1;
            if (count > threshold) {
                return num;
            }
            frequencyMap.put(num, count);
        }

        return 0;
    }

    // Approach 2: Boyer-Moore (Optimal)
    public int majorityElementUsingBoyerMoore(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {

        MajorityElement solution = new MajorityElement();

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("HashMap Approach: "
                + solution.majorityElementUsingHashMap(nums));

        System.out.println("Boyer-Moore Approach: "
                + solution.majorityElementUsingBoyerMoore(nums));
    }
}