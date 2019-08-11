package com.ny.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {

        String digits = "23";

        List<String> answer = letterCombinations(digits);

        System.out.println(answer);

    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> Q = new LinkedList<>();
        if(digits==null || digits.isEmpty()) return Q;
        String[] numPad = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Q.add("");
        while(Q.peek().length() != digits.length()) {
            String head = Q.remove();
            int L = head.length();
            int numPadPosition = digits.charAt(L) - '0';
            String numPadLetters = numPad[numPadPosition];
            for(char c : numPadLetters.toCharArray()) {
                Q.addLast(head+c);
            }
        }
        return Q;
    }

}
