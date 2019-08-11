package com.ny.concurrency;

import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierTest {

    public static void main(String[] args) {

        final ExecutorService service = Executors.newFixedThreadPool(4);
        final CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("OPEN THE GATES!"));
        final List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Friend friend = new Friend(barrier);
            final Future<String> future = service.submit(friend);
            futures.add(future);
        }

        for (Future<String> future : futures) {
            try {
                final String result = future.get();
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("No result? due to excption " + e.getMessage());
            }

        }
        service.shutdown();

    }

    static class Friend implements Callable<String> {

        private final CyclicBarrier barrier;

        Friend(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public String call() {

            try {

                Thread.sleep(new Random().nextInt(20) * 100 + 100);
                System.out.println("I have arrived. Let's wait for the others!");

                barrier.await(2, TimeUnit.SECONDS);

                System.out.println("Let's go!!!");

                return "OK!";

            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
                return "Not OK!";
            }
        }
    }


}
