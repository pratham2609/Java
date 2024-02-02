package com.gfg;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&sortBy=submissions
public class Subarray_sum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean flag=false;
        int l = 0;
        int r = 0;
        int sum = arr[0];

        if( s == 0 && arr[0] != 0){
            ans.add(-1);
            return ans;
        }
        while( r < n){
            if( sum == s){
                flag = true;
                break;
            }
            else if(sum < s){
                r++;
                if(r < n) sum += arr[r];
            }
            else {
                sum -= arr[l];
                l++;
            }
        }
        if(flag){
            ans.add(l + 1);
            ans.add(r + 1);
        }
        else{
            ans.add(-1);
        }
        return ans;
    }
}
