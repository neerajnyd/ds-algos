package com.ny.gfg.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Array_01_ConsecutiveSubarrayWithGivenSum {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(new File("C:\\Users\\NY\\Desktop\\tc.txt"));
//      Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int S = in.nextInt();
            process(in, N, S);
        }
        in.close();
    }

    private static void process(Scanner in, int size, int target) {
        int[] A = new int[size];
        for (int i = 0; i < size; i++) {
            A[i] = in.nextInt();
        }
        boolean notFound = true;
        int rollingSum = 0;
        int j = 0;
        for (int i = 0; i < size; i++) {
            rollingSum += A[i];
            while (rollingSum > target) rollingSum -= A[j++];
            if (rollingSum == target) {
                notFound = false;
                System.out.println((j + 1) + " " + (i + 1));
                break;
            }

        }
        if (notFound) {
            System.out.println("-1");
        }
    }
}
