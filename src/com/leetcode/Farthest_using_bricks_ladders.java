package com.leetcode;

import java.util.PriorityQueue;

//https://leetcode.com/problems/furthest-building-you-can-reach/description/
class Soln {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // use minHeaps to store the used ladders
        PriorityQueue<Integer> usedLadders = new PriorityQueue<>();
        int n = heights.length;
        for(int i = 0; i < n - 1; i++){
            int diff = heights[i + 1] - heights[i];
            if(diff <= 0) continue;
            if(ladders > 0){
                usedLadders.add(diff);
                ladders--;
            }
            else if(!usedLadders.isEmpty() && diff > usedLadders.peek()){
                bricks -= usedLadders.remove();
                usedLadders.add(diff);
            }
            else bricks -= diff;
            if(bricks < 0) return i;
        }
        return n - 1;
    }
}
public class Farthest_using_bricks_ladders {


    public static void main(String[] args) {
        int[] heights = {4,12,2,7,3,18,20,3,19};
        int bricks = 10, ladders = 2;
        Soln s = new Soln();
        System.out.println(
                s.furthestBuilding(heights, bricks, ladders)
        );
    }
}
