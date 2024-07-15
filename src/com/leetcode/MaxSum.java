package com.leetcode;

import java.util.HashMap;

public class MaxSum {
    public static int subarraySum(int[] nums, int k) {
        // Create a HashMap to store the cumulative sum frequencies
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        // Initialize the map with a base case
        sumMap.put(0, 1);

        int count = 0;
        int sum = 0;

        // Iterate through the array
        for (int num : nums) {
            // Add the current number to the cumulative sum
            sum += num;

            // Check if the (current sum - k) is in the map
            if (sumMap.containsKey(sum - k)) {
                // If it is, it means there exists a subarray ending at the current index
                // which sums to k
                count += sumMap.get(sum - k);
            }

            // Add/update the current cumulative sum in the map
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println(subarraySum(nums2, k2)); // Output: 2
    }
}

