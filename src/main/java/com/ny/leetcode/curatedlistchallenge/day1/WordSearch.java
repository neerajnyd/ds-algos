package com.ny.leetcode.curatedlistchallenge.day1;

/*
https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] B = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};
        System.out.println(exist(B, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] B, String word) {
        int wordSize = word.length();
        int m = B.length;
        int n = B[0].length;

        if (m * n < wordSize) return false;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (check(B, i, j, word, 0))
                    return true;
        return false;
    }

    private static boolean check(char[][] B, int i, int j, String word, int posUnderTest) {
        if (posUnderTest == word.length()) return true;

        char charUnderTest = word.charAt(posUnderTest);
        //these checks are here so we can make calls before doing this sanity of input
        if (i<0 || j<0 || i>=B.length || j>=B[0].length || charUnderTest != B[i][j])
            return false;

        B[i][j] = '0';//the character becomes unusable till we check its surroundings

        boolean leftCheck = check(B, i, j - 1, word, posUnderTest + 1);
        boolean rightCheck = check(B, i, j + 1, word, posUnderTest + 1);
        boolean upCheck = check(B, i - 1, j, word, posUnderTest + 1);
        boolean downCheck = check(B, i + 1, j, word, posUnderTest + 1);

        if(leftCheck || rightCheck || upCheck || downCheck)
            return true;

        B[i][j] = charUnderTest; //character is usable again

        return false;
    }

    /*
    Not mine
     */
    public boolean exist2(char[][] board, String word) {
        /*Find word's first letter.  Then call method to check its surroundings */
        for(int r=0; r<board.length; r++)
            for(int c=0; c<board[0].length; c++)
                if(word.charAt(0)==board[r][c] && search2(board,word,r,c,0)) return true;

        return false;
    }

    public boolean search2(char[][] B, String word, int i, int j, int x){
        /* once we get past word.length, we are done. */
        if(x == word.length()) return true;

        /* if off bounds, letter is seen, letter is unequal to word.charAt(start) return false */
        if(i<0 || i>=B.length || j<0 || j>=B[0].length || word.charAt(x)!=B[i][j]) return false;

        /* set this board position to seen. (Because we can use this postion) */
        B[i][j] = '0';

        /* recursion on all 4 sides for next letter, if works: return true */
        if(
                search2(B,word,i-1,j,x+1) ||
                        search2(B,word,i+1,j,x+1) ||
                        search2(B,word,i,j-1,x+1) ||
                        search2(B,word,i,j+1,x+1)
        ) return true;

        /* Set back to unseen */
        B[i][j] = word.charAt(x);

        return false;
    }

}
