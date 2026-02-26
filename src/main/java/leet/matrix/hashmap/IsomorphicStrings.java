package leet.matrix.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();
        String s = "badc", t = "baba";
        System.out.println(is.isIsomorphic(s,t));
    }
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> chars = new HashMap<>();
        boolean flip = true;
        for(int i=0;i<s.length();i++) {
            if(chars.containsKey(s.charAt(i))) {
                if(!chars.get(s.charAt(i)).equals(t.charAt(i))) {
                    flip = false;
                    break;
                }
            }
            else {
                if(chars.containsValue(t.charAt(i))) {
                    flip = false;
                    break;
                }
                else
                    chars.put(s.charAt(i),t.charAt(i));
            }
        }
        return flip;
    }
}
