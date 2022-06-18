package Chapter1;

import java.io.CharConversionException;
import java.util.HashMap;

public class PalindromePermutation {
    public static void main(String[] args) {
        String o = "Tact Coa";
        String o2 = "apa";
        String o3 = "apap";
        String o4 = "apapp"; // true apppa
        String o5 = "TaAt";
        String o6 = "T a t";
        String o7 = "ap"; // false
        String o8 = "appp"; // false

        System.out.println(palindromePermutation(o));
        System.out.println(palindromePermutation(o2));
        System.out.println(palindromePermutation(o3));
        System.out.println(palindromePermutation(o4));
        System.out.println(palindromePermutation(o5));
        System.out.println(palindromePermutation(o6));
        System.out.println(palindromePermutation(o7));
        System.out.println(palindromePermutation(o8));
    }

    public static boolean palindromePermutation(String original){
        // hash map
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch: original.toLowerCase().toCharArray()){
            if (ch == ' ') continue;
            if (map.containsKey(ch)){
                // if just count is reduced by 1 then for test string 04, ppp will result in {p : -1} with wrong ans
                // so just remove the character from keys of map
                map.remove(ch);
            }
            else {
                map.put(ch, 1);
            }
        }

        int sum = 0;

        for (int num: map.values()){
            sum += num;
        }

        // even number of characters cancel each other according to above logic
        // for palindrome permutation
        // if string is even length -> string must have all even count of charaters
        // if string is odd length -> there should be only 1 character with odd count
        boolean isStringEvenLength = (original.replaceAll(" ", "").length()) % 2 == 0 ? true : false;
        if (isStringEvenLength){
            if (sum == 0) return true;
        } else {
            // sum should be odd count
            if (sum % 2 == 1) return true;
        }
        return false;
    }
}
