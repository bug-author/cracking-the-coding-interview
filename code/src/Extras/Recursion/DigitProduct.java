package Extras.Recursion;

public class DigitProduct {
    public static void main(String[] args) {
        System.out.println(func(55));
    }

    public static int func(int n){
        if (n%10 == n){
            // only 1 digit is remaining
            return n;
        }

        return n%10 * func(n / 10);
    }
}
