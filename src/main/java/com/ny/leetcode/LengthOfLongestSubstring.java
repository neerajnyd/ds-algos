package com.ny.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {

        String s = "dfvdf";
        int x = lengthOfLongestSubstring2(s);
        System.out.println(x);

    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (int i=0, j=0; i<n && j<n;) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                ans = Math.max(ans, i-j);
            } else {
                set.remove(s.charAt(j++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            final char key = s.charAt(j);
            if (map.containsKey(key)) {
                i = Math.max(map.get(key), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(key, j + 1);
        }
        return ans;
    }

}
