package com.ny.leetcode.comp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

public class RearrangeWordsFirstCapitalAndIncreasingLength {

    public static void main(String[] args) {
        System.out.println(
               arrangeWords("Keep calm and code on")
        );
    }

    public static String arrangeWords(String text) {
        final String[] words = text.split(" ");
        Arrays.sort(words, Comparator.comparingInt(String::length));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            final String s = words[i];
            final char[] chars = s.toCharArray();

            if(i==0) {
                chars[0] = Character.toUpperCase(chars[0]);
            } else {
                chars[0] = Character.toLowerCase(chars[0]);
            }
            sb.append(new String(chars)).append(" ");
        }
        if(sb.length() > 1) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

}
