package LeetCode75.Day15;

import java.util.*;

public class topKFrequent {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }
    public static List<String> topKFrequent(String[] words, int k) {

        List<String>[] bucket = new List[words.length + 1];

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }

        for (String key : map.keySet()) {
            int freq = map.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        List<String> ans = new ArrayList<>();

        int count = 0;

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    ans.add(bucket[i].get(j));
                    count += 1;
                }
            }
            if (count == k) break;
        }

        for (int i = 0; i < ans.size(); i++) {

        }

        return  ans;
    }

}
