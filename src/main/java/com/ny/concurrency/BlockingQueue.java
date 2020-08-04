package com.ny.concurrency;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BlockingQueue<E> {

    private final int size;
    private final Queue<E> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public BlockingQueue(int size) {
        this.size = size;
    }

    public static List<Thread> getThreadsForTask(Runnable runnable) {
        return IntStream.range(0, 3).mapToObj(i -> new Thread(runnable)).collect(Collectors.toList());
    }

    public void add(E e) throws Exception {
        lock.lock();
        try {
            while (size == queue.size()) {
                System.out.println("Queue full. Cannot add to it.");
                notFull.await();
            }
            queue.add(e);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public E remove() throws Exception {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Queue empty. Cannot consume from it.");
                notEmpty.await();
            }
            E element = queue.remove();
            notFull.signalAll();
            return element;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws Exception {

        BlockingQueue<Integer> queue = new BlockingQueue<>(1000);
        Runnable producer = () -> {
            while (true) {
                int randomNumber = ThreadLocalRandom.current().nextInt(100);
                int waitNumber = ThreadLocalRandom.current().nextInt(1000, 3000);
                try {
                    queue.add(randomNumber);
                    System.out.println("Added " + randomNumber + " to the queue");
                    Thread.sleep(waitNumber);
                } catch (Exception e) {
                    System.out.println("Failed to add random number");
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                int waitNumber = ThreadLocalRandom.current().nextInt(1000, 3000);
                try {
                    Integer random = queue.remove();
                    System.out.println("Received " + random + " from the queue");
                    Thread.sleep(waitNumber);
                } catch (Exception e) {
                    System.out.println("Failed to get random number");
                }
            }
        };

        List<Thread> producers = getThreadsForTask(producer);
        List<Thread> consumers = getThreadsForTask(consumer);


        Stream.of(producers, consumers).flatMap(Collection::stream).forEach(Thread::start);


        Thread.sleep(100000);

    }
}
