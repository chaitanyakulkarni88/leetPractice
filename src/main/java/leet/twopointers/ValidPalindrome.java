package leet.twopointers;
//125
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(isPalindrome("race a car"));
        //System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {

        String cleanS = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int start = 0;
        int end = cleanS.length()-1;

        while(start<end) {
            if(cleanS.charAt(start) != cleanS.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;

    }
}
