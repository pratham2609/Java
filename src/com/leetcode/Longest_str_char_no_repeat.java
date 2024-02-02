package com.leetcode;

import java.util.HashMap;

public class Longest_str_char_no_repeat {
    public static void main(String[] args) {
        String s = "pratham";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n == 1) return n;
        // create a map to map character and indices
        HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();
        int right = 0;
        int left = 0;
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
