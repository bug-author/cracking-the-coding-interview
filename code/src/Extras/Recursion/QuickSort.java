package Extras.Recursion;

import java.util.Arrays;

public class QuickSort {
    // choose a pivot
    // after 1 pass, elements < pivot will be on left and elements > pivot will be on right
    // in other words
    // after each pass, pivot will be at its correct position

    // optimization over merge sort:
    // in merge sort even if the array is sorted, recursive calls go till very end

    public static void main(String[] args) {
        int[] test1 = {5, 4, 6, 23, 14, 0};
        quickSort(test1, 0, test1.length - 1);
        System.out.println(Arrays.toString(test1));
    }

    static void quickSort(int[] nums, int low, int high) {
        // base condition
        if (low >= high) {
            return;
        }

        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {
            while (nums[s] < pivot) {
                s += 1;
            }

            while (nums[e] > pivot) {
                e -= 1;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s += 1;
                e -= 1;
            }
        }
        // recursive call
        quickSort(nums, low, e);
        quickSort(nums, s, high);

    }

}
