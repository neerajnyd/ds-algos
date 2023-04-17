package com.ny.codility;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(binaryGap(20));
    }

    private static int binaryGap(int N) {

        String s = Integer.toBinaryString(N);

        int gap = 0;

        int j = -1; //only points at 1s
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '1') {
                gap = Math.max(gap, i - j - 1);
                j = i;
            }
        }
        return gap;

    }


}
