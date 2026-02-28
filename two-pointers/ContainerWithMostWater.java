/*
 * LeetCode Problem: #11 - Container With Most Water
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Use two pointers at both ends.
 * 2. Calculate area = min(height[left], height[right]) * width.
 * 3. Move the pointer with smaller height inward.
 * 4. Repeat until pointers meet.
 *
 * Pattern: Two Pointers (Opposite Direction Greedy)
 */

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * width);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        ContainerWithMostWater solution = new ContainerWithMostWater();

        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height)); // 49
    }
}