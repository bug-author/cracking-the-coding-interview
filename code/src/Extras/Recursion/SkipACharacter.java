package Extras.Recursion;

public class SkipACharacter {
    public static void main(String[] args) {
        // jashan hai!!!
        String output = skipACharacterMy("baccadh", 0);
        System.out.println(output);

        skipACharacter("", "baccdah");

        System.out.println(skipACharacter("baccdah"));

    }

    static String skipACharacterMy(String str, int idx) {
        // my implementation without looking at the final code
        // base condition len -> 0
        if (idx == str.length()) {
            return "";
        }

        if (str.charAt(idx) == 'a') {
            return "" + skipACharacterMy(str, idx + 1);
        } else {
            return str.charAt(idx) + skipACharacterMy(str, idx + 1);
        }
    }

    static void skipACharacter(String p, String up) {
        // base condition
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            skipACharacter(p, up.substring(1));
        } else {
            skipACharacter(p + ch, up.substring(1));
        }
    }

    static String skipACharacter(String input) {
        // base condition
        if (input.isEmpty()) {
            return "";
        }

        if (input.charAt(0) == 'a') {
            return skipACharacter(input.substring(1));
        } else {
            return input.charAt(0) + skipACharacter(input.substring(1));
        }
    }
}
