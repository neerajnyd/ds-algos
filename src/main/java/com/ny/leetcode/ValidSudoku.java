package com.ny.leetcode;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        System.out.println(isValidSudoku(board));
    }

    /* Just trying to explain how to think about % and /. These two operators can be helpful for matrix traversal problems.
    For a block traversal, it goes the following way.
    0,0, 0,1, 0,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.
    1,0, 1,1, 1,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.
    2,0, 2,1, 2,2; < --- 3 Horizontal Steps.
    And so on...
    But, the j iterates from 0 to 9.
    But we need to stop after 3 horizontal steps, and go down 1 step vertical.
    Use % for horizontal traversal. Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2, and resets back.
    So this covers horizontal traversal for each block by 3 steps.
    Use / for vertical traversal. Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1.
    So far, for a given block, you can traverse the whole block using just j.
    But because j is just 0 to 9, it will stay only first block. But to increment block, use i. To move horizontally to next block, use % again : ColIndex = 3 * i%3 (Multiply by 3 so that the next block is after 3 columns. Ie 0,0 is start of first block, second block is 0,3 (not 0,1);
    Similarly, to move to next block vertically, use / and multiply by 3 as explained above. Hope this helps. */
    public static boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                } else {
                    int rowCheckArrayIndex = board[row][col] - '1';
                    boolean invalidRow = rowCheck[rowCheckArrayIndex];
                    if (invalidRow) {
                        return false;
                    } else {
                        rowCheck[rowCheckArrayIndex] = true;
                    }
                }
                if (board[col][row] == '.') {
                } else {
                    int colCheckArrayIndex = board[col][row] - '1';
                    boolean invalidCol = colCheck[colCheckArrayIndex];
                    if (invalidCol) {
                        return false;
                    } else {
                        colCheck[colCheckArrayIndex] = true;
                    }
                }
                int boxRow = row / 3 * 3 + col / 3;
                int boxCol = row % 3 * 3 + col % 3;
                if (board[boxRow][boxCol] == '.') {
                } else {
                    int boxCheckArrayIndex = board[boxRow][boxCol] - '1';
                    boolean invalidBox = boxCheck[boxCheckArrayIndex];
                    if (invalidBox) {
                        return false;
                    } else {
                        boxCheck[boxCheckArrayIndex] = true;
                    }
                }
            }
        }
        return true;
    }


}
