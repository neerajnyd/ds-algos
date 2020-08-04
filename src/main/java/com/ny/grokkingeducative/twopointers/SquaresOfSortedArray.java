package com.ny.grokkingeducative.twopointers;

import java.util.Arrays;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
//        System.out.println(pointerToSmallestNegativeNumber(nums));
        System.out.println(
                Arrays.toString(sortedSquares(
                        nums
                ))
        );
    }

    /*
    another solution can be to have the pointers point to the start and end of the array
    then start appending the bigger square from front or back to the end of the result list
     */
    private static int[] sortedSquares(int[] A) {
        int i = pointerToSmallestNegativeNumber(A);
        int j = i+1; //pointer to the first non-negative number
        int[] B = new int[A.length];
        int k = 0;
        while (k < A.length) {
            if(i < 0) {
                B[k] = A[j] * A[j];
                j++;
            } else if(j == A.length) {
                B[k] = A[i] * A[i];
                i--;
            } else {
                int a = A[i]*-1;
                int b = A[j];
                if(a <= b) {
                    B[k] = a*a;
                    i--;
                } else {
                    B[k] = b*b;
                    j++;
                }
            }
            k++;
        }
        return B;

    }

    private static int pointerToSmallestNegativeNumber(int[] A) {
        /* maintain a candidate which might get updated multiple
            times by the binary search loop */
        int candidate = -1;
        if(A[0] >= 0) return candidate;
        int lo = 0, hi = A.length-1;
        while(lo <= hi) {
            int mid = lo + ((hi-lo)/2);
            //negative number, which we want so update candidate
            if(A[mid] < 0) {
                candidate = mid;
        //search in higher half in search of smallest negative candidate
                lo = mid+1;
            } else {//positive number, which we don't want so no update to candidate
                hi = mid-1;//
            }
        }
        return candidate;
    }

}
