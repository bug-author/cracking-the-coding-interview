package LeetCode75.Day1;

import java.util.Arrays;

public class RunningSumOf1DArray {
    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(test)));
    }
    static int[] runningSum(int[] nums) {
        // gfg Prefix Sum Array
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            if (i == 0) {
                ans[i] = nums[i];
            }
            else {
                ans[i] = ans[i - 1] + nums[i];
            }
        }

        return ans;
    }
}
