package com.pratham;

public class MissingPositive {
    public static void main(String[] args) {
        int[] arr = {4, 0, 2, 1};
        int ans = missingNumber(arr);
        System.out.println(ans);
    }
    public static int missingNumber(int[] nums) {
        int i = 0;
        while( i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]){
                swapArray(nums, i, correctIndex);
            }
            else {
                i++;
            }
        }
        // search for first missing number
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1){
                return j + 1;
            }
        }
        return nums.length + 1 ;
    }
    static void swapArray(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
