package com.ny.test;

public class Solution {

    public static void main(String[] args) {

        int[] a = {5,10};
        calc(a);

    }

    private static void calc(int[] a) {

        for(int query : a) {
            if(query <= 0) {
                System.out.println(0);
                continue;
            }
            if(query <= 2) {
                System.out.println(1);
                continue;
            }
            if(query %2 ==0) {
                query -= 1;
            }
            int sum = 0;
            for(int i = 1; i <= query; i+=2) {
                sum += i;
            }
            System.out.println(sum);
        }
    }

    private static String biggestEven(String s) {
        String largestWord = "00";
        if(s == null || s.isEmpty()) {
            return largestWord;
        }
        final String[] words = s.split(" ");
        int largest = 0;
        for(String word : words) {
            final int length = word.length();
            if(length %2 == 0 && length > largest) {
                largest = length;
                largestWord = word;
            }
        }
        return largestWord;
    }

}
