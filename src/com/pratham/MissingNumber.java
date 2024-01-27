package com.pratham;

import java.util.Arrays;

// https://leetcode.com/problems/missing-number/
// Amazon Question
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {4, 0, 2, 1};
        int ans = missingNumber(arr);
        System.out.println(ans);
    }
    public static int missingNumber(int[] nums) {
        int i = 0;
        while( i < nums.length){
            int correctIndex = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]){
                swapArray(nums, i, correctIndex);
            }
            else {
                i++;
            }
        }
        // search for first missing number
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }
    static void swapArray(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}