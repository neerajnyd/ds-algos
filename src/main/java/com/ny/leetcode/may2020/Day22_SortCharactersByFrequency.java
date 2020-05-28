package com.ny.leetcode.may2020;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Day22_SortCharactersByFrequency {

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        return map.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .map(entry -> {
                    StringBuilder sb = new StringBuilder();
                    for (int count = 0; count < entry.getValue(); count++)
                        sb.append(entry.getKey());
                    return sb.toString();
                }).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }
}
