package Extras.Recursion;

import java.util.Arrays;

public class MergeSort {
    // divide and conquer
    // divide array into 2 parts
    // sort the parts + recursion
    // merge and sort
    public static void main(String[] args) {
        int[] test1 = {55, 63, 434, 123, 9, 0, -123, 324, 5, 4, 4, 6, 7, 8, 2, 1};
        int[] test2 = {2,1,3};
//        System.out.println(Arrays.toString(mergeSort(test1)));
        mergeSortInplace(test2, 0, test2.length - 1);
        System.out.println(Arrays.toString(test2));

    }

    static int[] mergeSort(int[] arr) {
        // base condition
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int lp = 0;
        int rp = 0;
        int ansp = 0;

        int[] ans = new int[left.length + right.length];

        while (lp < left.length && rp < right.length) {
            if (left[lp] <= right[rp]) {
                ans[ansp] = left[lp];
                lp += 1;

            } else {
                ans[ansp] = right[rp];
                rp += 1;

            }
            ansp += 1;
        }

        while (lp < left.length) {
            ans[ansp] = left[lp];
            lp += 1;
            ansp += 1;
        }

        while (rp < right.length) {
            ans[ansp] = right[rp];
            rp += 1;
            ansp += 1;
        }

        return ans;
    }

    static void mergeSortInplace(int[] arr, int start, int end) {
        // base condition
        if (end - start == 1) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSortInplace(arr, start, mid);
        mergeSortInplace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] ans = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                ans[k] = arr[i];
                i += 1;

            } else {
                ans[k] = arr[j];
                j += 1;

            }
            k += 1;
        }

        while (i < mid) {
            ans[k] = arr[i];
            i += 1;
            k += 1;
        }

        while (j < end) {
            ans[k] = arr[j];
            j += 1;
            k += 1;
        }

        for (int l = 0; l < ans.length; l++) {
            arr[start + l] = ans[l];
        }
        
    }
}
