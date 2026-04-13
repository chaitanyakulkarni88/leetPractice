/**
 * LeetCode Problem: 219. Contains Duplicate II
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Store number → last seen index in a map.
 * 2. If duplicate is found and index difference ≤ k, return true.
 * 3. Update index after each iteration.
 */
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        ContainsDuplicateII solution = new ContainsDuplicateII();

        int[] nums1 = {1, 0, 1, 1};
        int k1 = 1;

        System.out.println(solution.containsNearbyDuplicate(nums1, k1));

        int[] nums2 = {1, 2, 3, 1, 2, 3};
        int k2 = 1;

        System.out.println(solution.containsNearbyDuplicate(nums2, k2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        validateInput(nums, k);

        Map<Integer, Integer> lastSeenIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastSeenIndex.containsKey(nums[i])) {
                if (i - lastSeenIndex.get(nums[i]) <= k) {
                    return true;
                }
            }
            lastSeenIndex.put(nums[i], i);
        }

        return false;
    }

    private void validateInput(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }
        if (k < 0) {
            throw new IllegalArgumentException("k must be non-negative.");
        }
    }
}