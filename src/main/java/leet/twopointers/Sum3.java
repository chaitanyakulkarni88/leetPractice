package leet.twopointers;

import java.util.*;

//15
public class Sum3 {
    public static void main(String[] args) {
        Sum3 s = new Sum3();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(s.threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> results = new HashSet<>();

        for(int i=0;i< nums.length-2;i++) {
            int j=i+1;
            int k= nums.length-1;
            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0)
                    j++;
                else if (sum>0)
                    k--;
                else {
                    results.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return results.stream().toList();
    }
}
