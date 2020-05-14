package com.ny.gfg.stackandqueue;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class SQ_01_ValidParenthesis {

    public static void main(String[] args) throws Exception {
        final Scanner in = new Scanner(new File("C:\\Users\\NY\\Desktop\\tc.txt"));
//      final Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int i = 0; i < T; i++) {
            String s = in.nextLine();
            process(s);
        }
        in.close();
    }

    private static void process(String s) {
        char[] C = s.toCharArray();
        final Deque<Character> stack = new LinkedList<>();
        boolean balanced = true;
        outer:
        for (char c : C) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (!Objects.equals(stack.peek(), '(')) {
                        balanced = false;
                        break outer;
                    } else {
                        stack.pop();
                        break;
                    }
                case '}':
                    if (!Objects.equals(stack.peek(), '{')) {
                        balanced = false;
                        break outer;
                    } else {
                        stack.pop();
                        break;
                    }
                case ']':
                    if (!Objects.equals(stack.peek(), '[')) {
                        balanced = false;
                        break outer;
                    } else {
                        stack.pop();
                        break;
                    }
            }
        }
        if (!balanced || !stack.isEmpty()) {
            System.out.println("not balanced");
        } else {
            System.out.println("balanced");
        }
    }

}
