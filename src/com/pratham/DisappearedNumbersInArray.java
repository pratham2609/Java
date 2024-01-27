package com.pratham;
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearedNumbersInArray {
    public static void main(String[] args) {
        int[] arr = {4, 0, 2, 1};
        missingNumbers(arr);
    }
    public static List<Integer> missingNumbers(int[] arr){
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
        // find missing number
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] - 1 != j){
                list.add(j + 1);
            }
        }

        return list;
    }
    static void swapArray(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
