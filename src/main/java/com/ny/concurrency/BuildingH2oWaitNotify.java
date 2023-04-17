package com.ny.concurrency;

public class BuildingH2oWaitNotify {

    private int h = 0, o = 0;

    private boolean water() {
        return h == 2 && o == 1;
    }

    private void resetWater() {
        h = 0;
        o = 0;
    }

    public synchronized void hydrogen(Runnable releaseHydrogen) {
        while (h >= 2) {
            waitt();
        }
        releaseHydrogen.run();
        h++;
        if (water()) {
            resetWater();
        }
        notify();
    }

    public synchronized void oxygen(Runnable releaseOxygen) {
        while (o >= 1) {
            waitt();
        }
        releaseOxygen.run();
        o++;
        if (water()) {
            resetWater();
        }
        notify();

    }

    private void waitt() { try { wait(); } catch (Exception ignored) {}}
    private static void sleep(long millis) { try { Thread.sleep(millis); } catch (Exception ignored) {}}

    // client
    public static void main(String[] args) throws Exception {

        BuildingH2oWaitNotify obj = new BuildingH2oWaitNotify();

        Runnable printH = () -> System.out.print("H");
        Runnable printO = () -> System.out.print("O");

        Thread hPrinter = new Thread(() -> {
            while (true) {
                obj.hydrogen(printH);
                sleep(500);
            }
        });
        Thread oPrinter = new Thread(() -> {
            while (true) {
                obj.oxygen(printO);
                sleep(600);
            }
        });

        hPrinter.start();
        oPrinter.start();

        hPrinter.join();
        oPrinter.join();

    }

}
