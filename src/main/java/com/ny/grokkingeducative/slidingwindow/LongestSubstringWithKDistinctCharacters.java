package com.ny.grokkingeducative.slidingwindow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://leetfree.com/problems/longest-substring-with-at-most-k-distinct-characters.html

PROBLEM STATEMENT FROM EDUCATIVE:
    Given a string, find the length of the longest substring in it with no more than K distinct characters.
    Input: String="araaci", K=2
    Output: 4
    Explanation: The longest substring with no more than '2' distinct characters is "araa".
 */
public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithKDistinctCharacters("araaci", 2));
        System.out.println(longestSubstringWithKDistinctCharacters_Substring("araaci", 2));

        System.out.println(longestSubstringWithKDistinctCharacters("araaci", 1));
        System.out.println(longestSubstringWithKDistinctCharacters_Substring("araaci", 1));

        System.out.println(longestSubstringWithKDistinctCharacters("cbbebi", 3));
        System.out.println(longestSubstringWithKDistinctCharacters_Substring("cbbebi", 3));
    }

    private static int longestSubstringWithKDistinctCharacters(String str, int k) {

        int l=0;
        Set<Character> unique = new HashSet<>();
        int max = 0;
        for (int r = 0; r < str.length();) {
            if(unique.size() <= k) { //valid window
                max = Math.max(max, r-l); //so calculate the max size
                unique.add(str.charAt(r++));//add the character and expand the window
            } else {//window not valid, remove the character from left and see if it becomes valid then
                unique.remove(str.charAt(l++));
            }
        }
        return max;
    }

    private static String longestSubstringWithKDistinctCharacters_Substring(String str, int k) {
        int l=0;
        Set<Character> unique = new HashSet<>();
        int max = 0;
        int x = -1, y = -1;
        for (int r = 0; r < str.length();) {
            //valid window since unique characters are less or equal to k
            if(unique.size() <= k) {
                if(r-l > max) {
                    max = r-l;
                    x = l;
                    y = r;
                }
                unique.add(str.charAt(r++));//add the character and expand the window
            } else {//window not valid, remove the character from left and see if it becomes valid then
                unique.remove(str.charAt(l++));
            }
        }
        return str.substring(x, y);
    }



}
