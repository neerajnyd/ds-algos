package com.ny.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {

        List<String> strings = generateParenthesis(6);

        System.out.println(strings);
    }

    private static List<String> generateParenthesis(int n) {

        List<String> R = new ArrayList<>();
        String str = "";
        backtrack(R, str, 0, 0, n);
        return R;
    }

    private static void backtrack(List<String> result, String combination, int open, int close, int max) {

        if(combination.length() == max*2) {
            result.add(combination);
            return;
        }

        if(open < max) {
            backtrack(result, combination+"(", open+1, close, max);
        }

        if(close < open) {
            backtrack(result, combination+")", open, close+1, max);
        }

    }


}
