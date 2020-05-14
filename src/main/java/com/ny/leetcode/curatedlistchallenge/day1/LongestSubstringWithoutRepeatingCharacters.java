package com.ny.leetcode.curatedlistchallenge.day1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
//TODO: liner time solution
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }

    public static int lengthOfLongestSubstring2(String s) {
        //abcabcbb
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int len = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    maxLen = Math.max(maxLen, len);
                    break;
                } else {
                    set.add(c);
                    len++;
                }
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int prevIndex = map.get(c);
                int newSubstringStartIndex = prevIndex + 1;
                j = Math.max(j, newSubstringStartIndex);
            }
            map.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

}
