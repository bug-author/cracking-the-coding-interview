package Extras.Recursion.SubsetPattern;

import java.util.ArrayList;
import java.util.List;

public class DiceCombinations {
    public static void main(String[] args) {
        int n = 2;
        int k = 6;
        int target = 7;
        List<String> l = new ArrayList<>();
        diceCombinations("",n,k,target, l);
        System.out.println(l.size() % (1000000000 + 7));
//        System.out.println(l);
    }

    static void diceCombinations(String p, int n, int k, int target, List<String> ans){
        // base condition
        if(target == 0){
            System.out.println(p);
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
