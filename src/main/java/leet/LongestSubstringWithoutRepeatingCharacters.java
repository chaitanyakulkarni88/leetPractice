package leet;

import java.util.ArrayList;
import java.util.List;

//3
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lp = new LongestSubstringWithoutRepeatingCharacters();
        String s="pwwkew";
        System.out.println(lp.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        int start = 0;
        int end = 0;
        List<Character> charList = new ArrayList<>();
        while(end<s.length()) {
            if(charList.contains(s.charAt(end))) {
                charList.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
            else {
                charList.add(s.charAt(end));
                maxLength = Math.max(charList.size(),maxLength);
                end++;
            }

        }

        return maxLength;
    }
}
