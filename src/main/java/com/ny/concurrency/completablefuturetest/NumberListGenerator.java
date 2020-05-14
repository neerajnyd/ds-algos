package com.ny.concurrency.completablefuturetest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class NumberListGenerator implements Supplier<List<Long>> {

    private final int size;

    public NumberListGenerator(int size) {
        this.size = size;
    }

    @Override
    public List<Long> get() {
        List<Long> longs = new ArrayList<>();
        System.out.printf("%s : NumberListGenerator. Start\n", Thread.currentThread().getName());
        for (int i = 0; i < 1_000_000; i++) {
            long round = Math.round(Math.random() * Long.MAX_VALUE);
            longs.add(round);
        }
        System.out.printf("%s : NumberListGenerator. END\n", Thread.currentThread().getName());
        return longs;
    }
}
