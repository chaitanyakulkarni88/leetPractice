package leet;

public class PalindromeSubStrings {
    public static void main(String[] args) {

        int totalCount = substringsCount("abc");
        System.out.println(totalCount);

    }

    private static int substringsCount(String input) {
        int count = 0;
        for(int start = 0; start < input.length();start++) {
            for(int end = start;end < input.length();end++) {
                if(isPalindrome(input,start,end)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPalindrome(String input, int left, int right) {
        while(left < right) {
            if(input.charAt(left) != input.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
