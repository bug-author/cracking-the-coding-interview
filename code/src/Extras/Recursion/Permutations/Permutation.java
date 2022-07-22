package Extras.Recursion.Permutations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
//        String test = "a";
//        System.out.println(test.substring(0,1));
        permutation("", "abc");
//        System.out.println(permutationRet("", "abc"));
//        System.out.println(permutationCount("", "abc"));
    }

    static void permutation(String p, String up) {
        // base condition
        if (up.length() <= 0) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            permutation(first + ch + second, up.substring(1));
        }
    }

    private static ArrayList<String> permutationRet(String p, String up) {
        // base condition
        if (up.length() <= 0) {
            ArrayList<String> l = new ArrayList<>();
            l.add(p);
            return l;
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            ans.addAll(permutationRet(first + ch + second, up.substring(1)));
        }

        return ans;
    }

    private static int permutationCount(String p, String up) {
        int count = 0;
        // base condition
        if (up.length() <= 0) {
            // yahan se recursion khatam hogi, function wapis main nahi jayega ;;;;;)j
            return 1;
        }

        char ch = up.charAt(0);


        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i);
            count += permutationCount(first + ch + second, up.substring(1));
        }

        return count;
    }

}
