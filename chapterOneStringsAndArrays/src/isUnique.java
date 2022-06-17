import java.util.Arrays;
import java.util.HashMap;

public class isUnique {
    // similar to leetcode 217 (but for characters instead of numbers)
    // https://leetcode.com/problems/contains-duplicate/
    public static void main(String[] args) {
        int[] nums = {1,4,2,3,5};
        boolean ans = containsDuplicateNumbers(nums);
//        System.out.println(ans); // false

        String test1 = "aString";
//        System.out.println(containsDuplicateChars(test1)); // false

        String test2 = "aStringa";
//        System.out.println(containsDuplicateChars(test2)); // true

        System.out.println(containsDuplicateCharsNoSpace(test1)); // false
        System.out.println(containsDuplicateCharsNoSpace(test2)); // true
    }

    public static boolean containsDuplicateNumbers(int[] nums){
        // using space -> counter
        // cant use int
        // type arg can not be primitive  type
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int number: nums){
            if (map.containsKey(number)){
                return true;
            } else {
                map.put(number, 1);
            }
        }
        return false;
    }

    // ctci isUnique -> characters
    // using space
    public static boolean containsDuplicateChars(String input){
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char ch: input.toCharArray()){
            if (map.containsKey(ch)){
                return true;
            }
            else {
                map.put(ch, true);
            }
        }
        return false;
    }

    // What if you can not use additional data structures
    // mo map
    public static boolean containsDuplicateCharsNoSpace(String input){
        // sort the array
        // if two consecutive characters are same, return true
        char[] sortedString = input.toCharArray();

        // Arrays.sort is in-place sorting, doesnt return anything
        Arrays.sort(sortedString);

        for(int i=0; i+1 < sortedString.length; i++){
            if (sortedString[i] == sortedString[i+1]){
                return true;
            }
        }

        return false;
    }
}
