package leet;

import java.util.ArrayList;
import java.util.List;

public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();
        String s="axc";
        String t="ahbgdc";
        System.out.println(is.isSubsequence(s,t));
    }
    public boolean isSubsequence(String s, String t) {

        int i=0;
        int j=0;

        while(j<t.length()&&i<s.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else
                j++;
        }

        if(i == s.length())
            return true;
        else
            return false;

    }
}
