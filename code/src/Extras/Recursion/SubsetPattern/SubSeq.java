package Extras.Recursion.SubsetPattern;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        String test = "abc";
//        printSubSeq("", test);
        System.out.println(subSeqRet("", "abc"));
    }

    static void printSubSeq(String p, String up){
        // base condition
        if(up.length() == 0){
            System.out.println(p);
            return;
        }

        // recursion tree
        /*
        *  p  up
        * ""/ abc
        *
        * "a"/bc && ""/bc
        *
        * "ab"/c && "a"/c && "b"/c && "bc"/0
        *
        * "abc"/0 && "ab"/0 && "ac"/0 && "a"/0 && "bc"/0 && "b"/0 && "bc"/0
        *
        * */
        char ch = up.charAt(0);

        printSubSeq(p+ch, up.substring(1));
        printSubSeq(p, up.substring(1));
    }

    // Method with a return type/ local answer in each recursive call -> harder
    static ArrayList<String> subSeqRet(String p, String up ){

        // base condition
        if(up.length() == 0){
         ArrayList<String> ans = new ArrayList<>();
         ans.add(p);
         return ans;
        }

        char ch = up.charAt(0);

        ArrayList<String> left =  subSeqRet(p+ch, up.substring(1));
        ArrayList<String> right = subSeqRet(p, up.substring(1));

        left.addAll(right);
        return left;
    }
}
