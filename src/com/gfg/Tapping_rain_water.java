package com.gfg;

public class Tapping_rain_water
{
    static long trappingWater(int arr[], int n) {
        // Your code here
        if(n == 0) return 0;
        // two pointers
        int left = 0;
        int right = n - 1;

        // check values
        int leftMax = arr[0];
        int rightMax = arr[right];
        long res = 0;
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, arr[left]);
                res += leftMax - arr[left];
            }
            else{
                right--;
                rightMax = Math.max(rightMax, arr[right]);
                res += rightMax - arr[right];
            }
        }
        return res;
    }
}
