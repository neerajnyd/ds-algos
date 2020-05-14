package com.ny.leetcode;

public class ReverseWords {

    public static void main(String[] args) {
        char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
        System.out.print("Input: ");
        for(char c : arr) System.out.print(c);
        System.out.println();
        System.out.print("Output: ");
        for(char c : reverseWords(arr)) System.out.print(c);
    }

    public static char[] reverseWords(char[] arr) {
        if(arr == null || arr.length == 0) return arr;
        reverse(arr, 0, arr.length-1);
        reverseWords(arr, arr.length);
        return arr;
    }

    private static void reverseWords(char[] A, int n) {
        int i = 0, j = 0;
        while(i < n) {
            while(i < j || i < n && A[i] == ' ') i++;
            while(j < i || j < n && A[j] != ' ') j++;
            reverse(A, i, j-1);
        }
    }

    private static void reverse(char[] A, int i, int j) {
        while(i < j) {
            char t = A[i];
            A[i++] = A[j];
            A[j--] = t;
        }
    }

}
