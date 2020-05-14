package com.ny.leetcode;

import java.util.Arrays;
import java.util.List;

public class ValidParenthesisString {

    public static void main(String[] args) {

        List<String> S = Arrays.asList(
                "((*)(*()(())())())()()((()())((()))(*"
        );
        for (String s : S)
            System.out.println(checkValidString(s));

    }

    public static boolean checkValidString(String S) {
        int low = 0;
        int high = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) low--;
                high--;
            } else {
                if (low > 0) low--;
                high++;
            }
            if (high < 0)
                return false;
        }
        return low == 0;
    }

}
