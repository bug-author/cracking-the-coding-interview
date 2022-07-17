package Extras.Recursion.SubsetPattern;

import java.util.ArrayList;

public class SubSeqAscii {

    public static void main(String[] args) {
        String test = "abc";
        System.out.println(subSeqRetAscii("", "abc"));
    }

    // Method with a return type/ local answer in each recursive call -> harder
    static ArrayList<String> subSeqRetAscii(String p, String up) {

        // base condition
        if (up.length() == 0) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subSeqRetAscii(p + ch, up.substring(1));
        ArrayList<String> right = subSeqRetAscii(p, up.substring(1));
        ArrayList<String> ascii = subSeqRetAscii(p + (ch + 0), up.substring(1));

        left.addAll(right);
        left.addAll(ascii);
        return left;
    }


}
