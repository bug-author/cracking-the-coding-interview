package LeetCode75.Day5;
import java.util.HashMap;

// leetcode 409
public class LongestPalindrome {
    public static void main(String[] args) {
        String one = "abccccdd";
        String two = "a";
        System.out.println(longestPalindrome(one));
        System.out.println(longestPalindrome(two));
    }

    public static int longestPalindromeHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        //
        int len = 0;
        boolean firstOdd = false;

        // https://www.geeksforgeeks.org/hashmap-keyset-method-in-java/
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 0) {
                len += map.get(key);
            } else {
                if (!firstOdd) {
                    // first odd just occured
                    firstOdd = true;
                    len += map.get(key);
                } else {
                    len += (map.get(key) - 1);
                }
            }
        }
        return len;
    }

    public static int longestPalindrome(String s) {
        // optimized using char arrays since overhead of hashing is less now

        //https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/ASCII-Table-wide.svg/875px-ASCII-Table-wide.svg.png
        // a -- 97
        // A -- 65

        char[] smalls = new char[26];
        char[] caps = new char[26];

        for (char ch : s.toCharArray()) {
            if (ch - 97 >= 0) {
                smalls[ch - 97] += 1;
            } else {
                caps[ch - 65] += 1;
            }
        }

        int len = 0;
        boolean firstOdd = false;

        for (int i = 0; i < smalls.length; i++){
            if (smalls[i] % 2 == 0){
                len += smalls[i];
            }
            else {
                if (!firstOdd){
                    firstOdd = true;
                    len += smalls[i];
                }
                else {
                    len += smalls[i] - 1;
                }
            }
        }

        for (int i = 0; i < caps.length; i++){
            if (caps[i] % 2 == 0){
                len += caps[i];
            }
            else {
                if (!firstOdd){
                    firstOdd = true;
                    len += caps[i];
                }
                else {
                    len += caps[i] - 1;
                }
            }
        }

        return len;
    }
}
