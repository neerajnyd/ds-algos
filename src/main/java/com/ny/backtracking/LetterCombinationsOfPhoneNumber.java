package com.ny.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber instance = new LetterCombinationsOfPhoneNumber();
        System.out.println(instance.letterCombinations("23"));
    }

    Map<String, String> numToLetters = createPhoneNumberToLettersMap();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() != 0) {
            backtrack(digits, result, new StringBuilder());
        }
        return result;
    }

    private void backtrack(String remainingDigits, List<String> result, StringBuilder combination) {
        //the base case - there are no remaining digits so we just add to result and return
        if (remainingDigits.length() == 0) {
            result.add(combination.toString());
            return;
        }

        //out of the remaining digits, we process just the first one here
        String digit = remainingDigits.substring(0, 1);
        //we process all the letters of a digit one by one
        String lettersForDigit = numToLetters.get(digit);
        for (int i = 0; i < lettersForDigit.length(); i++) {
            //take a single letter
            String letter = lettersForDigit.substring(i, i + 1);
            //add it to the in progress result
            combination.append(letter);
            //then call this function (self) to process the remaining digits - except the one we were just processing
            backtrack(remainingDigits.substring(1), result, combination);
            //we remove the letter we appended in this loop so since it has already been processed
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    private Map<String, String> createPhoneNumberToLettersMap() {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("8", "tuv");
        map.put("7", "pqrs");
        map.put("9", "wxyz");
        return map;
    }

}
