package com.ny.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {


    public static void main(String[] args) {

        int[] stones = {
                2, 7, 4, 1, 8, 1
        };

        final int stoneWeight = lastStoneWeight(stones);
        System.out.println(stoneWeight);

    }

    private static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(stones.length, (o1, o2) -> Integer.compare(o2, o1));

        for (int x : stones) q.offer(x);

        while (q.size() >= 2) {
            Integer y = q.poll();
            Integer x = q.poll();
            int z = y - x;
            if (z > 0) {
                q.offer(z);
            }
        }
        return 0;
    }

    private static int lastStoneWeightTrash(int[] stones) {
        Arrays.sort(stones);
        for (int i = stones.length - 1; i > 0; i--) {

            int y = stones[i];
            int x = stones[i - 1];
            stones[i - 1] = y - x;
            stones[i] = 0;
            if (stones[i - 1] == 0) i--;
        }
        return stones[0];
    }

}
