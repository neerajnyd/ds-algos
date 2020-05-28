package com.ny.leetcode.comp;

public class StudyTime {

    public static void main(String[] args) {
        System.out.println(busyStudent(
                new int[]{
                        9,8,7,6,5,4,3,2,1
                },
                new int[]{
                        10,10,10,10,10,10,10,10,10
                },
                5
        ));
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            final int start = startTime[i];
            final int end = endTime[i];
            if (queryTime >= start && queryTime <= end) {
                count++;
            }
        }

        return count;

    }

}
