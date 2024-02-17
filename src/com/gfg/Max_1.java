package com.gfg;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/maximize-number-of-1s0905/1
public class Max_1 {
    public static int findZeroes(int[] arr, int n, int m) {
        // code here
        // code here
        // int beg = 0;
        // int result = 0;
        // for (int i = 0; i < n; i++) {
        //     if (a[i] == 0) {
        //         if (m > 0) {
        //             m--;
        //             result = Math.max(result, i - beg + 1);
        //         } else {
        //             while (a[beg] != 0) {
        //                 beg++;
        //             }
        //             beg++;
        //         }
        //     } else {
        //         result = Math.max(result, i - beg + 1);
        //     }
        // }
        // return result;

        // sliding window
        // code here
        // sliding window techi
        int s=0,e=0,count=0,maxi=0;
        for(e=0;e<n;e++)
        {    if(arr[e]==0) count++;

            while(count>m)
            {  if(arr[s++]==0) count--;

            }

            maxi=Math.max(maxi,(e-s+1));
        }



        return maxi;
    }
    public static void main(String[] args) {
        int n = 11, m = 2;
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
//        System.out.println(Arrays.toString(arr));
        int ans = findZeroes(arr, n, m);
        System.out.println(ans);
    }

}
