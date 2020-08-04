package com.ny.concurrency.recipes.producerconsumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {

    private int maxSize;
    private Queue<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void set(Date date) {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.offer(date);
        System.out.printf("Set: %d", storage.size());
        notify();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String element = storage.poll().toString();
        System.out.printf("Get: %d: %s\n", storage.size(), element);
        notify();
    }
}
