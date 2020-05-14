package com.ny.pramp;

public class Three_TimePlanner {

    public static void main(String[] args) {

    }

    public static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        for (int a = 0, b = 0; a < slotsA.length && b < slotsB.length; ) {
            int[] slotA = slotsA[a];
            int[] slotB = slotsB[b];

            int start = Math.max(slotA[0], slotB[0]);
            int end = Math.min(slotA[1], slotB[1]);
            if (end - start >= dur)
                return new int[]{start, start + dur};
            else if (slotA[1] > slotB[1])
                b++;
            else a++;
        }
        return new int[]{};
    }

    public static int[] meetingPlanner_bruteForce(int[][] slotsA, int[][] slotsB, int dur) {
        for (int[] slotA : slotsA) {
            int x = slotA[0];
            int y = slotA[1];
            if (y - x < dur) continue;
            for (int[] slotB : slotsB) {
                int a = slotB[0];
                int b = slotB[1];
                if (b - a < dur) continue;

                int start = Math.max(x, a);
                int end = Math.min(y, b);

                if (end - start >= dur) return new int[]{start, start + dur};
            }
        }
        return new int[]{};
    }


}
