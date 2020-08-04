package com.ny.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/n-queens/
 */
public class N_Queens {

    public static void main(String[] args) {

        System.out.println(solveNQueens(4));
    }

    /*
    A row based solution in which each queen is placed in a different row
    We still can have column and diagonal based collisions
    We keep track of the column no for each row
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();

        solve(n, 0, new ArrayList<>(), result);

        return constructSolution(result, n);
    }

    //populates result to contain valid column placament numbers of each row
    private static void solve(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
        System.out.println("________SOLVE START___________");
        if (row == n) {
            System.out.println("______Adding result " + colPlacement);
            System.out.println("_________________________________");
            result.add(new ArrayList<>(colPlacement));
            return;
        }
        for (int col = 0; col < n; col++) {
            colPlacement.add(col);
            System.out.println(colPlacement);
            if (isValid(colPlacement)) {
                solve(n, row + 1, colPlacement, result);
            }
            colPlacement.remove(colPlacement.size() - 1);
            System.out.println(colPlacement);
        }
        System.out.println("________SOLVE END___________");
    }

    /* when colPlacement size is one that means we have value in row 0 only. That's why newRow is 0.
    when colPlacement size is two that means we have values in row 0 and 1, newRow = 1.
    and so on
    Difference in column placement values of two rows must not equal to difference between two rows
    */
    private static boolean isValid(List<Integer> colPlacement) {
        int newRow = colPlacement.size() - 1;
        int newColNo = colPlacement.get(newRow);
        for (int row = 0; row < newRow; row++) {
            int colAtRow = colPlacement.get(row);
            int colDiff = Math.abs(newColNo - colAtRow);
            if (colDiff == 0) {
                System.out.println("Removing because in same column");
                return false;
            } else if (colDiff == newRow - row) {
                System.out.println("Removing because diagonally attack on rows -> " + newRow + ", " + row + " Diff is " + colDiff);
                return false;
            }
        }
        return true;
    }

    private static List<List<String>> constructSolution(List<List<Integer>> results, int n) {
        List<List<String>> strResults = new ArrayList<>();
        for (List<Integer> result : results) {
            List<String> strResult = new ArrayList<>();
            for (int value : result) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(
                            i == value ? "Q" : "."
                    );
                }
                strResult.add(sb.toString());
            }
            strResults.add(strResult);
        }
        return strResults;
    }
}
