/**
 * Algorithm: Bubble Sort (Optimized)
 *
 * Time Complexity:
 *   Best Case   : O(n)      (already sorted, early exit)
 *   Average     : O(n^2)
 *   Worst Case  : O(n^2)
 *
 * Space Complexity: O(1)
 *
 * Core Idea:
 * 1. Repeatedly compare adjacent elements.
 * 2. Swap if out of order.
 * 3. After each pass, largest unsorted element "bubbles up" to its correct position.
 * 4. Stop early if no swaps occur in a full pass (array already sorted).
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // Early termination if no swaps happened
            if (!swapped) {
                break;
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

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}