package com.ny.concurrency;

import java.util.concurrent.Semaphore;

/*
https://leetcode.com/problems/print-foobar-alternately/submissions/
 */
public class FooBar {
    private int n;
    private Semaphore oddPermit;
    private Semaphore evenPermit;

    public FooBar(int n) {
        this.n = n;
        oddPermit = new Semaphore(0);
        evenPermit = new Semaphore(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            evenPermit.acquire();
            printFoo.run();
            oddPermit.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            oddPermit.acquire();
            printBar.run();
            evenPermit.release();
        }
    }

    public static void main(String[] args) throws Exception {
        FooBar   fb     = new FooBar(3);
        Runnable fooRun = () -> System.out.print("foo");
        Runnable barRun = () -> System.out.print("bar");

        Runnable fbUser1 = () -> {
            try {
                fb.foo(fooRun);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable fbUser2 = () -> {
            try {
                fb.bar(barRun);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(fbUser1);
        Thread t2 = new Thread(fbUser2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }
}
