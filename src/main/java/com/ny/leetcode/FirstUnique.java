package com.ny.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUnique {

    int unique = -1;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public FirstUnique(int... nums) {
        for(int n : nums) {
            add(n);
        }
    }

    public void add(int num) {
        if(map.containsKey(num)) {
            Integer count = map.get(num);
            map.remove(num);
            map.put(num, count+1);
            if(unique == num) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(entry.getValue() == 1) {
                        unique = entry.getKey();
                        return;
                    }
                }
                unique = -1;

            }
        } else {
            map.put(num, 1);
            if(unique == -1)
                unique = num;
        }

    }

    public int showFirstUnique() {
        return unique;
    }

    public static void main(String[] args) {
        FirstUnique firstUnique  = new FirstUnique(809);
        firstUnique.showFirstUnique(); // return 809
        firstUnique.add(809);          // the queue is now [809,809]
        firstUnique.showFirstUnique(); // return -1
    }

}
