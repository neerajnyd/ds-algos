package com.ny.concurrency;

import java.util.concurrent.Semaphore;

public class ControlMethodCallOrder {

    private Semaphore runTwo;
    private Semaphore runThree;

    public ControlMethodCallOrder() {
        runTwo = new Semaphore(0);
        runThree = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        runTwo.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        runTwo.acquire();
        printSecond.run();
        runThree.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        runThree.acquire();
        printThird.run();
    }
}