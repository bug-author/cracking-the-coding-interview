package Chapter1;

import java.util.HashMap;

public class OneAway {
    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple")); // true
        System.out.println(oneAway("pales", "pale")); // true
        System.out.println(oneAway("pale", "bale")); // true
        System.out.println(oneAway("pale", "bake")); // false
        System.out.println(oneAway("ab", "acb")); // true
        System.out.println(oneAway("cab", "ad")); // false
        System.out.println(oneAway("1203", "1213")); // ture
    }
    public static boolean oneAway(String one, String two){
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch: one.toCharArray()){
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else {
                map.put(ch, 1);
            }
        }

        for (char ch: two.toCharArray()){
            if (map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
            }
            else {
                map.put(ch, 1);
            }
        }

        int sum = 0;
        for (int num: map.values()){
            sum += num;
        }

        if (sum <= 2) return true;


        return false;
    }
}
