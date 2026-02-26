package leet.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//30
public class SubstringConcatenationOfAllWords {
    public static void main(String[] args) {
        SubstringConcatenationOfAllWords sw = new SubstringConcatenationOfAllWords();
        String s="barfoothefoobarman";
        String[] words = {"foo","bar"};

       System.out.println(sw.findSubstring(s,words).toString());
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int lengthOfWords = words.length;
        int lengthOfEachWord = words[0].length();
        List<Integer> answer = new ArrayList<>();

        for(int i=0;i<=s.length()-lengthOfWords*lengthOfEachWord;i++) {
            Map<String,Integer> wordCount = new HashMap<>();
            for (String word : words) {
                if (wordCount.containsKey(word)) {
                    int value = wordCount.get(word);
                    wordCount.put(word, ++value);
                } else
                    wordCount.put(word, 1);
            }
            int j;
            for(j=0;j<lengthOfWords;j++) {
                String str = s.substring(i+j*lengthOfEachWord, j*lengthOfEachWord+(lengthOfEachWord+i));
                if(!wordCount.containsKey(str))
                    break;
                if(wordCount.get(str).equals(0))
                    break;
                else {
                    int value = wordCount.get(str);
                    wordCount.put(str, --value);
                }
            }

            if(j==lengthOfWords)
                answer.add(i);
        }

        return answer;
    }
}
