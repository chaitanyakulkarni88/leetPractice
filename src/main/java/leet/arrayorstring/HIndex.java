package leet.arrayorstring;

//274
public class HIndex {
    public int hIndex(int[] citations) {
//        sortArray(citations);
//        int n = citations.length;
//        int index = 0;
//
//        while(index<n && n-index > citations[index]) {
//            index++;
//        }
//
//        return n-index;
//
//
//        int left = 0;
//        int right = citations.length - 1;
////        int n = citations.length;
//
//        while(left<=right) {
//            int h = (left + right)/2;
//
//            if(citations[h] == n-h)
//                return n-h;
//            else if (citations[h] < n-h)
//                left = h +1;
//            else if (citations[h] > n-h)
//                right = h-1;
//
//        }
//        return n-left;

//Using bucket sort

        int[] buckets = new int[citations.length+1];
        int n = citations.length;
        for(int i=0;i< citations.length;i++) {
            if(citations[i] > n)
                buckets[n]++;
            else
                buckets[citations[i]]++;
        }

        int count = 0;
        for(int i= buckets.length-1;i>=0;i--) {
            count+=buckets[i];
            if(count>=i)
                return i;
        }

        return 0;
    }

    private static void sortArray(int[] citations) {
        int n = citations.length;
        for (int i = 1; i < n; ++i) {
            int key = citations[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && citations[j] > key) {
                citations[j + 1] = citations[j];
                j = j - 1;
            }
            citations[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        HIndex hi = new HIndex();
        int[] citations = {11,15};
        System.out.println(hi.hIndex(citations));
    }
}
