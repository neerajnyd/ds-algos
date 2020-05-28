package com.ny.leetcode.may2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day19_StockSpan {

    private final int[] pricesStack;
    private final int[] spansStack;
    private int top;

    public Day19_StockSpan() {
        pricesStack = new int[10000];
        spansStack = new int[10000];
        top = -1;
    }

    public int next(int price) {
        int span = 1;
        while (0 <= top && pricesStack[top] <= price) {
            span += spansStack[top--];
        }
        top++;
        pricesStack[top] = price;
        spansStack[top] = span;
        return span;
    }

    /*final List<int[]> list;

    public Day19_StockSpan() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        int n = list.size();
        if(n == 0) {
            list.add(new int[]{price, 1});
            return 1;
        } else {
            int R = 1;
            for (int i = n-1; i >= 0 ;) {
                int[] prev = list.get(i);
                if(prev[0] > price) {
                    break;
                } else {
                    int val = prev[1];
                    R += val;
                    i -= val;
                }
            }
            list.add(new int[]{price, R});
            return R;
        }
    }*/

    public static void main(String[] args) {

        Day19_StockSpan stockSpan = new Day19_StockSpan();
        System.out.println(stockSpan.next(100));
        System.out.println(stockSpan.next(80));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(70));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(75));

    }

}
