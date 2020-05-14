package com.ny.concurrency;

import java.util.concurrent.Semaphore;

public class H2O {

    private Semaphore hP = new Semaphore(2, true);
    private Semaphore oP = new Semaphore(0, true);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hP.acquire();
        releaseHydrogen.run();
        oP.release();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oP.acquire(2);
        releaseOxygen.run();
        hP.release(2);
    }
}