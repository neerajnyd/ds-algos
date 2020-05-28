package com.ny.leetcode.curatedlistchallenge.day6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/meeting-rooms-ii/

Statement: Given an array of meeting time intervals consisting of start and end times
            [[s1,e1],[s2,e2],...] (si < ei),
            find the minimum number of conference rooms required.

            For example,
            Given [[0, 30],[5, 10],[15, 20]],
            return 2.
 */
public class MeetingRooms2 {

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //[[0, 30],[5, 10],[15, 20]]
        //minHeap = 20, 30
        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(interval[1]);
        }
        return minHeap.size();
    }

    public static int minimumRooms(int[][] A) {

        Arrays.sort(A, (o1, o2) -> {
            int c = Integer.compare(o1[0], o2[0]);
            if(c != 0) return c;
            else return Integer.compare(o1[1], o2[1]);
        });

        int rooms = 1;

        for (int i = 0, j = i+1; i < A.length - 1; i++, j++) {
            int a = A[i][0];
            int b = A[i][1];
            int c = A[j][0];
            int d = A[j][1];

            if(c < b) { //overlap
                rooms++;
            }

        }

        return rooms;
    }

    public static void main(String[] args) {
        int[][] A = {{0, 30},{5, 10},{15, 20}};
        System.out.println(minMeetingRooms(A));
    }
}
