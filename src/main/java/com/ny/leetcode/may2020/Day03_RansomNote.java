package com.ny.leetcode.may2020;

public class Day03_RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstruct("abbccddeee", "aaaaaaaabbbbbbbbbccccccccccddddddddee"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char currentCharacter = magazine.charAt(i);
            int indexInArray = currentCharacter - 'a';
            arr[indexInArray]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char currentChar = ransomNote.charAt(i);
            int indexInArray = currentChar - 'a';
            if(--arr[indexInArray] < 0) {
                return false;
            }
        }
        return true;
    }

}
