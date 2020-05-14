package com.ny.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

        /*for (int i = 0; i <= 10; i++) {

            List<List<Integer>> pascal = generate(i);

            for (List<Integer> list : pascal) {
                for (Integer x : list) {
                    System.out.print("'" + x + "' ");
                }
                System.out.println();
            }
            System.out.println();
        }*/
        List<List<Integer>> pascal = generate2(5);
        for (List<Integer> list : pascal) {
            for (Integer x : list) {
                System.out.print("'" + x + "' ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                final Integer atJ = row.get(j);
                final Integer atJPlusOne = row.get(j + 1);
                row.set(j, atJ + atJPlusOne);
            }
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();
        List<List<Integer>> R = new ArrayList<>();
        List<Integer> seedList = new ArrayList<>();
        seedList.add(1);
        R.add(seedList);
        if (numRows == 1) return R;
        List<Integer> C = seedList;
        do {
            C = createNext(C);
            R.add(C);
            numRows--;
        } while (numRows >= 2);

        return R;
    }

    private static List<Integer> createNext(List<Integer> A) {
        Integer[] B = new Integer[A.size() + 1];
        B[0] = 1;
        B[B.length - 1] = 1;
        for (int i = 0; i < A.size() - 1; i++) {
            B[i + 1] = A.get(i) + A.get(i + 1);
        }
        return Arrays.asList(B);
    }
}
