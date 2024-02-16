package com.leetcode;

public class findMedianSortedArrays {
//    https://leetcode.com/problems/median-of-two-sorted-arrays/description/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // brute force
        // ArrayList<Integer> list = new ArrayList<>();
        // for(int num: nums1){
        //     list.add(num);
        // }
        // for(int num: nums2){
        //     list.add(num);
        // }
        // Collections.sort(list);
        // int mid = list.size() / 2;
        // if(list.size() % 2 != 0){
        //     return (double) list.get(mid);
        // }
        // else{
        //     int middle1 = list.get(mid - 1);
        //     int middle2 = list.get(mid);
        //     return ((double) middle1 + (double) middle2) / 2.0;
        // }

        // optimised approach using binary search
        // take nums1 as smaller for simplicity
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; // left partition
        int low = 0, high = n1;
        while(low <= high){
            int mid1 = (low + high) >> 1; // Calculate mid index for nums1
            int mid2 = left - mid1; // Calculate mid index for nums2
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            // Determine values of l1, l2, r1, and r2
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                // The partition is correct, we found the median
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
            else if (l1 > r2) {
                // Move towards the left side of nums1
                high = mid1 - 1;
            }
            else {
                // Move towards the right side of nums1
                low = mid1 + 1;
            }
        }
        return 0;


    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
