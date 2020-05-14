package com.ny.leetcode.may2020;

public class Day11_FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //[0,0,0]
        //[0,1,1]
        //[r,c] = [1,1]
        //newColor = 1

        boolean[][] V = new boolean[image.length][image[0].length];

        helper(image, V, sr, sc, image[sr][sc], newColor);

        return image;
    }

    private void helper(int[][] image, boolean[][] V, int r, int c, int oldColor, int newColor) {

        if(r<0 || c<0 || r==image.length || c==image[0].length || V[r][c]) return;

        V[r][c] = true;

        if(image[r][c] != oldColor) return;

        image[r][c] = newColor;

        helper(image, V, r-1, c, oldColor, newColor);
        helper(image, V, r+1, c, oldColor, newColor);
        helper(image, V, r, c-1, oldColor, newColor);
        helper(image, V, r, c+1, oldColor, newColor);

    }
}
