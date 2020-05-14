package com.ny.concurrency.completablefuturetest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SeedGenerator implements Runnable {

    private CompletableFuture<Integer> resultCommunicator;

    public SeedGenerator(CompletableFuture<Integer> resultCommunicator) {
        this.resultCommunicator = resultCommunicator;
    }

    @Override
    public void run() {

        System.out.println("Seed generator: Generating seed");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int seed = (int) Math.rint(Math.random() * 10);

        System.out.println("Seed generated "+ seed);

        resultCommunicator.complete(seed);

    }
}
