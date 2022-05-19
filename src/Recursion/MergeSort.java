package Recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Question: Perform merge sort on an array.
 * Example: arr = [56, -1, 38, -25, 0] -> [-25, -1, 0, 38, 56]
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = in.nextInt();

        MergeSort ms = new MergeSort();

        ms.sort(arr);

        String mergeSort = Arrays.toString(arr);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr).equals(mergeSort));

    }

    void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    void mergeSort(int[] arr, int start, int end) {
        if (start<end) {
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    void merge(int[] arr, int start, int mid, int end) {
        int i = start, j = mid+1, k=0;
        int[] ans = new int[end-start+1];
        while(i<=mid && j<=end) {
            if(arr[i]<arr[j]) {
                ans[k++] = arr[i++];
            } else {
                ans[k++] = arr[j++];
            }
        }
        while(i<=mid) {
            ans[k++] = arr[i++];
        }
        while(j<=end) {
            ans[k++] = arr[j++];
        }
        k=0;
        for(i = start; i<=end; i++) {
            arr[i] = ans[k++];
        }
    }
}
