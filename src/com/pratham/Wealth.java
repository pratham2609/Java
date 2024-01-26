package com.pratham;

public class Wealth {
    public static void main(String[] args) {
        int[][] accounts ={
                {1,2,4},{1,5,7}};
        System.out.println(maximumWealth(accounts));
    }
    public static int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for(int[] person:accounts){
            // when you start a new column take the sum of row
            int count = 0;
            for(int account:person){
                count+=account;
            }
            if(count>ans) ans=count;
        }
        return ans;
    }
}
