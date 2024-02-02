package com.leetcode;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/sequential-digits/description/?envType=daily-question&envId=2024-02-02

public class Sequential_digits {
    public static void main(String[] args) {
        List<Integer> a = sequentialDigits(100,300);
        System.out.println(a);
    }
        public static List<Integer> sequentialDigits(int low, int high) {
            List<Integer> a = new ArrayList<>();
            for(int i = 1; i <= 9; i++){
                int num = i;
                int nextDigit = i + 1;
                while(num <= high && nextDigit <= 9){
                    num = num * 10 + nextDigit;
                    if( low <= num && num <= high){
                        a.add(num);
                    }
                    nextDigit++;
                }
            }
            a.sort(null);
            return a;
        }
}
