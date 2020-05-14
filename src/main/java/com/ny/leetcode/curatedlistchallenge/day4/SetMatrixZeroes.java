package com.ny.leetcode.curatedlistchallenge.day4;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {


    }

    public void setZeroes(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i : rows) {
            for (int j = 0; j < M[0].length; j++) {
                M[i][j] = 0;
            }
        }

        for (int i = 0; i < M.length; i++) {
            for (int j : cols) {
                M[i][j] = 0;
            }
        }

    }

}
