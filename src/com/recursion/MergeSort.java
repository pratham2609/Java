package com.recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 7, 2, 6, 144, 1, 6, 34, 5};
//        arr = merge(arr);
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    // using recursion
//    static int[] mergeSort(int[] arr) {
//        if(arr.length == 1) return arr;
//        int mid = arr.length / 2;
//        int[] left =mergeSort(Arrays.copyOfRange(arr, 0 , mid));
//        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length ));
//        return merge(left, right);
//    }
//    private  static  int[] merge(int[] first, int[] second) {
//        int[] ans = new int[first.length+ second.length];
//        int i = 0, j= 0, k = 0;
//        while(i < first.length && j < second.length) {
//            if(first[i] < second[j]){
//                ans[k] = first[i];
//                i++;
//            }
//            else {
//                ans[k] = second[j];
//                j++;
//            }
//            k++;
//        }
//        // it may be possible that one of the arrays is not completed
//        while(i < first.length) {
//            ans[k] = first[i];
//            i++;
//            k++;
//        }
//        while(j < second.length) {
//            ans[k] = second[j];
//            j++;
//            k++;
//        }
//        return ans;
//    }


    // using in place merge sort
    static void mergeSort(int[] arr, int start, int end) {
        if(end - start == 1) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }
    private static void merge(int[] arr, int start, int mid, int end) {
        int[] ans = new int[end - start];
        int i = start, j = mid, k = 0;
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                ans[k] = arr[i];
                i++;
            } else {
                ans[k] = arr[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not completed
        while (i < mid) {
            ans[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            ans[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < ans.length; l++) {
            arr[start + l] = ans [l];
        }
    }
}
