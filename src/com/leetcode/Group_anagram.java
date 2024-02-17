package com.leetcode;
import java.util.*;

public class Group_anagram {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        // iterate through each string
        for(String s:strs){
            char[] count = new char[26];
            for(char ch : s.toCharArray()){
                // - 'a' so that the array doesnot go out of bound
                char temp = count[ch - 'a']++;
                System.out.println(temp);
            }
            String str = new String(count);
            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
