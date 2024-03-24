package com.gfg;
import java.util.*;

//https://www.geeksforgeeks.org/problems/merge-sort/1

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 7, 2, 6, 144, 1, 6, 34, 5};
//        arr = merge(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
        private static void merge(int arr[], int l, int m, int r) {
            ArrayList<Integer> temp = new ArrayList<>();
            int left = l;
            int right = m + 1; // Corrected from mid to m

            while (left <= m && right <= r) {
                if (arr[left] <= arr[right]) { // Corrected <= instead of <
                    temp.add(arr[left]);
                    left++;
                } else {
                    temp.add(arr[right]);
                    right++;
                }
            }

            while (left <= m) {
                temp.add(arr[left]);
                left++;
            }
            while (right <= r) {
                temp.add(arr[right]);
                right++;
            }

            for (int i = l; i <= r; i++) {
                arr[i] = temp.get(i - l);
            }
        }

        public static void mergeSort(int arr[], int l, int r) {
            int low = l;
            int high = r;
            if (low >= high) {
                return;
            }
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }

}
