package com.leetcode;
import java.util.*;

//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/?envType=daily-question&envId=2024-02-16

public class Least_number_of_unique_integers {
    class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            Map<Integer, Integer> mpp = new HashMap<>();
            for(int num:arr){
                mpp.put(num, mpp.getOrDefault(num, 0) + 1);
            }
            // to get which number has the least frequency we can use minHeap
            // the values passed to minHeap will be the frequencies of each number
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(mpp.values());
            while(!minHeap.isEmpty() && k > 0 && minHeap.peek() <= k){
                if(minHeap.peek() <= k){
                    // if frequency is smaller than iterations
                    // delete it from heap and reduce iterations to iterations - frequency
                    k -= minHeap.peek();
                    minHeap.remove();
                }
            }
            return minHeap.size();
        }
    }
}
