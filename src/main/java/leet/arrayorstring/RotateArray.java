package leet.arrayorstring;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = {-1,-100,3,99};
        int k = 5;
        ra.rotate(nums,k);
    }
    public static void reverse(int[] nums, int start, int end) {
        int temp;
        while (start<end) {
            temp=nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {

        k=k% nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);

        Arrays.stream(nums)
                .forEach(System.out::println);
    }

}
