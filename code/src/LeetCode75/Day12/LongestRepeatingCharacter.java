package LeetCode75.Day12;

import java.util.Collections;
import java.util.HashMap;

public class LongestRepeatingCharacter {
    public int characterReplacement(String s, int k) {
        // https://www.youtube.com/watch?v=gqXU1UyA8pk&ab_channel=NeetCode
        HashMap<Character, Integer> count = new HashMap<>();

        int result = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (count.containsKey(s.charAt(right))) {
                count.put(s.charAt(right), count.get(s.charAt(right)) + 1);
            } else {
                count.put(s.charAt(right), 1);
            }

            // right - left + 1 is window size
            if (((right - left + 1) - Collections.max(count.values())) > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left += 1;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

}
