package LeetCode75.Day1;

public class FindPivotIndex {
    public static void main(String[] args){
        int[] test1 = {1,7,3,6,5,6};
        int[] test2 = {1,2,3};
        int[] test3 = {2,1,-1};

        System.out.println(pivotIndex(test1));
        System.out.println(pivotIndex(test2));
        System.out.println(pivotIndex(test3));
    }

    static int pivotIndex(int[] nums){
        int[] prefixSum = new int[nums.length];

        // calculate left sums
        for(int i=0; i < nums.length; i++){
            if (i == 0) {
                prefixSum[0] = nums[0];
            }
            else {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }

        for (int i=0; i < nums.length; i++){
            int left = 0;
            int right = 0;

            if (i == 0){
                right = prefixSum[prefixSum.length - 1] - nums[i];
                if (left == right){
                    return i;
                }
            }

            if (i > 0 && i < nums.length - 1){
                left = prefixSum[i-1];
                // right => totalSum - leftSum - value at current Index
                right = prefixSum[prefixSum.length - 1] - left - nums[i];

                if (left == right){
                    return i;
                }
            }

            if (i == nums.length - 1){
                left = prefixSum[i-1];
                if (right == left){
                    return i;
                }
            }
        }
        return -1;
    }
}
