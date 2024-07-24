package com.leetcode;
import java.util.*;

public class MostFrequentIds {
    static HashMap<Integer, Long> idToFreq = new HashMap<>();
    static TreeMap<Long, Set<Integer>> freqToIds = new TreeMap<>();

    public static long[] mostFrequentIDs(int[] nums, int[] freq) {
        int size = nums.length;
        long[] result = new long[size];
        for (int i = 0; i < size; i++) {
            int id = nums[i];
            long addedFreq = freq[i];
            long oldFreq = idToFreq.getOrDefault(id, 0L);
            long newFreq = addedFreq + oldFreq;
            updateIdToFreq(id, newFreq);
            updateFreqToIds(id, oldFreq, newFreq);
            result[i] = freqToIds.lastKey();
        }
        return result;
    }

    private static void updateIdToFreq(int id, long newFreq) {
        idToFreq.put(id, newFreq);
    }

    private static void updateFreqToIds(int id, long oldFreq, long newFreq) {
        if (oldFreq != 0) {
            freqToIds.get(oldFreq).remove(id);
            if (freqToIds.get(oldFreq).size() == 0)
                freqToIds.remove(oldFreq);
        }
        if (!freqToIds.containsKey(newFreq))
            freqToIds.put(newFreq, new HashSet<>());
        freqToIds.get(newFreq).add(id);
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2,1};
        int[] freq = {3,2,-3,1};
        System.out.println(mostFrequentIDs(nums, freq));
    }
}
