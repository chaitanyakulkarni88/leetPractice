package leet.arrayorstring;

import java.util.Arrays;
import java.util.List;
//58
public class LengthLastWord {
    public static void main(String[] args) {
        LengthLastWord llw = new LengthLastWord();
        String input = "   fly me   to   the moon  ";
        System.out.println(llw.lengthOfLastWord(input));
    }
    public int lengthOfLastWord(String s) {
        List<String> allOnlyWords = Arrays.stream(s.split(" "))
                .filter(str->!str.isEmpty())
                .toList();

        return allOnlyWords.get(allOnlyWords.size()-1).length();
    }
}
