package com.ny.zalando;

public class ReverseNumber {
    public static void main(String args[]) throws Exception {

//        solutionNew(10123000);
        solution(246);
    }

    public static void solution(int N) {
        int enable_print =  0; //6
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
        System.out.println();
    }

    public static int reverse(int N) {
        int reversedNum = 0;
        while (N != 0) {
            int remainder = N % 10;

            int reversedCopy = reversedNum * 10 + remainder;
            if ((reversedCopy - remainder) / 10 != reversedNum) {
                return 0;
            }
            reversedNum = reversedCopy;
            N = N / 10;
        }
        return reversedNum;
    }
}
