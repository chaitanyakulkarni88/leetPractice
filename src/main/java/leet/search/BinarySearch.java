package leet.search;

public class BinarySearch {
//O(log n)
    static boolean binarySearch(int[] arr, int numberToSearch) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            // Find the mid index
            int mid = (left + right) / 2;

            // Check at mid index
            if (arr[mid] == numberToSearch)
                return true;

            // Update the terminal indices
            if (arr[mid] < numberToSearch) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,6,8,9,11,21};
        System.out.println(BinarySearch.binarySearch(arr,11));
    }

}
