package leet.twopointers;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        TwoSumII ts = new TwoSumII();
        int[] nums = {2,4,7,11,15};
        int target = 9;
        Arrays.stream(ts.twoSum(nums,target))
                .forEach(System.out::println);
    }
//    public int[] twoSum(int[] numbers, int target) {
//        for(int i=0;i< numbers.length;i++) {
//            for(int j=i+1;j< numbers.length;j++) {
//                if(numbers[i]+numbers[j]==target)
//                    return new int[]{i+1,j+1};
//            }
//        }
//        return new int[]{0,0};
//    }
public int[] twoSum(int[] numbers, int target) {
    int i=0;
    int j= numbers.length-1;

    while(i<j) {
        if((numbers[i]+numbers[j]) > target)
            j--;
        else if ((numbers[i]+numbers[j]) < target)
            i++;
        else
            return new int[]{i+1,j+1};

    }
    return new int[]{0,0};
}
}
