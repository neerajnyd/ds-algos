package com.ny.leetcode;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples: Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    public static void main(String[] args) {

        System.out.println(discussionBoard("dvdf"));


    }

    /*
    One input exceeds time limit
     */
    private static int bruteForce(String s) {

        List<Set<Character>> setList = new LinkedList<>();
        Set<Character> set = new LinkedHashSet<>();
        setList.add(set);
        for(Character c : s.toCharArray()){
            if(set.contains(c)) {
                List<Character> setOld  =new ArrayList<>(set);
                Set<Character> setNew = new LinkedHashSet<>();
                int i = setOld.indexOf(c);
                for(int x=i+1; x<setOld.size(); x++){
                    setNew.add(setOld.get(x));
                }
                setList.add(setNew);
                set = setNew;
            }
            set.add(c);
        }
        Optional<Set<Character>> maxSet = setList.stream().max((s1, s2) -> s1.size() - s2.size());
        Set<Character> characters = maxSet.get();
        for(Character c : characters){
            System.out.print(c);
        }
        return characters.size();
    }

    private static int discussionBoard(String s) {

        if(s.length() == 0) return 0;

        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0, j=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i-j+1);
        }

        return max;
    }

}
