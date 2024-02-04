package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/description/?envType=daily-question&envId=2024-02-04
public class Sliding_window {
    public String minWindow(String s, String t) {
        String ans = "";
        // map for target chars
        HashMap<Character, Integer> map = new HashMap<>();

        // map for string
        HashMap<Character, Integer> mpp = new HashMap<>();
        // if it exists
        for(int in = 0;in < t.length();in++){
            mpp.put(t.charAt(in), mpp.getOrDefault(t.charAt(in), 0) + 1);
        }
        int have = 0;
        int need = t.length();

        int i = -1;
        int j = -1;
        while(i < s.length()){
            boolean f1 = false;
            boolean f2 = false;
            // acquire
            while(i < s.length() - 1 && have < need){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.getOrDefault(ch, 0) <= mpp.getOrDefault(ch, 0)){
                    have++;
                }
            }
            // collect answers and release
            while(j < i && have == need){
                f2 = true;
                String potAns = s.substring(j + 1, i + 1);
                if(ans.length() == 0 ||potAns.length() < ans.length()) ans = potAns;

                j++;
                char ch = s.charAt(j);;
                if (map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    map.put(ch, map.get(ch) - 1);
                }
                if(map.getOrDefault(ch, 0) < mpp.getOrDefault(ch, 0)){
                    have--;
                }
            }
            if(f1 == false && f2 == false) break;
        }
        return ans;
    }
}
