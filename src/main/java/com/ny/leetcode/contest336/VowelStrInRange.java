package com.ny.leetcode.contest336;

import java.util.Set;

public class VowelStrInRange {

    public static void main(String[] args) {
        VowelStrInRange str = new VowelStrInRange();

        System.out.println(str.vowelStrings(new String[]{"are", "amy", "u"}, 0, 2));
        System.out.println(str.vowelStrings(new String[]{"hey", "aeo", "mu", "ooo", "artro"}, 1, 4));
    }

    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int vowelStrings(String[] words, int left, int right) {

        int n = words.length;
        if (n == 0) return 0;
        int counter = 0;

        for (int i = left; i <= right; i++) {

            if (i == n) break;

            String word = words[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                counter++;
            }

        }
        return counter;

    }

}
