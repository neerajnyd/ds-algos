package com.ny.leetcode.curated.string;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        Map<Character, Integer> count = new HashMap<>();
        for (char c : str1.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) - 1);
            if (count.get(c) < 0) return false;
            if (count.get(c) == 0) count.remove(c);
        }
        return count.size() == 0;
    }
}
