package com.ny.leetcode;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolOne {

    public static void main(String args[]) throws Exception {
        final Scanner sc = new Scanner(new File("C:\\Users\\NY\\Desktop\\tc.txt"));
        int N = sc.nextInt();
        Map<Long, Long> map = new HashMap<>();
        for(int i=0; i<N; i++){
            long floors = sc.nextLong();
            if(!map.containsKey(floors)) {
                map.put(floors, 1L);
            } else {
                map.put(floors, map.get(floors) + 1);
            }
        }
        long out = solve(map);
        System.out.println(out);
    }

    public static long solve(Map<Long, Long> map){
        long count = 0;

        for(Map.Entry<Long, Long> entry:map.entrySet()) {
            long key = entry.getKey();
            long value = entry.getValue();
            if(key==1) {
                if(value > 1) {
                    long fact = 1;
                    while (value >= 1) {
                        fact *= value;
                        value--;
                    }
                    count += fact;
                }
            } else {
                long keySq = key * key;
                if(map.containsKey(keySq)) {
                    long sqValue = map.get(keySq);
                    long addToCount = value * sqValue;
                    count += addToCount;
                }
            }
        }

        return count;
    }
}
