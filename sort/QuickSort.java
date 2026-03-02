/**
 * Algorithm: Quick Sort (Lomuto Partition Scheme)
 *
 * Time Complexity:
 *   Best Case   : O(n log n)
 *   Average     : O(n log n)
 *   Worst Case  : O(n^2) (already sorted with bad pivot choice)
 *
 * Space Complexity:
 *   O(log n) average (recursion stack)
 *   O(n) worst case
 *
 * Core Idea:
 * 1. Choose a pivot element.
 * 2. Partition array so that:
 *      - Elements < pivot are on left
 *      - Elements > pivot are on right
 * 3. Recursively apply to left and right partitions.
 *
 * Notes:
 * - In-place sorting algorithm.
 * - Not stable.
 * - Performance depends on pivot selection.
 */
public class QuickSort {

    public static void quickSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    // Lomuto partition
    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
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

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {10, 7, 8, 9, 1, 5};

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}