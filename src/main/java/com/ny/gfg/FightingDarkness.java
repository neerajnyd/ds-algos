package com.ny.gfg;

import java.io.File;
import java.util.Scanner;

public class FightingDarkness {

    public static void main(String[] args) throws Exception {
//        Scanner in = new Scanner(new File("C:\\Users\\NY\\Desktop\\tc.txt"));
        Scanner in = new Scanner(System.in);
        final long cases = in.nextLong();
        for (long i = 0; i < cases; i++) {
            long max = 0;
            final long candles = in.nextLong();
            for(long c = 0; c <candles; c++) {
                final long eachCandle = in.nextLong();
                if(eachCandle > max) {
                    max = eachCandle;
                }
            }
            System.out.println(max);
        }
        in.close();
    }

}
