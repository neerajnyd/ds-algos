package com.ny.gfg.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class String_01_ReverseWordsInAString {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(new File("C:\\Users\\NY\\Desktop\\tc.txt"));
//      Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int i = 0; i < T; i++) {
            String s = in.nextLine();
            process(s);
        }
        in.close();
    }

    private static void process(String s) {
        char[] A = s.toCharArray();
        int n = s.length();
        reverse(A, 0, n-1);
        reverseEachWord(A, n);
        for (char x : A) {
            System.out.print(x);
        }
        System.out.println();
    }

    private static void reverseEachWord(char[] a, int n) {
        int i=0, j=0;

        while (i < n) {
            while (i < j || (i < n && a[i] == '.')) i++;
            while (j < i || (j < n && a[j] != '.')) j++;
            reverse(a, i, j-1);
        }

    }

    private static void reverse(char[] a, int i, int j) {
        while(i < j) {
            char x = a[i];
            a[i] = a[j];
            a[j] = x;
            i++; j--;
        }

    }
}
