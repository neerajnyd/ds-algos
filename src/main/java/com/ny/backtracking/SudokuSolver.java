package com.ny.backtracking;

import com.ny.util.Util;

/*
https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {

    public static void main(String[] args) {
        char[][] B = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Util.print2DArray(B);
        solveSudoku(B);
        Util.print2DArray(B);
    }

    private static void solveSudoku(char[][] B) {
        solve(B);
    }


    public static boolean solve(char[][] board) {
        Util.print2DArray(board);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValidPlacement(board, row, col, ch)) {
                            board[row][col] = ch;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false; //this is important, otherwise we skip solving few places
                }

            }
        }
        return true;

    }

    private static boolean isValidPlacement(char[][] B, int i, int j, char ch) {
        for (int k = 0; k < 9; k++) {
            if (B[k][j] == ch) return false; //ch exists in row already
            if (B[i][k] == ch) return false; //ch exists in col already
            if (B[(3*(i/3))+(k/3)][(3*(j/3))+(k%3)] == ch) return false; //ch exists in 3*3 block already
        }
        return true;
    }

}
