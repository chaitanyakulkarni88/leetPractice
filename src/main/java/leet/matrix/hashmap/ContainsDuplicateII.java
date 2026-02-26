package leet.matrix.hashmap;

import java.util.HashMap;
import java.util.Map;

//219
public class ContainsDuplicateII {
    public static void main(String[] args) {
        ContainsDuplicateII cd = new ContainsDuplicateII();
        int[] nums = {1,0,1,1};
        int k = 1;
        System.out.println(cd.containsNearbyDuplicate(nums,k));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexAndValue = new HashMap<>();
        for(int i=0;i< nums.length;i++) {
            if(indexAndValue.containsKey(nums[i])) {
                int value = Math.abs(indexAndValue.get(nums[i]) - i);
                if(value <= k)
                    return true;
                else
                    indexAndValue.put(nums[i], i);
            }
            else
                indexAndValue.put(nums[i], i);
        }
        return false;
    }
}
