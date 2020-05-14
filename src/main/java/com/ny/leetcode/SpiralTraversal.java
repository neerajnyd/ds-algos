package com.ny.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralTraversal {

    public static void main(String[] args) {
        int[][] M = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> integers = spiralOrder(M);
        printList(integers);
    }

    private static void printList(List<Integer> integers) {
        System.out.println(integers.stream().map(Object::toString).collect(Collectors.joining(" ", "[", "]")));
    }

    public static List<Integer> squareMatrixSpiralOrder(int[][] M) {
        final int[][] SHIFT = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0, r = 0, c = 0;
        List<Integer> spiralOrdering = new ArrayList<>();
        int size = M.length;
        for (int i = 0; i < size * size; ++i) {
            spiralOrdering.add(M[r][c]);
            M[r][c] = 0;
            int rN = r + SHIFT[dir][0], cN = c + SHIFT[dir][1];
            if (rN < 0 || rN >= size || cN < 0 || cN >= size || M[r][c] == 0) {
                dir = (dir + 1) % 4;
                rN = r + SHIFT[dir][0];
                cN = c + SHIFT[dir][1];
            }
            r = rN;
            c = cN;
        }
        return spiralOrdering;
    }

    private static List<Integer> spiralOrder(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return Collections.emptyList();
        List<Integer> R = new ArrayList<>();
        int m = M.length;
        int n = M[0].length;
        boolean[][] V = new boolean[m][n];

        boolean right = true, left  = false, up = false, down = false;

        for (int i = 0, r = 0, c = 0; i < m * n; i++) {
            printList(R);
            R.add(M[r][c]);
            V[r][c] = true;
            if (right) {
                if (c == n - 1 || V[r][c + 1]) {
                    right = false;
                    down = true;
                    r += 1;
                } else {
                    c += 1;
                }
            } else if (down) {
                if (r == m - 1 || V[r + 1][c]) {
                    down = false;
                    left = true;
                    c -= 1;
                } else {
                    r += 1;
                }
            } else if (left) {
                if (c == 0 || V[r][c - 1]) {
                    left = false;
                    up = true;
                    r -= 1;
                } else {
                    c -= 1;
                }
            } else if (up) {
                if (r == 0 || V[r - 1][c]) {
                    up = false;
                    right = true;
                    c += 1;
                } else {
                    r -= 1;
                }
            }
        }
        return R;

    }

}
