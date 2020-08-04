package com.ny.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        /*
        Input: S = "cabwefgewcwaefgcf", T = "cae"
        Output: "cwae"
         */
        System.out.println("Result is '" +
                minWindow(
                        "cabwefgewcwaefgcf", "cae"
                )
                + "'"
        );
    }

    public static String minWindow(String str, String target) {

        Map<Character, Integer> unique = new HashMap<>();
        for (Character c : target.toCharArray())
            unique.put(c, unique.getOrDefault(c, 0) + 1);

        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int winLeft = -1, winRight = -1;
        while (left < str.length() || right < str.length()) {
            if (desirable(unique, windowMap)) {
                int pMin = right - left;
                if (pMin < min) {
                    min = pMin;
                    winLeft = left;
                    winRight = right;
                }
                removeFromMap(windowMap, str.charAt(left));
                left++;
            } else {
                if (right == str.length()) break;
                addToMap(windowMap, str.charAt(right));
                right++;
            }
        }
        if (winLeft == -1) return "";
        else return str.substring(winLeft, winRight);
    }

    private static void addToMap(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    private static void removeFromMap(Map<Character, Integer> map, Character c) {
        if (map.containsKey(c)) {
            int newValue = map.get(c) - 1;
            if (newValue == 0) {
                map.remove(c);
            } else {
                map.put(c, newValue);
            }
        }
    }

    private static boolean desirable(Map<Character, Integer> mapT, Map<Character, Integer> mapS) {
        for (Map.Entry<Character, Integer> entry : mapT.entrySet()) {
            if (!mapS.containsKey(entry.getKey()) || mapS.get(entry.getKey()) < entry.getValue())
                return false;
        }

        return true;
    }

}
