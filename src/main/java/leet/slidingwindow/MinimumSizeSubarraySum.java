package leet.slidingwindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum ms = new MinimumSizeSubarraySum();
        int target = 4;
        int[] nums = {1,4,4};
        System.out.println(ms.minSubArrayLen(target,nums));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int start = 0;
        int end = 0;
        int minLength = Integer.MAX_VALUE;

        while(end< nums.length) {
            currentSum += nums[end];
            end++;
            while(currentSum>=target) {
                minLength = Math.min(minLength,end-start);
                currentSum-=nums[start];
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0:minLength;
    }
}
