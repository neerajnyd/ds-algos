package com.ny.epi;

public class EvenOddArray {

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9,10};
        evenOdd(A);
    }

    private static void evenOdd(int[] A) {
        int nextEven = 0, nextOdd = A.length-1;
        while(nextEven < nextOdd) {
            if(A[nextEven] % 2 == 0) {
                nextEven++;
            } else {
                //we exchange from the end but we don't know if it too was even or not so we don't increment nextEven
                int temp = A[nextEven];
                A[nextEven] = A[nextOdd];
                A[nextOdd--] = temp;
            }
        }
        for (int i1 = 0; i1 < A.length; i1++) {
            int i = A[i1];
            System.out.println();
            System.out.println(i1 + ": " + i);
        }
    }
}
