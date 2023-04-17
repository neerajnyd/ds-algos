package com.ny.leetcode.april2023;

import java.util.ArrayList;
import java.util.List;

public class HighestCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int c : candies) {
            if (c > max) {
                max = c;
            }
        }
        for (int c : candies) {
            result.add(c + extraCandies >= max);
        }

        return result;

    }

}
