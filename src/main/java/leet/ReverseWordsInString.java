package leet;

import java.util.ArrayList;
import java.util.List;
//151
public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString rs = new ReverseWordsInString();
        String str = "a good   example";
        System.out.println(rs.reverseWords(str));
    }
    public String reverseWords(String s) {
        String[] wordsWithSpaces = s.split(" ");
        List<String> wordsOnly = new ArrayList<>();

        for(String word: wordsWithSpaces) {
            if(!word.isEmpty())
                wordsOnly.add(word);
        }
        
        StringBuilder result = new StringBuilder();
        for(int i=wordsOnly.size()-1;i>=0;i--) {
            result.append(wordsOnly.get(i)).append(" ");
        }
        
        return result.toString().trim();
    }
}
