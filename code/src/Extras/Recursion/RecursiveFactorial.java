package Extras.Recursion;

public class RecursiveFactorial {
    public static void main(String[] args) {
        System.out.println(fact(5));

        System.out.println(fact(-3));
    }

    static int fact(int n) {

        // <= will also handle negative number input
        if (n <= 1) return 1;

        return n * fact(n - 1);
    }

    // f(3) . 3 * f(2) . 2 * f(1) . true . ret 1 . 2 * 1 . 3 * 2 * 1

}
