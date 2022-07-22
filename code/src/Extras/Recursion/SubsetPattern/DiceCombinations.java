package Extras.Recursion.SubsetPattern;

import java.util.ArrayList;
import java.util.List;

public class DiceCombinations {
    public static void main(String[] args) {
        int n = 30;
        int k = 30;
        int target = 500;
        List<String> l = new ArrayList<>();
        diceCombinations("",n,k,target, l);
        System.out.println(l.size() % (1000000000 + 7));
    }

    static void diceCombinations(String p, int n, int k, int target, List<String> ans){
        // base condition
        if(target == 0){
            if(p.length() > n){
                return;
            }
            ans.add(p);
            return;
        }

        for(int i=1; i<= target && i <= k; i++){
            diceCombinations(p+i, n, k, target - i, ans);
        }
    }
}
