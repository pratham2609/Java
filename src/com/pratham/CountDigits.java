package com.pratham;

public class CountDigits {
    public static void main(String[] args) {
        int[] arr={1,22,483,2019,29499};
        System.out.println(findNumbers(arr));
    }
    static int findNumbers(int[] nums) {
        int count =0;
        for(int element:nums){
            if(even(element)) count++;
        }
        return count;
    }

    static boolean even(int num){
        return digits(num) %2 ==0;
    }

    // int digits(int num){
    //     if(num < 0){
    //         num = num * -1;
    //     }
    //     if(num == 0) return 1;
    //     int count = 0;
    //     while(num>0){
    //         count++;
    //         num=num/10;
    //     }
    //     return count;
    // }
    // optimized
    static int digits(int num){
        return (int)(Math.log10(num) + 1);
    }
}
