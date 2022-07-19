package Extras.Recursion.SubsetPattern;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinationsLC("", "23"));
    }

    static List<String> letterCombinations(String p, String up) {
        // base condition
        if (up.isEmpty()) {
            List<String> l = new ArrayList<>();
            l.add(p);
            return l;
        }

        List<String> ans = new ArrayList<>();

        int digit = up.charAt(0) - '0'; // '2' - '0' = 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(letterCombinations(p + ch, up.substring(1)));
        }

        return ans;
    }

    static List<String> letterCombinationsLC(String p, String up) {
        // base condition
        if (up.isEmpty()) {
            List<String> l = new ArrayList<>();
            l.add(p);
            return l;
        }

        List<String> ans = new ArrayList<>();

        int digit = up.charAt(0) - '0'; // '2' - '0' = 2

        int start = (digit - 2) * 3;
        int end = (digit - 1) * 3;

        if (digit == 7) {
            end += 1;
        } else if (digit == 8) {
            start += 1;
            end += 1;
        } else if (digit == 9) {
            start += 1;
            end += 2;
        }


        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(letterCombinationsLC(p + ch, up.substring(1)));
        }

        return ans;
    }
}
