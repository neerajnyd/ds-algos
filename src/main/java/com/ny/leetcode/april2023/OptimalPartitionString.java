package com.ny.leetcode.april2023;


import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionString {

    public int partitionString(String s) {

        int count = 1;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                count++;
                set.clear();
            }
            set.add(c);
        }

        return count;
    }

}
