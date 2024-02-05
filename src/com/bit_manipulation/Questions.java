package com.bit_manipulation;

public class Questions {
    public static void main(String[] args) {

        // unique digit using bit
        int[] arr = {2,3,3,4,6,4,2};
        System.out.println(findUnique(arr));
    }
    private static int findUnique(int[] arr){
        int unique = 0;
        // xor array and the no. which doesnot turns 0 is the unique element
        for(int n:arr){
            unique ^= n;
        }
        return unique;
    }
}
