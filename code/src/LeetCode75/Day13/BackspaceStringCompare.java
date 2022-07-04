package LeetCode75.Day13;

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        System.out.println(backspaceCompare(s, t));
    }

    public boolean backspaceCompareBruteForce(String s, String t) {
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (one.length() == 0) {

                } else {
                    one.deleteCharAt(one.length() - 1);
                }
            } else {
                one.append(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (two.length() == 0) {

                } else {
                    two.deleteCharAt(two.length() - 1);
                }
            } else {
                two.append(ch);
            }
        }

        return one.toString().equals(two.toString());
    }

    public static boolean backspaceCompare(String s, String t) {
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();

        Stack<Character> ss = new Stack<>();
        Stack<Character> ts = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '#'){
                if(ss.isEmpty()){}
                else{
                    ss.pop();
                }
            }
            else{
                ss.push(ch);
            }
        }

        for(char ch: t.toCharArray()){
            if(ch == '#'){
                if(ts.isEmpty()){}
                else{
                    ts.pop();
                }
            }
            else{
                ts.push(ch);
            }
        }

        while(!ss.isEmpty()){
            one.append(ss.pop());
        }

        while(!ts.isEmpty()){
            two.append(ts.pop());
        }

        return one.toString().equals(two.toString());
    }
}

