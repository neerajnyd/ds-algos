package com.ny.leetcode.may2020;

public class Day13_RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(removeKdigits(
                "100000000000009", 2));
    }

    public static void main() {

    }

    public static String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            /* if current character is smaller than the previous one,
            then remove the previous one while we got characters to remove */
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length()-1) > cur) {
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            /* don't append a zero to an empty result */
            if (sb.length() == 0 && cur == '0')
                continue;
            sb.append(cur);
        }

        while (k-- > 0 && sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);

        return sb.length() != 0 ? sb.toString() : "0";
    }

}
