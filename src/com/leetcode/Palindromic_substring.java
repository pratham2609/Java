package com.leetcode;

//So Basically If I know a string is palindrome and I divide it in two parts ( if length is even ) that would have same characters.
//        and for odd length except the middle element, all other characters would be same.
//        So If I pick a character and expand it's left and right side till I have similiar elements. Those would be palindrome. But this could be even length palindrome's middle or odd length palindrome's middle. So we will take care of both case.
//        If it is odd, expand left = (i-1) and right = (i+1)
//        If it is even, expand left = (i) and right = (i+1)
//        We have to do this for each character to explore all substrings.
//        Interviewer : Approach seems good to me. Let's discuss Time and Space Complexity then we can proceed for the code part.
//        You : Sure , Here Time Complexity would be O(n^2) because for a character worst case can be to traverse all neighbours.
//        and Space Complexity would be O(1).


public class Palindromic_substring {
    public static int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++) {
            int even = palindromeCount(s, i, i+1);
            int odd = palindromeCount(s, i-1, i+1);
            ans += even + odd + 1;
        }
        return ans;
    }

    public static int palindromeCount(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        countSubstrings("abba");

    }
}
