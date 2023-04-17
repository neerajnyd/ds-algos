package com.ny.leetcode.curated.string;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
//TODO: linear time solution
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }

    public static int lengthOfLongestSubstring(String s) {

        int n = s.length(), l = 0, r = 0, max = 0;

        Set<Character> set = new HashSet<>();

        while (l < n && r < n) {

            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }

            set.add(s.charAt(r++));
            max = Math.max(r - l, max);

        }
        return max;
    }

}
