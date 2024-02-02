package com.leetcode;

import java.util.Arrays;

public class Next_greater_element {
    public static void main(String[] args) {
//        int[] nums1 =  {1,3,5,2,4};
//        int[] nums2 = {5,4,3,2,1};
        int[] nums1 =  {3,1,5,7,9,2,6};
        int[] nums2 = {1,2,3,5,6,7,9,11};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int k = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    int max = nums2[j];
                    if(j == nums2.length - 1){
                        ans[k] = -1;
                        k++;
                    }
                    else{
                        for(int n = j + 1; n < nums2.length; n++){
                            boolean flag = true;
                            if(nums2[n] > max)
                            {
                                ans[k] = nums2[n];
                                max = nums2[n];
                                k++;
                                break;
                            }
                        }
                        if(nums2[j] == max){
                            ans[k] = -1;
                            k++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
