package com.ny.leetcode;

public class WordSearch {

    public static void main(String[] args) {


        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED")); //true
        System.out.println(exist(board, "SEE")); //true
        System.out.println(exist(board, "ABCB")); //false
    }

    public static boolean exist(char[][] board, String word) {
        /*Find word's first letter.  Then call method to check its surroundings */
        for(int r=0; r<board.length; r++)
            for(int c=0; c<board[0].length; c++)
                if(word.charAt(0)==board[r][c] && search(board,word,r,c,0)) return true;

        return false;
    }

    public static boolean search(char[][] B, String word, int r, int c, int index){
        /* once we get past word.length, we are done. */
        if(index == word.length()) return true;

        /* if off bounds, letter is seen, letter is unequal to word.charAt(start) return false */
        if(r<0 || r>=B.length || c<0 || c>=B[0].length || word.charAt(index)!=B[r][c]) return false;

        /* set this board position to seen. (Because we can use this postion) */
        B[r][c] = '0';

        /* recursion on all 4 sides for next letter, if works: return true */
        if(
            search(B,word,r-1,c,index+1) ||
            search(B,word,r+1,c,index+1) ||
            search(B,word,r,c-1,index+1) ||
            search(B,word,r,c+1,index+1)
        ) return true;

        /* Set back to unseen */
        B[r][c] = word.charAt(index);

        return false;
    }
}
