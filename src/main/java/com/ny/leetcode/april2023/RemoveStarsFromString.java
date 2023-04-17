package com.ny.leetcode.april2023;

public class RemoveStarsFromString {

    public String removeStars(String s) {

        StringBuilder sb = new StringBuilder();

        //leet**cod*e -> lecoe

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '*' && !sb.isEmpty()) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
