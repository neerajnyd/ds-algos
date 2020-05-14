package com.ny.gfg.heap;

import java.io.File;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap_01_MedianElement {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("C:\\Users\\NY\\Desktop\\tc.txt"));
        int nums = in.nextInt();
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                16, Collections.reverseOrder()
        );

        for (int i = 0; i < nums; i++) {
            int x = in.nextInt();

            if (minHeap.isEmpty()) {
                minHeap.add(x);
            } else {
                if (x >= minHeap.peek()) {
                    minHeap.add(x);
                } else {
                    maxHeap.add(x);
                }
            }

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.remove());
            } else if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }

            long x1 = minHeap.size() == maxHeap.size() ? (long) Math.floor(0.5 * (minHeap.peek() + maxHeap.peek())) : minHeap.peek();
            System.out.println(x1);

        }

    }

}
