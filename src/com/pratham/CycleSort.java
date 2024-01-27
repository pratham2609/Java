package com.pratham;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {5 ,3 , 4, 1, 2};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cycleSort(int[] arr){
        int i = 0;
        while( i < arr.length){
            int correctIndex = arr[i] - 1;
            if(arr[i] != arr[correctIndex]){
                swapArray(arr, i, correctIndex);
            }
            else {
                i++;
            }
        }
    }
    static void swapArray(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
