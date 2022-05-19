package Recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question: Perform quick sort on integer array.
 * Example: [34, 1, -1, 4, 2] -> [-1, 1, 2, 4, 34]
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = in.nextInt();

        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionindex = partition(arr, start, end);
            quickSort(arr, start, partitionindex - 1);
            quickSort(arr, partitionindex + 1, end);
        }
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int count = 0;
        for (int i = start+1; i <= end; i++) {
            if (arr[i] <= pivot) count++;
        }

        int pivotIndex = start + count;
        arr[start] = arr[pivotIndex];
        arr[pivotIndex] = pivot;
        int i = start, j = end;
        while (i < j) {
            while (i <= end && arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if(i<j) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }
        return pivotIndex;
    }
}

//39
//38 1 23 13 98 643 78 64 79 65 78 65 78 865 89 76 28 283 1 38 18 28 18 388 13 047 193 963 29 488 3 20 2 488 3884 38 3 85 3