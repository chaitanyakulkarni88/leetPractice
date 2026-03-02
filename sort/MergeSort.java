/**
 * Algorithm: Merge Sort (Top-Down Recursive)
 *
 * Time Complexity:
 *   Best Case   : O(n log n)
 *   Average     : O(n log n)
 *   Worst Case  : O(n log n)
 *
 * Space Complexity:
 *   O(n) auxiliary space
 *
 * Core Idea:
 * 1. Divide array into two halves.
 * 2. Recursively sort each half.
 * 3. Merge two sorted halves into original array.
 *
 * Notes:
 * - Stable sorting algorithm.
 * - Not in-place (requires extra space).
 * - Divide and Conquer strategy.
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSortHelper(arr, left, mid);
        mergeSortHelper(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
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

        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}