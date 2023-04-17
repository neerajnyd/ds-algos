package com.ny.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private final int n;
    private final Semaphore zeroPermit = new Semaphore(1);
    private final Semaphore oddPermit = new Semaphore(0);
    private final Semaphore evenPermit = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroPermit.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                evenPermit.release();
            } else {
                oddPermit.release();
            }
        }
    }
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenPermit.acquire();
            printNumber.accept(i);
            zeroPermit.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n ; i += 2) {
            oddPermit.acquire();
            printNumber.accept(i);
            zeroPermit.release();
        }
    }

    public static void main(String[] args) throws Exception {
        ZeroEvenOdd zEO = new ZeroEvenOdd(3);

        Thread t1 = new Thread(() -> {
            try {
                zEO.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zEO.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zEO.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();


    }
}