import java.util.*;

public class MedianOfTwoSortedArrays {

    /*
     * LeetCode Problem: 4 - Median of Two Sorted Arrays
     *
     * Time Complexity  : O(log(min(m, n)))
     * Space Complexity : O(1)
     *
     * Core Idea:
     * 1. Perform binary search on smaller array.
     * 2. Partition both arrays such that:
     *      left partition size = right partition size (or +1).
     * 3. Ensure:
     *      maxLeftA <= minRightB
     *      maxLeftB <= minRightA
     * 4. Compute median based on total length parity.
     *
     * Algorithm Pattern: Binary Search on Partition
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Input arrays must not be null.");
        }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            int partitionA = left + (right - left) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {

                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) +
                            Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            }

            if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};

        int[] nums5 = {};
        int[] nums6 = {1};

        System.out.println("Median 1: " +
                findMedianSortedArrays(nums1, nums2));

        System.out.println("Median 2: " +
                findMedianSortedArrays(nums3, nums4));

        System.out.println("Median 3: " +
                findMedianSortedArrays(nums5, nums6));
    }
}