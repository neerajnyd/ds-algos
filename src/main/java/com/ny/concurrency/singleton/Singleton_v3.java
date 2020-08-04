package com.ny.concurrency.singleton;

public class Singleton_v3 {

    private static volatile Singleton_v3 INSTANCE;

    private static final Object LOCK = new Object();

    private Singleton_v3() {}

    public static Singleton_v3 getInstance() {
        if(INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (LOCK) {
            if(INSTANCE == null) {
                INSTANCE = new Singleton_v3();
            }
            return INSTANCE;
        }
    }
}
