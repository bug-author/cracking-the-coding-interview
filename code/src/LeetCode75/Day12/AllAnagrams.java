package LeetCode75.Day12;

import java.util.ArrayList;
import java.util.List;

public class AllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // https://www.youtube.com/watch?v=aZwMXTtEGPo&ab_channel=Codebix
        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) return ans;

        int N = s.length();
        int M = p.length();

        int[] count = frequency(p);
        int[] currentCount = frequency(s.substring(0, M));

        if (areSame(currentCount, count)) {
            ans.add(0);
        }

        int i;
        for (i = M; i < N; i++) {
            currentCount[s.charAt(i - M) - 'a'] -= 1;
            currentCount[s.charAt(i) - 'a'] += 1;

            if (areSame(currentCount, count)) {
                ans.add(i - M + 1);
            }
        }

        return ans;
    }

    private int[] frequency(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }

        return freq;
    }

    private boolean areSame(int[] x, int[] y) {
        for (int i = 0; i < 26; i++) {
            if (x[i] != y[i]) {
                return false;
            }
        }
        return true;
    }

}
