package com.gfg;

public class Longest_AP {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 4, 6, 8, 10};
//                {1, 7, 10, 13, 14, 19};
        System.out.println(lengthOfLongestAP(arr, n));
    }
    static int lengthOfLongestAP(int[] arr, int n) {
        // code here
        int diff = arr[1] - arr[0];
        int length = 1;
        int maxLength = 0;
        for(int i = 1; i < n; i++){
            if(maxLength < length) maxLength = length;
            if(arr[i] - arr[i - 1] == diff) length++;
            else{
                diff = arr[i] - arr[i - 1];
                length = 1;
            }
        }
        return maxLength;
    }
}
