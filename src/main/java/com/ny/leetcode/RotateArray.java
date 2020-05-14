package com.ny.leetcode;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotateByReverse(nums, 3);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static int[] rotateByReverse(int[] A, int k) {
        final int n = A.length;
        k %= n;
        reverse(A, 0, n-1);
        reverse(A, 0, k-1);
        reverse(A, k, n-1);

        return new int[]{};
    }

    private static void reverse(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    private static void rotate(int[] A, int k) {
        final int n = A.length;
        k %= n;
        int count = 0;
        for (int startIndex = 0; count < n; startIndex++) {
            int prevValue = A[startIndex];
            int currIndex = startIndex;
            do {
                final int nextIndex = (currIndex + k) % n;
                final int tempValue = A[nextIndex];
                A[nextIndex] = prevValue;
                prevValue = tempValue;
                currIndex = nextIndex;
                count++;
            } while (startIndex != currIndex);
        }
    }

    private static void rotateByBruteForce(int[] A, int k) {
        int n = A.length;
        for (int i = 0; i < k; i++) {
            int prev = A[n-1];
            for (int j = 0; j < n; j++) {
                int temp = A[j];
                A[j] = prev;
                prev = temp;
            }
        }
    }

}
