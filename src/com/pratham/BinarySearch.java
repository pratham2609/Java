package com.pratham;

public class BinarySearch {
    public static void main(String[] args) {
    int[] arr = {1 , 2, 3, 4, 5, 9, 111};
    int ans = binarySearch(arr,9);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;

        // Order agnostic
        // find whether array is ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            // find middle element
            // might be possible that (start + end) exceeds int limit, then use
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) return mid;

            if(isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            else{
                if(target > arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
