package Extras.Recursion;

public class CountZeros {
    public static void main(String[] args) {
        int number = 3020;
        int ans = countZeros(number, 0);
        System.out.println(ans);
    }

    public static int countZeros(int number, int count) {
        // base condition
        if (number == 0) return count;

        // algorithm:
        /*
         * divide number by zero recursively
         * count++ if num % 0 recursively
         * eg
         * 3020
         * 3020/10 = 302 ... 0
         * */

        // recursive calls
        if (number % 10 == 0){
            count += 1;
            return countZeros(number / 10, count);
        }
        else {
            return countZeros(number / 10, count);
        }
    }
}
