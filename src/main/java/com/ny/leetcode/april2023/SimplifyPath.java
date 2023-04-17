package com.ny.leetcode.april2023;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();

        Set<String> skip = Set.of("..", ".", "");

        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.insert(0, "/" + dir);
        }
        return (sb.length() == 0) ? "/" : sb.toString();
    }

}
