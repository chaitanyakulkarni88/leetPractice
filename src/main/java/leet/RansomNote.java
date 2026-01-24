package leet;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        String ransomNote = "aab", magazine = "baa";
        System.out.println(rn.canConstruct(ransomNote,magazine));
    }
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character,Integer> magazineCharactersCount = new HashMap<>();
        int count = 0;

        if(magazine.length() < ransomNote.length())
            return false;

        for(int i=0;i<magazine.length();i++)
            magazineCharactersCount.put(magazine.charAt(i), magazineCharactersCount.getOrDefault(magazine.charAt(i),0)+1);

        for(int i=0;i<ransomNote.length();i++) {
            if(magazineCharactersCount.containsKey(ransomNote.charAt(i)) && !magazineCharactersCount.get(ransomNote.charAt(i)).equals(0)) {
                count++;
                int value = magazineCharactersCount.get(ransomNote.charAt(i));
                magazineCharactersCount.put(ransomNote.charAt(i),--value);
            }

        }

        return count == ransomNote.length();
    }
}
