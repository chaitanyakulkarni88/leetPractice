package leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//76
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring ms = new MinimumWindowSubstring();
        String s = "aa";
        String t = "aa";
        System.out.println(ms.minWindow(s,t));
    }
//    public String minWindow(String s, String t) {
//        Map<Character,Integer> mp1 = new HashMap<>();
//        Map<Character,Integer> mp2 = new HashMap<>();
//
//        for(int i=0;i<t.length();i++)
//            mp2.put(t.charAt(i),mp2.getOrDefault(t.charAt(i),0) + 1);
//
//        int start=0;
//        int end=0;
//        int count=0;
//        int minLength=Integer.MAX_VALUE;
//
//        while(end < s.length()){
//            mp1.put(s.charAt(end),mp1.getOrDefault(s.charAt(end),0)+1);
//
//            if(mp2.containsKey(s.charAt(end)) && (mp1.get(s.charAt(end)) <= mp2.get(s.charAt(end)))) {
//                count++;
//            }
//
//            if(count == t.length()) {
//                while(!mp2.containsKey(s.charAt(start)) || mp1.get(s.charAt(start)) > mp2.get(s.charAt(start))) {
//                    mp1.put(s.charAt(start), mp1.get(s.charAt(start))-1);
//                    start++;
//                }
//                minLength = Math.min(end-start+1, minLength);
//            }
//
//            end++;
//        }
//
//        return count == t.length() ? s.substring(start,start+minLength) : "";
//    }
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        char[] arr = s.toCharArray();
        //Set up the table
        for(char cur : t.toCharArray()){
            map[cur]++;
        }

        int countAllCharInT = 0;
        int left = 0, n = arr.length, right = 0;
        int minLen = Integer.MAX_VALUE;
        String minLenStr = "";

        while(right < n){
            //Expand the window
            map[arr[right]]--;
            if(0 <= map[arr[right]]){
                countAllCharInT++;
            }

            //Shrink the window if current window contains all the char in t
            while(countAllCharInT == t.length()){
                //Update the minLen
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    minLenStr = s.substring(left, right + 1);
                }

                //Shrink the window
                map[arr[left]]++;
                if(0 < map[arr[left]]){
                    countAllCharInT--;
                }
                left++;
            }

            right++;
        }

        return minLenStr;
    }
}
