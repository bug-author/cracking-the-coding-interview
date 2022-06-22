package LeetCode75.Day2;

public class IsSubsequence {
    public static void main(String[] args){
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;

        int sp = 0;
        int tp = 0;

        while (tp < t.length() && sp < s.length()){
            if (t.charAt(tp) == s.charAt(sp)){
                sp += 1;
            }
            tp += 1;
        }

        if (sp == s.length()) return true;
        return false;
    }
}
