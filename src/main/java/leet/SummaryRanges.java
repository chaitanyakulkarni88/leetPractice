package leet;

import java.util.ArrayList;
import java.util.List;
//228
public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        //int[] nums = {0,1,2,4,5,7};
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(sr.summaryRanges(nums).toString());
    }
    public List<String> summaryRanges(int[] nums) {
        int i=0;
        int j=0;
        List<String> result = new ArrayList<>();
        int n = nums.length;

        while(j< n) {
            if(j+1 < n && nums[j+1] == nums[j]+1)
                j++;
            else {
                if(i == j) {
                    result.add(String.valueOf(nums[i]));
                    i=j+1;
                    j++;
                }
                else {
                    result.add(nums[i]+"->"+nums[j]);
                    i=j+1;
                    j++;
                }
            }
        }
        return result;
    }
}
