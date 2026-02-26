package leet.matrix.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//1
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,1};
        int[] resultIndices = twoSum(nums,9);
        System.out.println(Arrays.toString(resultIndices));
    }
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> values = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int comp = target - nums[i];
            if(values.containsKey(comp))
                return new int[] {i, values.get(comp)};
            else
                values.put(nums[i],i);
        }
        return null;
    }
//    public int[] twoSum(int[] nums, int target) {
//
//        for(int i=0;i<nums.length;i++) {
//            for (int j=i+1;j<nums.length;j++) {
//                int sum = nums[i] + nums[j];
//                if(target == sum) {
//                    return new int[] {nums[i],nums[j]};
//                }
//            }
//        }
//        return null;
//    }
}
