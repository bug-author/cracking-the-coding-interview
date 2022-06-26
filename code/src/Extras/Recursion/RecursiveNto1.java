package Extras.Recursion;

public class RecursiveNto1 {
    public static void main(String[] args) {
        fun(5);
    }

    public static void fun(int n) {
        if (n == 0) return;

        // first print then call function for lower n
        System.out.println(n);
        fun(n - 1);
    }
}
