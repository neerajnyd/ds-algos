package com.ny.leetcode;

public class SortArrayByParity {

    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,5};
        sortArrayByParity(A);
        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    private static void sortArrayByParity(int[] A) {
        int i = 0, j = A.length-1;
        while(i < j) {
            if(A[i]%2==0)
                i++;
            else {
                int temp = A[i];
                A[i] = A[j];
                A[j--] = temp;
            }
        }
    }

}
