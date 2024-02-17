package com.gfg;

//https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1?page=1&difficulty=Medium,Hard&sortBy=submissions
public class Minimum_Jumps {
    public static void main(String[] args) {
        int[] arr = {
        10, 14, 29, 21, 17, 4, 18, 20, 18, 22,
                21, 14, 27, 12, 3, 28, 17, 0, 2, 18,
                8, 20, 26, 16, 9, 23, 25, 20, 7, 27,
                5, 7, 16, 5, 25, 11, 3, 7, 2, 17, 14,
                6, 12, 14, 23, 25, 26, 5, 18, 1, 6,
                10, 9, 12, 2, 25, 29, 12, 19, 4, 8,
                5, 8, 30, 2, 22, 24, 30, 7, 24, 8, 15, 16, 2, 11, 20
        };
        System.out.println(minJumps(arr));
    }
    static int minJumps(int[] arr){
        // your code here
        // your code here
        if(arr[0]==0)
            return -1;

        int step=arr[0];
        int maxReach=step;
        int jump=1;
        int n=arr.length;
        if(n==1)return 0;

        for (int i=1;i<n;i++)
        {
            if(i>=n-1)
                return jump;
            maxReach=Math.max(maxReach,i+arr[i]);
            step--;
            if(step==0)
            {
                jump++;
                if(i>=maxReach)
                    return -1;
                step=maxReach-i;
            }
        }
        return jump;
    }
}
