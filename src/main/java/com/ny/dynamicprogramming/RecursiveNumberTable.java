package com.ny.dynamicprogramming;

public class RecursiveNumberTable {

    public static void main(String[] args) {
        System.out.println("RESULT " + numberTable(5, 3));
    }

    private static int numberTable(int n, int i) {
        int x = i == 1 ? n : n + numberTable(n, i - 1);
        System.out.println(n + " * " + i + " = " + x);
        return x;
    }

}
