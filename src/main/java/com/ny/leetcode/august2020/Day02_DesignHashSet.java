package com.ny.leetcode.august2020;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Day02_DesignHashSet {

    public static void main(String[] args) {

    }

    private static class MyHashSet {
        List<Integer>[] buckets;
        int capacity = 1000;
        double loadFactor = 0.75;
        int count = 0;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            buckets = new LinkedList[capacity];
        }

        public void add(int key) {
            if (contains(key)) return;
            if (loadFactor * capacity == count) { //if we have reached the point where we want to rehash
                count = 0;
                //rehash
                capacity *= 2;
                List<Integer>[] oldBuckets = buckets;
                buckets = new LinkedList[capacity];
                for (List<Integer> list : oldBuckets) {
                    if (list != null) {
                        for (int entry : list)
                            this.add(entry);
                    }
                }
            }
            int hash = key % capacity;
            if (buckets[hash] == null)
                buckets[hash] = new LinkedList<>();
            buckets[hash].add(key);
            ++count;
        }

        public void remove(int key) {
            int hash = key % capacity;
            List<Integer> list = buckets[hash];
            if (list != null) {
                Iterator<Integer> itr = list.iterator();
                while (itr.hasNext())
                    if (itr.next() == key) {
                        itr.remove();
                        --count;
                    }
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int hash = key % capacity;
            List<Integer> list = buckets[hash];
            if (list != null) {
                for (Integer integer : list)
                    if (integer == key)
                        return true;
            }
            return false;
        }
    }

}
