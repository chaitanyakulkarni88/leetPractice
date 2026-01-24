package leet;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        String pattern = "abc", s = "b c a";
        System.out.println(wp.wordPattern(pattern,s));
    }
    public boolean wordPattern(String pattern, String s) {

        String[] arrayOfS = s.split(" ");
        Map<Character,String> patternMatcher = new HashMap<>();
        boolean flip = false;
        int count = 0;

        if(arrayOfS.length!=pattern.length())
            return false;

        for(int i=0;i<arrayOfS.length;i++) {
            if(patternMatcher.containsKey(pattern.charAt(i))) {
                if(!patternMatcher.get(pattern.charAt(i)).equals(arrayOfS[i])) {
                    flip = false;
                    break;
                }
                else
                    flip=true;
            }
            else {
                if(patternMatcher.containsValue(arrayOfS[i])) {
                    flip = false;
                    break;
                }
                else {
                    patternMatcher.put(pattern.charAt(i),arrayOfS[i]);
                    count++;
                }
            }
        }

        if(count == arrayOfS.length)
            return true;

        return flip;

    }
}
