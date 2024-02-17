package com.leetcode;

public class Maximum_forts_captured {
    public static void main(String[] args) {
        System.out.println(captureForts(new int[] {1,0,0,-1,0,0,0,0,1}));
    }
    public static int captureForts(int[] forts) {

        int sum = 0;// for  calculating cumulative sum
        int ret = 0; // for returning the max string of zeros between -1 and 1
        int count = 0; // for counting and comparing string of zeros


        for(int i = 0 ; i < forts.length ; i++){

            if(forts[i] != 0) // counting starts and ends at non-zero fort
            {

                sum += forts[i]; // s counts the cumulative sum from the last non-zero fort
                if(sum == 0)
                    ret = Math.max(ret, count);// if s = 0, it means we are either at start or end, hence compare

                sum = forts[i];//cumulative sum resets to current value
                count = 0;//count resets at non-zero fort value

            }

            else
            {
                if(sum != 0)
                    count++; //count if we already encountered a non-zero fort

            }
        }
        return ret;

    }
}
