/**
 * Algorithm: Counting Sort (Stable Version)
 *
 * Time Complexity:
 *   O(n + k)
 *   n = number of elements
 *   k = value range (max - min + 1)
 *
 * Space Complexity:
 *   O(n + k)
 *
 * Core Idea:
 * 1. Find min and max to determine range.
 * 2. Count frequency of each number.
 * 3. Convert frequency array into prefix sum array.
 * 4. Traverse input in reverse to maintain stability.
 * 5. Copy sorted result back to original array.
 *
 * Notes:
 * - Works best when k is not significantly larger than n.
 * - Handles negative numbers using offset (min).
 * - Stable sorting algorithm.
 */
public class CountingSort {

    public static void countingSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }

        int min = arr[0];
        int max = arr[0];

        // Find min and max manually (avoids stream overhead)
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Step 1: Count frequency
        for (int num : arr) {
            count[num - min]++;
        }

        // Step 2: Convert to prefix sum
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build output (reverse for stability)
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            output[count[num - min] - 1] = num;
            count[num - min]--;
        }

        // Step 4: Copy back
        System.arraycopy(output, 0, arr, 0, arr.length);
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

        int[] arr = {4, 2, 2, 8, 3, 3, 1, -1, 5};

        System.out.println("Original array:");
        printArray(arr);

        countingSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}