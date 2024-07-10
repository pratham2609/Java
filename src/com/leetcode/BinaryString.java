package com.leetcode;
import  java.util.*;
public class BinaryString {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        System.out.println(sb.reverse().toString());
    }
}
