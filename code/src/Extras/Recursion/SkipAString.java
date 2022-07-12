package Extras.Recursion;

public class SkipAString {
    public static void main(String[] args) {
        System.out.println(skipAString("Stufffromappleisveryexpensive", "apple"));

        System.out.println(skipAppNotApple("ThisIsAStringHavingappAndappleAsSubstrings"));
    }

    static String skipAString(String str, String skip){
        // base condition
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith(skip)){
            return skipAString(str.substring(skip.length()), skip);
        }
        else{
            return str.charAt(0) + skipAString(str.substring(1), skip);
        }
    }

    static String skipAppNotApple(String str){
        /*
        * skip the substring app only when "app" is a part of string, but not when "apple" is part of string
        * app -> skip
        * apple -> don't skip
        * */

        // base condition
        if(str.isEmpty()){
            return "";
        }

        // app skip
        // asdsd dont skip
        // apple dont skip


        if(str.startsWith("app") && !str.startsWith("apple")){
            // !str.substring(3).startsWith("le")
            // skip
            return skipAppNotApple(str.substring(3)); // "app".length() is 3
        }
        else {
            // dont skip
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }
}
