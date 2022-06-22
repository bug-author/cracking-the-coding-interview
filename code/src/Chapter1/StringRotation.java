package Chapter1;

public class StringRotation {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(roateString(s, goal));
    }

    static boolean roateString(String s, String goal){
        s = s + s;
        return s.contains(goal);
    }
}
