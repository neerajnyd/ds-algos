package com.ny.concurrency.singleton;

public class Singleton_v2 {

    private static Singleton_v2 INSTANCE;

    private static final Object LOCK = new Object();

    private Singleton_v2() {
        if(INSTANCE != null) {
            throw new IllegalStateException("Use getInstance() method to create");
        }
    }

    public static Singleton_v2 getInstance() {
        if(INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (LOCK) {
            if(INSTANCE == null) {
                INSTANCE = new Singleton_v2();
            }
            return INSTANCE;
        }
    }
}
