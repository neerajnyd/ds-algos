package com.ny.leetcode.curated.string;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {

        String s = "[";

        System.out.println(validParentheses2(s));

    }

    private static boolean validParentheses2(String s) {
        Deque<Character> stack = new LinkedList<>();

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.addFirst(c);
            } else {
                Character expected = map.get(c);
                Character actual = stack.pollFirst();
                if (!Objects.equals(expected, actual)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean validParentheses(String s) {

        if (s.length() % 2 != 0) return false;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (stack.size() < 1) return false;
                    Character c1 = stack.pop();
                    if (c1 != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.size() < 1) return false;
                    Character c3 = stack.pop();
                    if (c3 != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.size() < 1) return false;
                    Character c5 = stack.pop();
                    if (c5 != '[') {
                        return false;
                    }
                    break;
            }

        }
        if (stack.size() == 0) return true;

        return false;
    }

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[head++] = c;
            } else if (c == '[') {
                stack[head++] = c;
            } else if (c == '{') {
                stack[head++] = c;
            } else if (c == ')') {
                if (head == 0) return false;
                if (stack[--head] != '(') return false;
            } else if (c == ']') {
                if (head == 0) return false;
                if (stack[--head] != '[') return false;
            } else if (c == '}') {
                if (head == 0) return false;
                if (stack[--head] != '{') return false;
            }
        }
        return head == 0;
    }

}
