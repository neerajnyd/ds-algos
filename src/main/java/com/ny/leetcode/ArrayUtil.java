package com.ny.leetcode;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    public static int[] read(String s) {
        if (s == null || s.length() < 3) return new int[]{};

        String[] numS = s.substring(1, s.length() - 1).split(",");
        int[] nums = new int[numS.length];
        for (int i = 0; i < numS.length; i++) {
            nums[i] = Integer.parseInt(numS[i].trim());
        }
        return nums;
    }

    public static int[][] read2D(String input) {
        if (input == null || input.length() < 5) return new int[][]{};

        String s = input.replace(" ", "");

        String[] arrays = s.substring(2, s.length() - 2).split("],\\["); //1,2,9

        List<int[]> list = new ArrayList<>();

        for (String arr : arrays) {
            String[] numS = arr.split(",");
            int[] nums = new int[numS.length];
            for (int j = 0; j < numS.length; j++) {
                nums[j] = Integer.parseInt(numS[j].trim());
            }
            list.add(nums);
        }
        return list.toArray(new int[][]{});
    }


}
