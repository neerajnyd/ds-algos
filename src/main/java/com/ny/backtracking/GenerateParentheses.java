package com.ny.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(0));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n > 0) backtrack(new StringBuilder(), result, n, 0, 0);
        return result;
    }

    private static void backtrack(StringBuilder runningCombination, List<String> result, int n, int open, int close) {
        if (runningCombination.length() == n * 2) {
            result.add(runningCombination.toString());
            return;
        }
        if (open < n) { //we still have more parenthesis pairs to add
            backtrack(runningCombination.append("("), result, n, open + 1, close);
            runningCombination.deleteCharAt(runningCombination.length() - 1);
        }
        if (open > close) { //close must always be less than open to justify adding them
            backtrack(runningCombination.append(")"), result, n, open, close + 1);
            runningCombination.deleteCharAt(runningCombination.length() - 1);
        }
    }

}
