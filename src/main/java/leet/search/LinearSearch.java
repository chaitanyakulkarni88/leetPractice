package leet.search;

public class LinearSearch {
//O(n)
    public static boolean linearSearch(int[] arr, int numberToSearch) {

        boolean found = false;

        // Search sequentially through each element
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == numberToSearch) {
                found = true;
                break;
            }

        }

        return found;
    }

    public static boolean sortedLinearSearch(int[] arr, int numberToSearch) {

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == numberToSearch)
                found = true;

            // If arr[i] is greater than the numberToSearch, we can simply exit
            // as we would not be able to find the number further
            if (arr[i] > numberToSearch)
                break;
        }

        return found;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,1,8,5,2,3};
        int[] arr2 = {1,4,6,8,9,11,21};

        System.out.println(LinearSearch.linearSearch(arr1,5));
        System.out.println(LinearSearch.sortedLinearSearch(arr2,6));

    }

}
