package com.ny.concurrency;

import java.util.concurrent.Semaphore;

public class BuildingH2O {

    private final Semaphore hydrogen = new Semaphore(2, true);
    private final Semaphore oxygen = new Semaphore(0, true);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();

        //--------------------------//
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        //--------------------------//

        //release 1 permit from each hydrogen thread. when 2 are created, one oxygen thread can run.
        oxygen.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        //require 2 permits to run so only 1 oxygen runs when 2 hydrogen threads release a permit each
        oxygen.acquire(2);

        //--------------------------//
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        //--------------------------//

        //release 2 so that 2 hydrogen threads can run
        hydrogen.release(2);
    }

}
