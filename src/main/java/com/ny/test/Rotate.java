package com.ny.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rotate {

    public static void main(String[] args) {
        final List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198));
        A.add(Arrays.asList(401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10));
        A.add(Arrays.asList(112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126));
        final ArrayList<Integer> integers = spiralOrder(A);
        for (Integer i : integers) {
            System.out.print(i + " ");
        }
        final int[] ints = {};
    }

    public static ArrayList<Integer> spiralOrder(final List<List<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int T = 0, B = A.size()-1;
        int L = 0, R = A.get(0).size()-1;
        int dir = 0;
        while (L <= R && T <= B) {
            if (dir == 0) {
                for (int k = L; k <= R; k++) {
                    result.add(A.get(T).get(k));
                }
                T++;
            } else if (dir == 1) {
                for (int k = T; k <= B; k++) {
                    result.add(A.get(k).get(R));
                }
                R--;
            } else if (dir == 2) {
                for (int k = R; k >= L; k--) {
                    result.add(A.get(B).get(k));
                }
                B--;
            } else if (dir == 3) {
                for (int k = B; k >= T; k--) {
                    result.add(A.get(k).get(L));
                }
                L++;
            }
            dir = (dir+1)%4;
        }
        return result;
    }


}
