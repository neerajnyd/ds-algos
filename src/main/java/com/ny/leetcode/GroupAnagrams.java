package com.ny.leetcode;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        /*
        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Output:
        [
          ["ate","eat","tea"],
          ["nat","tan"],
          ["bat"]
        ]
         */
        String[] S = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final List<List<String>> lists = groupAnagrams(S);
        for (List<String> list : lists) {
            System.out.println(list);
        }

    }

    public static List<List<String>> groupAnagrams(String[] S) {

        Map<String, List<String>> ans = new HashMap<>();

        for (String s : S) {
            final char[] a = s.toCharArray();
            Arrays.sort(a);
            String key = new String(a);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }


}
