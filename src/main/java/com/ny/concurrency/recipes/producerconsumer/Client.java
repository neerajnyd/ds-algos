package com.ny.concurrency.recipes.producerconsumer;

public class Client {

    public static void main(String[] args) {

        ConcurrentQueue<Integer> queue = new ConcurrentQueue<>(10);

        Producer p1 = new Producer(queue);
        Thread tp1 = new Thread(p1, "Producer 1");
        Producer p2 = new Producer(queue);
        Thread tp2 = new Thread(p2, "Producer 2");

//        Producer p3 = new Producer(queue);
//        Thread tp3 = new Thread(p3, "Producer 3");
//        Producer p4 = new Producer(queue);
//        Thread tp4 = new Thread(p4, "Producer 4");

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);
        Consumer c4 = new Consumer(queue);
        Thread cp1 = new Thread(c1, "Consumer 1");
        Thread cp2 = new Thread(c2, "Consumer 2");
        Thread cp3 = new Thread(c3, "Consumer 3");
        Thread cp4 = new Thread(c4, "Consumer 4");

        tp1.start();
        tp2.start();
//        tp3.start();
//        tp4.start();

        cp1.start();
        cp2.start();
        cp3.start();
        cp4.start();
    }

}
