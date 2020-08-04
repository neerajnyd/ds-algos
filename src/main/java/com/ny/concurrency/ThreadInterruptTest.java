package com.ny.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings("ALL")
public class ThreadInterruptTest {

    public static void main(String[] args) {
        Task task = new Task(new AtomicBoolean(Boolean.FALSE));
        new Thread(task).start();
        Executors.newScheduledThreadPool(1)
                .schedule(() -> task.getStop().set(Boolean.TRUE), 3, TimeUnit.SECONDS);
    }

    private static class Task implements Runnable {

        private AtomicBoolean stop; //or a volatile boolean

        private Task(AtomicBoolean stop) {
            this.stop = stop;
        }

        public AtomicBoolean getStop() {
            return stop;
        }

        @Override
        public void run() {
            int i = 1;
            while (!stop.get()) {
                System.out.println("I'mma run for my life " + i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
            System.out.println("I'mma stop now");
        }
    }
}