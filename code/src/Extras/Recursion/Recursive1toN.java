package Extras.Recursion;

public class Recursive1toN {
    public static void main(String[] args) {
        fun(3 ); // 1 2 3 4 5
    }

    public static void fun(int n) {
        if (n == 0) return;

        fun(n-1);
        System.out.println(n);
    }
}
