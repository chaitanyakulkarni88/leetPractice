package leet.matrix.hashmap;

import java.util.HashMap;
import java.util.Map;

//128
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence ls = new LongestConsecutiveSequence();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(ls.longestConsecutive(nums));
    }
//    public int longestConsecutive(int[] nums) {
//        int i=0;
//        int j=1;
//        int max = Integer.MIN_VALUE;
//
//        if(nums.length == 0)
//            return 0;
//
//        if(nums.length == 1)
//            return 1;
//
//        Arrays.sort(nums);
//
//        while(j< nums.length) {
//            if(nums[i] == nums[j] - (j-i)) {
//                max = Math.max(max,((j-i)+1));
//                j++;
//            } else {
//                i=j;
//                j++;
//            }
//        }
//        return max;
//    }

    public int longestConsecutive(int[] nums) {
        int max = Integer.MIN_VALUE;
        Map<Integer,Boolean> arrayTraversal = new HashMap<>();

        if(nums.length == 0)
            return 0;

        for(int i=0;i< nums.length;i++)
            arrayTraversal.put(nums[i], false);

        for(int i=0;i< nums.length;i++) {
            int count = 0;
            if(!arrayTraversal.get(nums[i])) {
                arrayTraversal.put(nums[i], true);
                count++;
                max = Math.max(max, count);
                int nextNum = nums[i]+1;
                while(arrayTraversal.containsKey(nextNum)) {
                    arrayTraversal.put(nextNum, true);
                    count++;
                    max = Math.max(max, count);
                    nextNum++;
                }
                nextNum = nums[i]-1;
                while(arrayTraversal.containsKey(nextNum)) {
                    arrayTraversal.put(nextNum, true);
                    count++;
                    max = Math.max(max, count);
                    nextNum--;
                }
            }
        }
        return max;
    }

}
