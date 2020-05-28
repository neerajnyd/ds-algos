package com.ny.leetcode.may2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day17_IndicesOfAnagramsOfString_P_InString_S {
    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        //character hash
        int[] hash = new int[256];
        //record each character in p to hash
        for (char c : p.toCharArray())
            hash[c]++;
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            /*move right every time, if the character exists in p's hash, decrease the count
            current hash value >= 1 means the character is existing in p*/
            char cRight = s.charAt(right);
            if (hash[cRight] >= 1) {
                count--;
            }
            hash[cRight]--;
            right++;
            /*when the count is down to 0, means we found the right anagram
            then add window's left to result list*/
            if (count == 0) {
                result.add(left);
            }
            /*if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            ++ to reset the hash because we kicked out the left
            only increase the count if the character is in p
            the count >= 0 indicate it was original in the hash, cuz it won't go below 0*/
            if (right - left == p.length()) {
                char cLeft = s.charAt(left);
                if (hash[cLeft] >= 0) {
                    count++;
                }
                hash[cLeft]++;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams(
                "abab", "ab"
        ));
    }
}
