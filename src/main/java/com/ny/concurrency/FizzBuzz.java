package com.ny.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private Lock lock;
    private Condition numCondition;
    private Condition fizzCondition;
    private Condition buzzCondition;
    private Condition fizzBuzzCondition;
    private int i;

    public FizzBuzz(int n) {
        this.n = n;
        i = 1;
        lock = new ReentrantLock();
        numCondition = lock.newCondition();
        fizzCondition = lock.newCondition();
        buzzCondition = lock.newCondition();
        fizzBuzzCondition = lock.newCondition();
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        while (i <= this.n) {
            if (i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
                i += 1;
                fizzBuzzCondition.signal();
                buzzCondition.signal();
                numCondition.signal();
            } else {
                fizzCondition.await();
            }
        }
        lock.unlock();
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        while (i <= this.n) {
            if (i % 5 == 0 && i % 3 != 0) {
                printBuzz.run();
                i += 1;
                fizzBuzzCondition.signal();
                fizzCondition.signal();
                numCondition.signal();
            } else {
                buzzCondition.await();
            }
        }
        lock.unlock();
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        while (i <= this.n) {
            if (i % 15 == 0) {
                printFizzBuzz.run();
                i += 1;
                numCondition.signal();
                fizzCondition.signal();
                buzzCondition.signal();
            } else {
                fizzBuzzCondition.await();
            }
        }
        lock.unlock();
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (i <= this.n) {
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                i += 1;
                fizzBuzzCondition.signal();
                fizzCondition.signal();
                buzzCondition.signal();
            } else {
                numCondition.await();
            }
        }
        lock.unlock();
    }

    public static void main(String[] args) throws Exception {

        IntConsumer iC              = value -> System.out.print(value + ", ");
        Runnable    fizzPrinter     = () -> System.out.print("fizz, ");
        Runnable    buzzPrinter     = () -> System.out.print("buzz, ");
        Runnable    fizzBuzzPrinter = () -> System.out.print("fizzbuzz, ");
        FizzBuzz    runner          = new FizzBuzz(25);

        Thread t1 = new Thread(() -> {
            try {
                runner.number(iC);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                runner.fizz(fizzPrinter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                runner.buzz(buzzPrinter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                runner.fizzbuzz(fizzBuzzPrinter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }
}