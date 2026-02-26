package leet.arrayorstring;

import java.util.Arrays;
//14
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        char[] firstStringArray = strs[0].toCharArray();
        char[] lastStringArray = strs[strs.length-1].toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i =0; i< firstStringArray.length;i++) {
            if(firstStringArray[i] != lastStringArray[i])
                break;
            result.append(firstStringArray[i]);
        }
        return result.toString();
    }
}
