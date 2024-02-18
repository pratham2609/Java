package com.recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,3,1,4,2,6};
        sort(arr, 5, 0);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr, int r, int c){
        if(r == 0) return;
        if(c < r){
            if(arr[c] > arr[c + 1]) swap(arr, c, c + 1);
            sort(arr, r, c + 1);
        }
        else sort(arr, r - 1, 0);

    }
    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
