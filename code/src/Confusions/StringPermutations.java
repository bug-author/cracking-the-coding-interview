package Confusions;

public class StringPermutations {
    public static void main(String[] args) {
        permutations("", "abc");
    }

    static void permutations(String p, String up) {
        // base condition
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        // recursive calls
        for (int i = 0; i < up.length(); i++) {
            char ch = up.charAt(i);
            permutations(p + ch,  up.substring(0, i) + up.substring(i + 1));
        }
    }
}
