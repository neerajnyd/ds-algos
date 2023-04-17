package com.ny.leetcode.curated.string;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

    }

    private static int characterReplacement(String s, int k) {

        int n = s.length(), l = 0, r = 0, maxLength = 0, maxCount = 0; //max count of a repeating character in a sliding window

        int[] count = new int[26]; //for each uppercase character

        while (r < n) {

            maxCount = Math.max(maxCount, ++count[s.charAt(r++) - 'A']);

            if (r - l - maxCount > k) {
                count[s.charAt(l++) - 'A']--;//decrement count of character at left and shift window
            }
            maxLength = Math.max(maxLength, r - l);
        }

        return maxLength;
    }

}
