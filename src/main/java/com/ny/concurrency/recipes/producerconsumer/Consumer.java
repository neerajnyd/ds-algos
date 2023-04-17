package com.ny.concurrency.recipes.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

    private final ConcurrentQueue<Integer> queue;

    public Consumer(ConcurrentQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Integer nextInt = queue.get();
            System.out.printf("Consumed %d in %s. Queue size is %d \n", nextInt, Thread.currentThread().getName(), queue.size());
            sleeep();
        }
    }

    private static void sleeep() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
