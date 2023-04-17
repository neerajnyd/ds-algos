package com.ny.leetcode.curated.string;

public class ValidPalindrome {

    private static boolean isPalindrome(String s) {

        int start = 0, end = s.length() - 1;

        while (start < end) {

            char a = s.charAt(start);
            char b = s.charAt(end);

            if (!Character.isLetterOrDigit(a)) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(b)) {
                end--;
                continue;
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(
                isPalindrome(
                        "A man, a plan, a canal: Panama"
                )
        );

    }

}
