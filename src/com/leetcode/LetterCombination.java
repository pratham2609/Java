package com.leetcode;
import java.util.*;
public class LetterCombination {
    private static final String[] KEYPAD_MAPPING = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        generateCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void generateCombinations(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char currentDigit = digits.charAt(index);
        String letters = KEYPAD_MAPPING[currentDigit - '0'];

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            generateCombinations(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
