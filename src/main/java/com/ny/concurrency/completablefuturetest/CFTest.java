package com.ny.concurrency.completablefuturetest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CFTest {

    public static void main(String[] args) {

        System.out.println("Main - Start");
        int seed = getSeed();
        System.out.println("Main — the seed is: " + seed);

        System.out.println("Launching the list of numbers generator");

        NumberListGenerator numberListGenerator = new NumberListGenerator(seed);
        CompletableFuture<List<Long>> startFuture = CompletableFuture.supplyAsync(numberListGenerator);

        System.out.println("Launching Step 1");

        CompletableFuture<Long> stepOneFuture = startFuture.thenApplyAsync(longs -> {
            System.out.println("Step 1 Start in Thread: " + Thread.currentThread().getName());
            long selected = 0;
            long selectedDistance = Long.MAX_VALUE;
            long distance;
            for(Long num : longs) {
                distance = Math.abs(num-1000);
                if(distance < selectedDistance) {
                    selected = num;
                    selectedDistance = distance;
                }
            }
            System.out.println("Step 1 result: " + selected);
            return selected;
        });

        System.out.println("MAIN - Launching Step 2");

        CompletableFuture<Long> stepTwoFuture = startFuture.thenApplyAsync(list -> list.stream().max(Long::compare).get());

        CompletableFuture<Void> stepTwoWrite = stepTwoFuture.thenAccept(val ->
                System.out.printf("%s: Step 2 Result - %d", Thread.currentThread().getName(), val)
        );

        System.out.print("Launching Step 3\n");

        NumberSelector numberSelector = new NumberSelector();
        CompletableFuture<Long> stepThreeFuture = startFuture.thenApplyAsync(numberSelector);

        System.out.println("Waiting for the end of the three steps");

        CompletableFuture<Void> waitFuture = CompletableFuture.allOf(stepOneFuture, stepTwoWrite, stepThreeFuture);

        CompletableFuture<Void> finalFuture = waitFuture.thenAcceptAsync(aVoid -> System.out.println("All steps have completed"));

        finalFuture.join();
    }

    public static int getSeed() {
        CompletableFuture<Integer> seedFuture = new CompletableFuture<>();
        Thread seedThread = new Thread(new SeedGenerator(seedFuture));
        seedThread.start();
        System.out.println("Getting the seed in MAIN");

        int seed = 0;
        try {
            seed = seedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return seed;
    }
}
