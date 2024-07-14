package com.dp;

//https://leetcode.com/problems/maximum-sum-of-subsequence-with-non-adjacent-elements/solutions/5209269/simple-java-solution-all-5-dp-approaches/


// approcach 1
// tc - o[n] sc - o[n]
public class MaxSubsequenceNonAdjacent {
    class Solution {
        public int maximumSumSubsequence(int[] nums, int[][] queries) {
            int prev = nums[0];
            int prev2 = 0;
            for(int i = 1; i < nums.length; i++) {
                nums[queries[i - 1][0]] = queries[i - 1][0];
                int take = nums[i];
                if(i > 1) take += prev2;

                int nonTake = prev;
                int curi = Math.max(take, nonTake);
                prev2 = prev;
                prev = curi;
            }
            return prev;
        }
    }
}


// approach 2
// tc - o[n] sc - o[1]
class Solution {
    private static final int MOD = 1_000_000_007;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int sum = 0;
        for (int i = 0; i < q; i++) {
            int pos = queries[i][0];
            int newValue = queries[i][1];
            nums[pos] = newValue;
            sum = (sum + maxNonAdjacentSum(nums)) % MOD;
        }
        return sum;
    }

    private int maxNonAdjacentSum(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return Math.max(0, nums[0]);

        int[] dp = new int[nums.length];
        dp[0] = Math.max(0, nums[0]);
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

}
