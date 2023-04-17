package com.ny.leetcode.april2023;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0, lo = 0, hi = people.length - 1;

        while (lo < hi) {
            if (people[lo] + people[hi] <= limit) lo++;

            hi--;
            count++;
        }

        if (lo == hi) count++;

        return count;
    }

}
