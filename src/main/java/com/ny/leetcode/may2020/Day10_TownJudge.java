package com.ny.leetcode.may2020;

/*
https://leetcode.com/problems/find-the-town-judge/
 */
public class Day10_TownJudge {

    public int findJudge_better(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for (int[] t : trust) {
            int trusts = t[0];
            count[trusts]--;
            int trusted = t[1];
            count[trusted]++;
        }
        for (int i = 1; i <= N; ++i)
            if (count[i] == N - 1)
                return i;

        return -1;
    }

    public int findJudge(int N, int[][] trust) {

        int[][] A = new int[N][2]; //outgoing, incoming

        for (int[] eachTrust : trust) {

            int trusts = eachTrust[0]; //outgoing
            int trusted = eachTrust[1]; //incoming

            A[trusts - 1][0] = A[trusts - 1][0] + 1;
            A[trusted - 1][1] = A[trusted - 1][1] + 1;

        }

        for (int i = 0; i < A.length; i++) {
            int[] a = A[i];
            if (a[0] == 0 && a[1] == N - 1) return i + 1;
        }
        return -1;
    }
}
