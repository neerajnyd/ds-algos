package com.ny.leetcode.contest339;

import com.ny.leetcode.ArrayUtil;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Two {

    public static void main(String[] args) {
        Two o = new Two();
        int[] arr = ArrayUtil.read("[1,2,3,4]");
        System.out.println(o.findMatrix(arr));
    }

    public List<List<Integer>> findMatrix(int[] nums) {

        Map<Integer, Pair> counts = new HashMap<>();
        for (int num : nums) {
            if(counts.containsKey(num)) {
                Pair pair = counts.get(num);
                pair.count = pair.count + 1;
            } else {
                counts.put(num, new Pair(num, 1));
            }
        }
        List<Pair> pairs = new ArrayList<>(counts.values());
        Collections.sort(pairs);

        List<List<Integer>> result = new ArrayList<>();

        Pair biggest = pairs.get(0);
        int i = 0;
        while (i < biggest.count) {
            List<Integer> list = new ArrayList<>();
            list.add(biggest.num);
            result.add(list);
            i++;
        }
        for (int j = 1; j < pairs.size(); j++) {
            Pair pair = pairs.get(j);
            for (int k = 0; k < pair.count; k++) {
                List<Integer> list = result.get(k);
                list.add(pair.num);
            }
        }
        return result;
    }

    private static class Pair implements Comparable<Pair> {

        private final int num;
        private int count;

        public Pair(int num) {
            this.num = num;
        }

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            return num == pair.num;
        }

        @Override
        public int hashCode() {
            return num;
        }

        @Override
        public int compareTo(Pair that) {
            return Integer.compare(that.count, this.count);
        }
    }



}
