package com.ny;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestClass {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= t; i++) {
            System.out.println("Case " + i + ":");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String balls = st.nextToken();
            char[] ch = balls.toCharArray();
            int striker = 0, nonStriker = 1, wickets = 0;
            long[] scores = new long[p];
            for (int j = 1; j <= ch.length; j++) {
                switch (ch[j - 1]) {
                    case '0':
                        break;
                    case '1':
                        scores[striker] += 1;
                        int temp = striker;
                        striker = nonStriker;
                        nonStriker = temp;
                        break;
                    case '2':
                        scores[striker] += 2;
                        break;
                    case '4':
                        scores[striker] += 4;
                        break;
                    case '6':
                        scores[striker] += 6;
                        break;
                    case 'W':
                        wickets++;
                        striker = wickets + 1;
                        break;
                }
                if (j % 6 == 0) {
                    int temp = striker;
                    striker = nonStriker;
                    nonStriker = temp;
                }
            }
            for (int l = 0; l <= wickets + 1; l++) {
                System.out.print("Player " + (l + 1) + ": " + scores[l]);
                if (l == nonStriker || l == striker)
                    System.out.print("*");
                System.out.println();
            }
            for (int m = wickets + 2; m < p; m++)
                System.out.println("Player " + (m + 1) + ": DNB");
        }
    }
}
