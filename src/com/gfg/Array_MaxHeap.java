package com.gfg;

//https://www.geeksforgeeks.org/problems/does-array-represent-heap4345/1
public class Array_MaxHeap {
    public static boolean countSub(long arr[], long n)
    {
        // Your code goes here
        int l = 0;
        int r = 1;
        int cnt = 0;
        while(r < arr.length && l < arr.length){
            while(cnt < 2 && r < arr.length){
                if(arr[l] >= arr[r]) {
                    cnt++;
                    r++;
                }
                else return false;
            }
            cnt = 0;
            l++;
//            if(r + 1 < arr.length) r++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSub(new long[] {10 ,7 ,10 ,4 ,6 ,8}, 6));
    }
}
