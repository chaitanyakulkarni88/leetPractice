package leet;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(ga.groupAnagrams(strs).toString());
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> frequency = new HashMap<>();

        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        for(int i=0;i< strs.length;i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String tempValue = String.valueOf(temp);
            if(!frequency.containsKey(tempValue)) {
                frequency.put(tempValue,new ArrayList<>());
                frequency.get(tempValue).add(strs[i]);
            }

            else
                frequency.get(tempValue).add(strs[i]);
        }

        return frequency.values()
                .stream()
                .toList();
    }
}
