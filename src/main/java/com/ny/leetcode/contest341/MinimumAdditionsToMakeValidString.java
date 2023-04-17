package com.ny.leetcode.contest341;

import java.util.HashMap;
import java.util.Map;

public class MinimumAdditionsToMakeValidString {


    /*
    Given a string word to which you can insert letters "a", "b" or "c" anywhere and any number of times,
    return the minimum number of letters that must be inserted so that word becomes valid.

    A string is called valid if it can be formed by concatenating the string "abc" several times.
     */
    public int addMinimum(String word) {

        int n = word.length();
        int count = 0;
        int i = 0;
        while (i < n) {
            int x = word.charAt(i) - 'a';
            int y = i + 1 >= n ? -1 : word.charAt(i + 1) - 'a';
            int z = i + 2 >= n ? -1 : word.charAt(i + 2) - 'a';

            if (x < y && y < z) {
                i += 3;
            } else if (x < y) {
                count += 1;
                i += 2;
            } else {
                count += 2;
                i++;
            }
        }
        return count;

    }


}
