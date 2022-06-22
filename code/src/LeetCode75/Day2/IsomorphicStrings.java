package LeetCode75.Day2;

import java.util.HashMap;

public class IsomorphicStrings {
    // leetcode 205
    public static void main(String[] args){
        /*
        * Given two strings s and t, determine if they are isomorphic.
        *
        * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
        *
        * All occurrences of a character must be replaced with another character while preserving the order of characters.
        * No two characters may map to the same character, but a character may map to itself.
        *
        * OBSERVATIONS
        * map characters in s to characters in t
        * 1. a character x in s can be mapped to only a character y in t
        *    if z wants to be mapped to x but x is already mapping to y -> false
        *
        * 2. key in s can only map to 1 unique value in t
        *
        * 3. No two keys can map to 1 value (ofc the previous one would be overwritten, but we need to check
        *    if its already present then return false)
        *
        * 4. no value can be mapped to more than 1 keys
        *
        * */
        String s = "bar";
        String t = "foo";
        System.out.println(isIsomorphic(s, t));

    }
    static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] _s = s.toCharArray();
        char[] _t = t.toCharArray();
        for (int i=0; i < _s.length; i++){


            if (!map.containsKey(_s[i])){
                // if another key wants to map to already present value -> false
                if (map.containsValue(_t[i])) return false;

                map.put(_s[i], _t[i]);
            }

            else {
                // if key already present
                // 1. either the value is repeated -> no issue
                // 2. another character wants to be mapped to same key -> mo
                if (map.get(_s[i]) == _t[i]){
                    ; // do nothing
                }
                else return false;
            }
        }


        return true;
    }
}
