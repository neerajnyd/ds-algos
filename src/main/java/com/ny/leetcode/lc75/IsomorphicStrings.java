package com.ny.leetcode.lc75;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {

        System.out.println(isIsomorphic("foo", "bar"));

    }

    public static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);
            char b = t.charAt(i);

            if ((map.containsKey(b) && !map.get(b).equals(a)) ||
                    (map2.containsKey(a) && !map2.get(a).equals(b))) {
                return false;
            } else {
                map.put(b, a);
                map2.put(a, b);
            }
        }

        return true;
    }

}
