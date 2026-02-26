package leet.arrayorstring;

import java.util.HashMap;
import java.util.Map;

//169
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(me.majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        int valueForMajority = nums.length / 2;

        for(int i:nums) {
            if(count.containsKey(i)) {
                int val = count.get(i);
                count.put(i,++val);
            }
            else
                count.put(i,1);
        }

        System.out.println(count);

        Integer result = count.entrySet()
                .stream()
                .filter((i) -> i.getValue() > valueForMajority)
                .map((i) -> i.getKey())
                .findFirst()
                .get();

        return result.intValue();

    }
//public int majorityElement(int[] nums) {
//
//        int candidate = 0;
//        int count = 0;
//
//        for(int i=0;i<nums.length;i++) {
//            if(count == 0) {
//                candidate = nums[i];
//            }
//
//            if(candidate == nums[i]) {
//                count++;
//            }
//            else {
//                count--;
//            }
//        }
//
//        return candidate;
//
//}
}
