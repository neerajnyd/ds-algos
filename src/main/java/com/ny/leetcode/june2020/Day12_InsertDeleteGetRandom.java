package com.ny.leetcode.june2020;

import java.util.*;

public class Day12_InsertDeleteGetRandom {

    List<Integer> list;
    Map<Integer, Integer> valueToIndex;
    Random rand;

    public Day12_InsertDeleteGetRandom() {
        list = new ArrayList<>();
        valueToIndex = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false;
        }
        list.add(val);
        int position = list.size() - 1;
        valueToIndex.put(val, position);
        return true;
    }

    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) {
            return false;
        }
        int index = valueToIndex.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        valueToIndex.put(lastElement, index);
        list.remove(list.size() - 1);
        valueToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }


}
