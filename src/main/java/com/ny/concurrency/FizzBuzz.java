package com.ny.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class FizzBuzz {

    public static void main(String[] args) throws Exception {

        final Integer[] N = {1};
        final Lock lock = new ReentrantLock();
        final Condition fizz = lock.newCondition(); //condition for divisibility by 3 but not 5
        final Predicate<Integer> fizzCondition = i -> i % 3 == 0 && i % 5 != 0;
        final Condition buzz = lock.newCondition(); //condition for divisibility by 5 but not 4
        final Predicate<Integer> buzzCondition = i -> i % 5 == 0 && i % 3 != 0;
        final Condition fizzBuzz = lock.newCondition(); //condition for divisibility by 3 AND 5
        final Predicate<Integer> fizzBuzzCondition = i -> i % 5 == 0 && i % 3 == 0;
        final Condition number = lock.newCondition();
        final Predicate<Integer> divisibleByAny = i -> i % 5 == 0 || i % 3 == 0;
        final CyclicBarrier barrier = new CyclicBarrier(4);

        Runnable r1 = () -> {
            awaitOnBarrier(barrier);
            while (true) {
                lock.lock();
                while (!fizzCondition.test(N[0])) {
                    awaitCondition(fizz);
                }
                System.out.println(N[0] + " Fizz");
                N[0] = N[0] + 1;
                sleep();
                signalOthers(number, buzz, fizzBuzz);
                lock.unlock();
            }
        };

        Runnable r2 = () -> {
            awaitOnBarrier(barrier);
            while (true) {
                lock.lock();
                while (!buzzCondition.test(N[0])) {
                    awaitCondition(buzz);
                }
                System.out.println(N[0] + " Buzz");
                N[0] = N[0] + 1;
                sleep();
                signalOthers(number, fizz, fizzBuzz);
                lock.unlock();
            }
        };

        Runnable r3 = () -> {
            awaitOnBarrier(barrier);
            while (true) {
                lock.lock();
                while (!fizzBuzzCondition.test(N[0])) {
                    awaitCondition(fizzBuzz);
                }
                System.out.println(N[0] + " FizzBuzz");
                N[0] = N[0] + 1;
                sleep();
                signalOthers(fizz, buzz, number);
                lock.unlock();
            }
        };

        Runnable r4 = () -> {
            awaitOnBarrier(barrier);
            while (true) {
                lock.lock();
                while (divisibleByAny.test(N[0]))
                    awaitCondition(number);
                System.out.println(N[0]);
                sleep();
                N[0] = N[0] + 1;
                signalOthers(fizz, buzz, fizzBuzz);
                lock.unlock();
            }
        };

        threadStartAndJoin(r1, r2, r3, r4);
    }

    public static void signalOthers(Condition fizz, Condition buzz, Condition number) {
        fizz.signal();
        buzz.signal();
        number.signal();
    }

    private static void threadStartAndJoin(Runnable r1, Runnable r2, Runnable r3, Runnable r4) throws InterruptedException {
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

    private static void sleep() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void awaitCondition(Condition fizz) {
        try {
            fizz.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void awaitOnBarrier(CyclicBarrier barrier) {
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
