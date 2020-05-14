package com.ny.leetcode.may2020;

import java.util.HashSet;
import java.util.Set;

public class Day02_JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(
                numJewelsInStones(
                    "z", "ZZ"
                )
        );
    }

    public static int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        int count = 0;
        for(char j : J.toCharArray()) jewels.add(j);

        for (char s : S.toCharArray()) if (jewels.contains(s)) count++;

        return count;
    }
}
