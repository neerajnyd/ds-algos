package com.ny.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        String s = "pwwkew";
        int x = lengthOfLongestSubstring(s);
        System.out.println(x);

    }

    public static int lengthOfLongestSubstring_SlidingWindow(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, left = 0, right = 0;
        while (right < s.length()) {
            if (set.add(s.charAt(right))) {
                right++;
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> char_to_position = new HashMap<>();
        for (int right = 0, left = 0; right < s.length(); right++) {
            final char rightChar = s.charAt(right);
            if (char_to_position.containsKey(rightChar)) {
                Integer a = char_to_position.get(rightChar);
                left = Math.max(a, left);
            }
            right++;
            max = Math.max(max, right - left);
            char_to_position.put(rightChar, right);
        }
        return max;
    }

}
