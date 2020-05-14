package com.ny.leetcode.curatedlistchallenge.day1;

/*
https://leetcode.com/problems/alien-dictionary/
https://www.leetfree.com/problems/alien-dictionary.html
 */
public class AlienDictionary {

    /*
    1. wrt
    2. wrf
    3. er
    4. ett
    5. rftt

    w before e
    r before t
    t before f

    wertf

     */

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};

        String order = alienDictionary(words);

        System.out.println(order);
    }

    /*
    a
    b
    c
    */
    private static String alienDictionary(String[] words) {
        final int n = words.length;
        int[] counters = new int[n];


        return null;
    }

}
