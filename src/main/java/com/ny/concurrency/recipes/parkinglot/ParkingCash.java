package com.ny.concurrency.recipes.parkinglot;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingCash {

    private static final int cost = 2;
    private AtomicLong cash;

    public ParkingCash() {
        cash = new AtomicLong(0);
    }

    public void vehiclePay() {
        cash.addAndGet(cost);
    }

    public void close() {
        System.out.print("Closing accounting");
        long totalAmount;
        totalAmount = cash.get();
        cash = new AtomicLong(0);
        System.out.printf("The total amount is : %d", totalAmount);
    }

}
