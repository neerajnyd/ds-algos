package com.ny.companies.clearwater;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortestSubstringWithAllCharacters {

    public static void main(String[] args) {

        String str = "dabbcabcd";

        int size = shortestSubStringSizeContainingAllCharacters(str);

        System.out.println(size);

    }

    private static int shortestSubStringSizeContainingAllCharacters(String str) {
        Set<Character> unique = new HashSet<>();
        char[] chars = str.toCharArray();
        for (Character c : chars)
            unique.add(c);

        Map<Character, Integer> windowMap = new HashMap<>();

        int left = 0, right = 0;
        int min = str.length();
        while (left < str.length() || right < str.length()) {

            if (desirable(unique, windowMap)) { //window is desirable
                min = Math.min(min, right - left);//so we will record the possible answer
                removeFromMap(windowMap, chars[left]);//and try to push our limit by contracting the window
                left++;
            } else {//window is not desriable anymore so we extend it
                if(right == str.length()) break;
                addToMap(windowMap, chars[right]);
                right++;
            }
        }
        return min;
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

    private static boolean desirable(Set<Character> unique, Map<Character, Integer> map) {
        return unique.size() == map.size();
    }

}
