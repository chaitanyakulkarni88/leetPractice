/*
 * LeetCode Problem: #238 - Product of Array Except Self
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding output array)
 *
 * Core Idea:
 * 1. First pass: compute prefix product for each index.
 * 2. Second pass (right to left): multiply with suffix product.
 * 3. Avoid division.
 *
 * Pattern: Prefix-Suffix Product / Two Pass Array
 */

import java.util.Arrays;

public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n];

        // Prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Suffix products (reuse variable)
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        ProductArrayExceptSelf solution = new ProductArrayExceptSelf();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Result: " + Arrays.toString(solution.productExceptSelf(nums1)));

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Result: " + Arrays.toString(solution.productExceptSelf(nums2)));

        int[] nums3 = {5};
        System.out.println("Result: " + Arrays.toString(solution.productExceptSelf(nums3)));
    }
}