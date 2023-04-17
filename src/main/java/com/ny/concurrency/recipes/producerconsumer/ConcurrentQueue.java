package com.ny.concurrency.recipes.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ConcurrentQueue<T> {

    private final int maxSize;
    private final Queue<T> queue;

    public ConcurrentQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new LinkedList<>();
    }

    public synchronized void set(T element) {
        while (queue.size() == maxSize) waait();

        queue.offer(element);
        notify();
    }

    public T get() {
        T result;
        synchronized (this) {
            while (queue.size() == 0) waait();

            result = queue.poll();
            notify();
        }
        return result;
    }

    public int size() {
        return queue.size();
    }

    private void waait() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
