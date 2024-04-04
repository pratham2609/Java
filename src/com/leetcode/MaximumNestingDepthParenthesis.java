package com.leetcode;

public class MaximumNestingDepthParenthesis {
    public static void main(String[] args) {
        System.out.print(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
    public static int maxDepth(String s) {
        int count = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                ans = Math.max(ans, count);
            } else if (c == ')' && count > 0)
                count--;
            else
                continue;
        }
        return ans;
    }
}
