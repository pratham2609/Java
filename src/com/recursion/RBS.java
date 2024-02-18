package com.recursion;

public class RBS {
    public static void main(String[] args) {
        System.out.println(search(new int[] {5,6,7,8,9,1,2,3}, 2, 0, 7));
    }
    static int search(int[] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }
        int m = s + (e - s) / 2;
        if(arr[m] == target) return m;
        if(arr[s] <= arr[m]){ // means array is sorted
            if(target >= arr[s] && target <= arr[m]){ // check if the element lies in this part or not
                return search(arr, target, s, m - 1);
            }
            else return search(arr, target,m + 1, e);
        }
        else if(target >= arr[m] && target <= arr[e]) return search(arr, target, m + 1, e);
        else return search(arr, target, s, m - 1);
    }
}
