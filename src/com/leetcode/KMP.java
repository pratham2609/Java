package com.leetcode;

import java.util.Arrays;

public class KMP {
    private static boolean Kmp(String s) {
        char[] c = s.toCharArray(); // Convert the string to a character array
        int i = 1, j = 0, n = c.length; // Initialize variables for loop and length of the string
        int[] lps = new int[n + 1]; // Initialize an array to store the LPS values, with an extra slot for convenience
        // Construct the LPS array using the KMP algorithm
        while (i < n) {
            if (c[i] == c[j])
                lps[++i] = ++j; // Increment both i and j if characters match, and store the LPS value
            else if (j == 0)
                i++; // Increment i if characters don't match and j is already 0
            else
                j = lps[j]; // Update j to the value from LPS array for backtracking
        }

        // Check if the last element of the LPS array satisfies the conditions for a repeated substring pattern
        return lps[n] != 0 && lps[n] % (n - lps[n]) == 0;
    }

    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(Kmp(s));
    }
}
