package com.ny.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) throws Exception {

        List<String> list = Arrays.asList("Neeraj", "Papa", "Mummy", "Akki", "Sakshi");

        Map<Integer, List<String>> collect = list.stream()
                .collect(
                        Collectors.groupingBy(String::length)
                );

        Map<Integer, Long> countByLength = list.stream()
                .collect(
                        Collectors.groupingBy(String::length, Collectors.counting())
                );

    }

}
