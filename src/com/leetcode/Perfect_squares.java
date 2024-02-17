package com.leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/perfect-squares/description/?envType=daily-question&envId=2024-02-08

//Approaches
//        (Also explained in the code)
//
//        Dynamic Programming: Utilizes dynamic programming to find the minimum number of perfect squares that sum up to the given number n.
//
//        Initialization: Initializes a vector dp of size n + 1 where each element is initialized to INT_MAX, except dp[0] which is set to 0 since it doesn't require any perfect squares to represent.
//
//        Iterative Calculation: Iterates from 1 to n to calculate the minimum number of perfect squares required for each number.
//
//        Inner Loop: For each number i, iterates over all perfect squares less than or equal to i (from 1 to sqrt(i)) to find the minimum number of perfect squares required.
//
//        Updating dp[i]: Updates dp[i] with the minimum value found by comparing it with the current value of dp[i - j * j] + 1, where j * j represents the perfect square being considered.
//
//        Complexity
//        Time complexity:
//        O(n∗sqrt(n))
//
//        Space complexity:
//        O(n)
class Sol {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min_val = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                min_val = Math.min(min_val, dp[i - j * j] + 1);
            }
            dp[i] = min_val;
        }
        return dp[n];
    }
}
public class Perfect_squares {
    public static void main(String[] args) {
        Sol s = new Sol();

        System.out.println(s.numSquares(12));
    }
}
