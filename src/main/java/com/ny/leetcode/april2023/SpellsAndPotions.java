package com.ny.leetcode.april2023;

import java.util.Arrays;

public class SpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); //for binary search

        int[] R = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];

            int lo = 0, hi = potions.length - 1;

            while (lo <= hi) {

                int mid = lo + (hi - lo) / 2;
                long strength = (long) spell * potions[mid];

                if (strength >= success) hi = mid - 1;
                else lo = mid + 1;
            }
            //lo points to the smallest strength larger than success strength
            R[i] = potions.length - lo;
        }
        return R;
    }

}
