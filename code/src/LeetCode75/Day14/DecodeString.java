package LeetCode75.Day14;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

    }

    public String decodeString(String s) {
        Stack<Integer> is = new Stack<>();
        Stack<String> ss = new Stack<>();
        String res = "";
        int ptr = 0;

        while (ptr < s.length()) {
            if (Character.isDigit(s.charAt(ptr))) {
                int num = 0;

                while (Character.isDigit(s.charAt(ptr))) {
                    // System.out.println("## "+ s.charAt(ptr)+" "+"## "+(s.charAt(ptr)-'0'));
                    num = num * 10 + s.charAt(ptr) - '0';
                    ptr += 1;
                }

                is.push(num);
            } else if (s.charAt(ptr) == '[') {
                // push current string to stack, reset the string, and increment position pointer
                ss.push(res);
                res = "";
                ptr += 1;
            } else if (s.charAt(ptr) == ']') {
                StringBuilder sb = new StringBuilder(ss.pop());
                int count = is.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                ptr += 1;
            } else {
                res += s.charAt(ptr);
                ptr += 1;
            }
        }
        return res;
    }
}
