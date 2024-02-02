package com.gfg;
//https://www.geeksforgeeks.org/problems/implement-atoi/1
public class Atoi {
    class Solution
    {
        int atoi(String s) {
            // Your code here
            // Check if it is negative or not
            boolean minus = s.charAt(0) == '-' ? true : false;
            // If negative means start checking from 1 or else 0
            int start = s.charAt(0) == '-' ? 1 : 0;
            int result = 0;
            for(int i = start ; i<s.length() ; i++) {
                // Check if 's' contains alphabet & Check - present in last index
                if(s.charAt(i) + '0' > 115 || s.charAt(s.length()-1) == '-') return -1;
                // Convert the char value to int value
                int val = ('0' - ('a' - s.charAt(i))) + 1;
                // Adding the Values
                result = result * 10 + val;
            }
            // Check before return if it is negative or not
            return minus == true ? (-1 * result ) : result ;
        }
    }
}
