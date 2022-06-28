package Extras.Recursion;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 4, 6, 5, 9};
        System.out.println(isArraySorted(arr, 0));
        System.out.println(isArraySorted(arr2, 0));
    }

    static boolean isArraySorted(int[] arr, int idx) {
        // check two elements in one recursive call
        // check if element at i and i+1 are sorted && check whether
        // other elements are sorted (recursive(

        // isArraySorted(arr, startingIndex) && isArraySorted(arr, startingIndex+1)
        // if at any instance, not sorted return false
        // if sorted and index == array.length , return

        // base condition
        if (idx+1 >= arr.length)
            // since if we reach the end of array without getting false
            // throughout, it means array is sorted
            return true;

        // check sorted
        return (arr[idx] < arr[idx + 1]) && isArraySorted(arr, idx + 1);
    }
}
