package Extras.Recursion;

public class LinearSearch {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,11,2,-2};
        int[] arr2 = {1,2,13,4,5,11,2,3};
        int[] arr3 = {1,2,13,4,5,11,2,3};
        System.out.println(linearSearchRecursive(arr, -2, 0));
        System.out.println(linearSearchRecursive(arr2, -2, 0));
        System.out.println(linearSearchRecursive(arr3, 3, 0));
    }

    private static boolean linearSearchRecursive(int[] arr, int target, int idx){
        // base condition
        if (idx == arr.length) return false;

        // recursive calls
        // check at current index, return if found
        // OR
        // check in the remaining array linearly
        return arr[idx] == target || linearSearchRecursive(arr, target, idx+1);
    }

}
