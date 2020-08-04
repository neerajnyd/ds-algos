package com.ny.concurrency.singleton;

public class Singleton_v1 {

    private static Singleton_v1 INSTANCE;

    private Singleton_v1() {}

    public static synchronized Singleton_v1 getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Singleton_v1();
        }
        return INSTANCE;
    }
}
