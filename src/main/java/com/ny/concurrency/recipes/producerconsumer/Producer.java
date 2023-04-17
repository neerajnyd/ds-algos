package com.ny.concurrency.recipes.producerconsumer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

    private final ConcurrentQueue<Integer> queue;

    public Producer(ConcurrentQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int nextInt = ThreadLocalRandom.current().nextInt(1, 101);
            System.out.printf("Produced %d in %s. Queue size is %d \n", nextInt, Thread.currentThread().getName(), queue.size());
            queue.set(nextInt);
            sleeep();
        }
    }

    private static void sleeep() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
