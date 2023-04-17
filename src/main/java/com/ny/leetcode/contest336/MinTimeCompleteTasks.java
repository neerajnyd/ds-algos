package com.ny.leetcode.contest336;

import java.util.*;

public class MinTimeCompleteTasks {

    public static void main(String[] args) {
        MinTimeCompleteTasks tasks = new MinTimeCompleteTasks();


        System.out.println(tasks.findMinimumTime(new int[][]{
                {2, 3, 1}, {4, 5, 1}, {1, 5, 2} //
        }));
        System.out.println(tasks.findMinimumTime(new int[][]{
                {1, 3, 2}, {2, 5, 3}, {5, 6, 2}
        }));
    }

    public int findMinimumTime(int[][] tasks) {


        Arrays.sort(tasks, Comparator.comparingInt(task -> task[1])); //sort by end times

        boolean[] slots = new boolean[2001];
        int result = 0;

        for (int[] task : tasks) {

            int start = task[0], end = task[1], duration = task[2];

            for (int i = start; i <= end && duration > 0; i++) {
                if (slots[i]) {
                    duration--;
                }
            }

            for (int i = end; duration > 0 && i >= start; i--) {
                if (!slots[i]) {
                    slots[i] = true;
                    duration--;

                    result++;
                }
            }
        }

        return result;
    }

}
