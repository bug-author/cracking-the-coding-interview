package Chapter1;

import java.util.HashMap;

public class CheckPermutation {
    // similar questions leetcode 242 valid anagram
    // leetcode 567 Permutation in a String
    public static void main(String[] args) {

        System.out.println(validAnagram("aacc", "ccac"));

    }

    public static boolean validAnagram(String s, String t){
        int sum;

        if (s.length() > t.length()){
            sum = computeSum(s, t);
        }
        else {
            sum = computeSum(t, s);
        }

        if (sum > 0) return false;
        return true;
    }

    public static int computeSum(String one, String two){
        HashMap<Character, Integer> map = new HashMap<>();

        // assuming string one to be of greater length
        for (char ch: one.toCharArray()){
//            System.out.println("VALUES 1: "+map.values());
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else {
                map.put(ch, 1);
            }
        }

        for (char ch: two.toCharArray()){
//            System.out.println("VALUES 2: "+map.values());
            if (map.containsKey(ch)){
                // if it gets below 0 it means there's extra character so its not a permutation
                if(map.get(ch) - 1 < 0) return 1;
                map.put(ch, map.get(ch) - 1);
            }
        }

        int sum = 0;

        for(int num: map.values()){
            sum += num;
        }

        return sum;
    }

}
