package com.ny.leetcode;

public class ReverseString {

    public static void main(String[] args) {

        char[] s = {'h','e','l','o'};

        reverseString(s);

        for (char c : s) {
            System.out.print(c + " ");
        }

    }

    public static void reverseString(char[] s) {
        if(s.length < 2) return;

        for(int i=0, j=s.length-1; i<j; i++,j--) {
            char x = s[i];
            s[i] = s[j];
            s[j] = x;
        }

    }

}
