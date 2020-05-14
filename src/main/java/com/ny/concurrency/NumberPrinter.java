package com.ny.concurrency;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinter {

    public static void main(String[] args) {
        final int n = 6;
        final Lock lock = new ReentrantLock();
        final int[] count = {1};
        final Set<Thread> threads = new HashSet<>();
        final CyclicBarrier barrier = new CyclicBarrier(n);
        for (int i = 1; i <= n; i++) {
            final int[] iCount = {i};
            final Condition condition = lock.newCondition();
            final String threadName = "Thread " + i;
            final Thread thread = new Thread(() -> {
                awaitOnBarrier(barrier);
                sleepThread();
                lock.lock();
                while (count[0] != iCount[0]) awaitOnCondition(condition);
                System.out.print(Thread.currentThread().getName()
                        + " increasing the count from " + count[0] + " to ");
                count[0]++;
                System.out.print(count[0]);
                System.out.println();
                condition.signalAll();
                lock.unlock();
            }, threadName);
            System.out.println("Adding thread " + threadName + " to set");
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.start();
        }
    }

    private static void sleepThread()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void awaitOnBarrier(CyclicBarrier barrier) {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private static void awaitOnCondition(Condition condition)  {
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
