package com.ny.leetcode.curatedlistchallenge.day6;

/*
https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        int uniqueCount = 0;//count of most unique characters in window
        int left = 0;
        int max = 0;
        int[] count = new int[26];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int charIndex = c - 'A';
            count[charIndex]++;
            uniqueCount = Math.max(uniqueCount, count[charIndex]);

            int replacementCount = right - left + 1 - uniqueCount;
            if (replacementCount > k) {
                char leftChar = s.charAt(left);
                count[leftChar - 'A']--;
                left++;
            } else {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println(characterReplacement(
                "AABABBA",
                1
        ));
    }
}
