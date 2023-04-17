package com.ny.leetcode.curated.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //store the larger half
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); //store the smaller half

    public MedianFinder() {
    }

    public void addNum(int num) {

        if (minHeap.isEmpty()) {
            minHeap.add(num);
        } else {
            if (minHeap.peek() <= num) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.remove());
        }
    }

    public double findMedian() {
        int n1 = minHeap.size();
        int n2 = maxHeap.size();

        if (n1 == n2 && n1 != 0) {
            return 0.5 * (minHeap.peek() + maxHeap.peek());
        } else if (n1 > n2) {
            return (double) minHeap.peek();
        } else return 0.0;

    }

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0

    }

}
