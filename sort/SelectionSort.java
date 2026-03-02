/**
 * Algorithm: Selection Sort
 *
 * Time Complexity:
 *   Best Case   : O(n^2)
 *   Average     : O(n^2)
 *   Worst Case  : O(n^2)
 *
 * Space Complexity:
 *   O(1) (in-place)
 *
 * Core Idea:
 * 1. Divide array into sorted and unsorted portions.
 * 2. Repeatedly find the minimum element from the unsorted portion.
 * 3. Swap it with the first unsorted element.
 *
 * Notes:
 * - Not stable (unless modified).
 * - Performs minimal number of swaps (at most n-1).
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Avoid unnecessary swap
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {

        if (arr == null) {
            System.out.println("null");
            return;
        }

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original array:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}