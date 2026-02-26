package leet.arrayorstring;
//28
public class FirstOccurrenceInString {
    public static void main(String[] args) {
        FirstOccurrenceInString fs = new FirstOccurrenceInString();
        String haystack = "leetcode";
        String needle = "code";
        System.out.println(fs.strStr(haystack,needle));
    }
//    public int strStr(String haystack, String needle) {
//        for(int i=0;i<haystack.length();i++) {
//            for(int j=i+1;j<=haystack.length();j++) {
//                String temp = haystack.substring(i,j);
//                if(temp.equals(needle))
//                    return i;
//            }
//        }
//        return -1;
//    }

//    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }

    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystacklength = haystack.length();
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        for(int i=0;i< haystackArray.length;i++) {
            if(haystackArray[i] == needleArray[0]&& (haystacklength-i) >= needleLength) {
                String temp = haystack.substring(i,needleLength+i);
                if(temp.equals(needle))
                    return i;
            }
        }
        return -1;
    }
}
