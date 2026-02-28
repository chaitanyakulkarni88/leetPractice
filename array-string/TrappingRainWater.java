/*
 * LeetCode Problem: #42 - Trapping Rain Water
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Water at index i = min(maxLeft, maxRight) - height[i].
 * 2. Use two pointers (left and right).
 * 3. Track maxLeft and maxRight dynamically.
 * 4. Move the pointer with smaller height inward.
 *
 * Pattern: Two Pointers / Dynamic Boundary Tracking
 */

public class TrappingRainWater {

    public int trap(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }

                left++;

            } else {

                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }

                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {

        TrappingRainWater solution = new TrappingRainWater();

        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped Water: " + solution.trap(height1));

        int[] height2 = {4,2,0,3,2,5};
        System.out.println("Trapped Water: " + solution.trap(height2));

        int[] height3 = {1,2,3,4};
        System.out.println("Trapped Water: " + solution.trap(height3));
    }
}