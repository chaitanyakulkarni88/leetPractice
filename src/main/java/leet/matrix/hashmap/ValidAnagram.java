package leet.matrix.hashmap;

import java.util.HashMap;
import java.util.Map;
//242
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "anagram", t = "nagaram";
        //String s = "rat", t = "car";
        System.out.println(va.isAnagram(s,t));
    }
//    public boolean isAnagram(String s, String t) {
//        char[] sChar = s.toCharArray();
//        char[] tChar = t.toCharArray();
//
//        Arrays.sort(sChar);
//        Arrays.sort(tChar);
//
//        return Arrays.equals(sChar, tChar);
//
//    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        if(s.length() != t.length())
            return false;

        for(int i=0;i<s.length();i++)
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0)+1);

        for(int i=0;i<t.length();i++)
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0)+1);

        for(int i=0;i<s.length();i++) {
            if(!sCount.get(s.charAt(i)).equals(tCount.get(s.charAt(i))))
                return false;
        }
        return true;
    }
}
