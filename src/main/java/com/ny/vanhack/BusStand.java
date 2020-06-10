package com.ny.vanhack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusStand {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new File("C:\\Users\\local1\\Downloads\\input002.txt"));
        int k = in.nextInt();
        int pCount = in.nextInt();
        List<Integer> patience = new ArrayList<>();

        for (int i = 0; i < pCount; i++) {
            patience.add(in.nextInt());
        }
        int qCount = in.nextInt();
        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < qCount; i++) {
            queries.add(in.nextInt());
        }

        System.out.println(kthPerson(
                k, patience, queries
        ));
    }

    public static List<Integer> kthPerson(int k, List<Integer> patience, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        outer:
        for (int busArrivalTime : queries) {
            int count = 0;
            for (int p = 0; p < patience.size(); p++) {
                if (patience.get(p) >= busArrivalTime) {
                    count++;
                    if (count == k) {
                        result.add(p + 1);
                        continue outer;
                    }
                }
                p++;
            }
            result.add(0);
        }
        return result;
    }

    public static List<Integer> kthPerson_8_of_9(int k, List<Integer> patience, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            result.add(getQueryResult(k, patience, q));
        }
        return result;
    }

    private static int getQueryResult(int remainingSeats, List<Integer> people, int q) {
        int i = 0;
        while (i < people.size() && remainingSeats > 0) {
            if (remainingSeats > people.size() - i) { //if remainingSeats > remaining people
                return 0;
            } else if (people.get(i) >= q) {
                remainingSeats--;
            }
            i++;
        }
        return (remainingSeats > 0 ? 0 : i);
    }
}
