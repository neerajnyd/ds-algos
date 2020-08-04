package com.ny.concurrency.recipes.parkinglot;

public class ParkingStats {

    private volatile long numberCars;
    private volatile long numberMotorcycles;
    private ParkingCash cash;
    private final Object carsLock = new Object();
    private final Object motoLock = new Object();

    public ParkingStats(ParkingCash cash) {
        numberCars = 0;
        numberMotorcycles = 0;
        this.cash = cash;
    }
    public void carComeIn() {
        synchronized (carsLock) {
            numberCars++;
        }
    }
    public void carGoOut() {
        synchronized (carsLock) {
            numberCars--;
        }
        cash.vehiclePay();
    }

    public void motoComeIn() {
        synchronized (motoLock) {
            numberMotorcycles++;
        }
    }
    public void motoGoOut() {
        synchronized (motoLock) {
            numberMotorcycles--;
        }
        cash.vehiclePay();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }
}
