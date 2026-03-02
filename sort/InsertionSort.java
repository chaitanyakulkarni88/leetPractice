/**
 * Algorithm: Insertion Sort
 *
 * Time Complexity:
 *   Best Case   : O(n)      (already sorted)
 *   Average     : O(n^2)
 *   Worst Case  : O(n^2)
 *
 * Space Complexity:
 *   O(1) (in-place)
 *
 * Core Idea:
 * 1. Treat first element as sorted.
 * 2. Pick next element and insert it into correct position
 *    in the sorted portion by shifting larger elements right.
 * 3. Repeat until array is fully sorted.
 *
 * Notes:
 * - Stable sorting algorithm.
 * - Efficient for small or nearly sorted arrays.
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    private static void printArray(int[] arr) {

        if (arr == null) {
            System.out.println("null");
            return;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}