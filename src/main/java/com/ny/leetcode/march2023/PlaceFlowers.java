package com.ny.leetcode.march2023;

import java.util.HashMap;
import java.util.Map;

public class PlaceFlowers {

    public static void main(String[] args) {

        PlaceFlowers f = new PlaceFlowers();
        System.out.println(f.canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 1, 0, 0}, 0));

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) return true;

        for (int i = 0; i < flowerbed.length; i++) {

            int v = flowerbed[i];

            if (v == 0) {

                boolean leftEmpty = i == 0 || flowerbed[i - 1] == 0;
                boolean rightEmpty = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) return true;
                }
            }

        }
        return false;

    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {

        Tracker ones = Tracker.start(false);
        Tracker zeroes = Tracker.start(true);

        int len = flowerbed.length;

        int p1 = 0, p2 = 1, p3 = 2;

        if (len == 1) return (flowerbed[0] == 0 && n <= 1) || flowerbed[0] == 1 && n == 0;
        if (len == 2) {
            int x = flowerbed[p1];
            int y = flowerbed[p2];
            if (x == 1 || y == 1) {
                return n == 0;
            } else return n == 1;
        }

        int i = 0, j = 1, k = 2;

        for (; k < len && n > 0; k++) {

            int x = flowerbed[i];
            int y = flowerbed[j];
            int z = flowerbed[k];


        }

        return n == 0;

    }

    private static class Tracker {
        int count;
        boolean zero = true;

        private Tracker(boolean zero) {
            this.zero = zero;
            this.count = 1;
        }

        private static Tracker start(boolean zero) {
            return new Tracker(zero);
        }

        public void reset() {
            this.count = 0;
        }

        public void increment() {
            this.count++;
        }
    }

}
