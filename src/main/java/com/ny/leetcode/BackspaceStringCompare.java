package com.ny.leetcode;

/*
    Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

    Example 1:
    Input: S = "ab#c", T = "ad#c"
    Output: true
    Explanation: Both S and T become "ac".

    Example 2:
    Input: S = "ab##", T = "c#d#"
    Output: true
    Explanation: Both S and T become "".

    Example 3:
    Input: S = "a##c", T = "#a#c"
    Output: true
    Explanation: Both S and T become "c".

    Example 4:
    Input: S = "a#c", T = "b"
    Output: false
    Explanation: S becomes "c" while T becomes "b".
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {

        String S = "a#c", T = "b";

        System.out.println(backspaceCompare2(S, T));

    }

    public static boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;

            if (i >= 0 != j >= 0) return false;

            i--;
            j--;
        }
        return true;
    }

    public static boolean backspaceCompare(String S, String T) {
        return getBackspacedValue(S).equals(getBackspacedValue(T));
    }

    public static String getBackspacedValue(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else {
                int x = sb.length();
                if (x > 0) {
                    sb.deleteCharAt(x - 1);
                }
            }
        }
        return sb.toString();
    }

}
