package LeetCode75.Day13;

public class BullsAndCows {
    public static void main(String[] args) {
        String guess = "0111";
        String secret = "1123";

        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        int[] bucket = new int[10];
        int bulls = 0;
        int cows = 0;

        for(int i = 0; i < secret.length(); i++){
            if (secret.charAt(i) == guess.charAt(i)){
                bulls += 1;
            }
            else {
                int s = Character.getNumericValue(secret.charAt(i));
                int g = Character.getNumericValue(guess.charAt(i));

                bucket[s] += 1;
                bucket[g] -= 1;
            }
        }
        for (int i : bucket) {
            if (i > 0) {
                cows += i;
            }
        }

        cows = secret.length() - bulls - cows;

        return bulls+"A"+cows+"B";
    }

}
