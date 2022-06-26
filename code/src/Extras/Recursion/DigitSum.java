package Extras.Recursion;

public class DigitSum {
    public static void main(String[] args) {
        System.out.println(func(-1342));
    }

    public static int func(int n){
        if (n == 0){
            return 0;
        }

        /*
        * 1342
        * 1 + 342
        *     3 + 42
        *
        * 1342 / 10 = 134
        * 1342 % 10 = 2
        * */
        return n%10 + func(n/10);
        // 2 + f(134) . 2 + 4 + f(13) . 2 + 4 + 3 + f(1) = 2 + 4 + 3 + 1
    }
}
