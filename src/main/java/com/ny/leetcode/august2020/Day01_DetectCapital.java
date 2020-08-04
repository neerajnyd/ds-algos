package com.ny.leetcode.august2020;

public class Day01_DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("usa"));
        System.out.println(detectCapitalUse("Usa"));
    }

    public static boolean detectCapitalUse(String word) {
        char[] C = word.toCharArray();
        boolean firstCap = Character.isUpperCase(C[0]);
        boolean allCaps = true;
        boolean allSmall = true;
        boolean allSmallExceptFirst = true;

        for (int i = 0, cLength = C.length; i < cLength; i++) {

            char c = C[i];
            if (Character.isUpperCase(c)) {
                if(i > 0) allSmallExceptFirst = false;
                allSmall = false;
            }
            if (Character.isLowerCase(c)) {
                allCaps = false;
            }
        }
        return allCaps || allSmall || (firstCap && allSmallExceptFirst);
    }
}
