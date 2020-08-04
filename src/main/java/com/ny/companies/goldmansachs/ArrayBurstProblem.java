package com.ny.companies.goldmansachs;

import java.util.*;

/*
Repeatedly remove repeating characters above a threshold from a string till we can not
See Remove All Adjacent Duplicates in String II ->
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class ArrayBurstProblem {

    public static void main(String[] args) {
        /*System.out.println("'" + removeDuplicates("aa", 2) + "'");
        System.out.println("'" + removeDuplicates("ab", 1) + "'");
        System.out.println("'" + removeDuplicates("abcd", 3) + "'");
        System.out.println("'" + removeDuplicates("abcccdeef", 3) + "'");
        System.out.println("'" + removeDuplicates("ak", 3) + "'");
        System.out.println("'" + removeDuplicates("abcd", 2) + "'");*/
//        System.out.println("'" + removeDuplicates("abcdeeeeeddcbfgfhhht", 3) + "'");

        //this one didn't work - expected is that all e (5 of them) are removed and then all 3 d are removed
        System.out.println(removeDuplicates2(Arrays.asList("a","b","c","d","e","e","e","e","e","d","d","c","b","f","g","f","h","h","h","t"), 3));
        /*System.out.println(removeDuplicates2(Arrays.asList("a", "b", "c", "d", "e", "e", "e", "e", "e"), 3));
        System.out.println(removeDuplicates2(Arrays.asList("a", "b", "c", "c", "c", "d", "e", "e", "f"), 3));
        System.out.println(removeDuplicates2(Arrays.asList("a", "a"), 2));
        System.out.println(removeDuplicates2(Arrays.asList("a", "b"), 1));
        System.out.println(removeDuplicates2(Arrays.asList("a", "k"), 3));*/

    }

    public static String removeDuplicates(String s, int k) {
        int i = 0;
        int n = s.length();
        int[] count = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }

    public static List<String> removeDuplicates2(List<String> inputArray, int burstLength) {

        return helper(inputArray, burstLength);
    }

    public static List<String> helper(List<String> inputArray, int burstLength) {
        Stack<String> charStack = new Stack<>();
        Stack<Integer> counterStack = new Stack<>();
        boolean rerunHelper = false;
        for (String ch : inputArray) {
            counterStack.push(
                    !charStack.isEmpty() && charStack.peek().equals(ch) ? counterStack.peek() + 1 : 1
            );
            charStack.push(ch);
            if (counterStack.peek() == burstLength) {
                for (int i = 0; i < burstLength; i++) {
                    charStack.pop();
                    counterStack.pop();
                    rerunHelper = true;
                }
            }
        }
        List<String> result = new LinkedList<>();
        while (!charStack.empty()) {
            result.add(0, charStack.pop());
        }
        return rerunHelper ? helper(result, burstLength) : result;
    }

    private static class NonDup {
        String s;
        boolean include;

        public NonDup(String s) {
            this.s = s;
            this.include = true;
        }
    }

}
