package com.ny.epi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArbitraryPrecisionNumber {

    private static List<Integer> plusOne(List<Integer> A) {

        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);

        for (int i = n; i >= 0 && A.get(i) == 10; --i) {
            A.set(i, 0);
            A.set(i - 1, A.get((i - 1) + 1));
        }
        if (A.get(0) == 10) {
            A.set(0, 0);
            A.add(0, 1);
        }
        return A;

    }

    private static List<Integer> multiply(List<Integer> A, List<Integer> B) {
        final int sign = (A.get(0) < 0 ^ (B.get(0) < 0)) ? -1 : 1; //Bitwise OR - non-short-circuit operation - both either true or both false
        A.set(0, Math.abs(A.get(0)));
        B.set(0, Math.abs(B.get(0)));
        List<Integer> R = new ArrayList<>(Collections.nCopies(A.size() + B.size(), 0)); //a mutable list full of zeroes

        for (int i = A.size() - 1; i >= 0; --i) {
            for (int j = B.size() - 1; j >= 0; --j) {
                //set the value in results at position i+j+1
                R.set(i + j + 1, R.get(i + j + 1) + A.get(i) * B.get(j));
                R.set(i + j, R.get(i + j) + R.get(i + j + 1) / 10);
                R.set(i + j + 1, R.get(i + j + 1) % 10);
            }
        }
        //remove leading zeroes
        int k = 0;
        while (k < R.size() && R.get(k) == 0) {
            ++k;
        }
        R = R.subList(k, R.size());
        if (R.isEmpty()) {
            return Collections.singletonList(0);
        }
        //set sign
        R.set(0, R.get(0) * sign);
        return R;
    }


    public static void main(String[] args) {

        List<Integer> A = Arrays.asList(-1, 2, 3);
        List<Integer> B = Arrays.asList(9, 8, 7);

        final List<Integer> multiply = multiply(A, B);
        System.out.println(multiply);


    }


}
