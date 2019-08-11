package com.ny.epi;

import java.util.Collections;
import java.util.List;

public class DutchFlagPartioning {

    public static void main(String[] args) {
        
    }

    public enum Color {
        RED, WHITE, BLUE
    }

    /*
    O(1) space and O(n square) time
     */
    public static void twoPassSolution(int pivotIndex, List<Color> A) {
        final Color pivot = A.get(pivotIndex);
        // First pass: group elements smaller than pivot.
        for(int i=0; i<A.size(); i++) {
            // Look for a smaller element.
            for(int j=i+1; j<A.size(); j++) {
                if(A.get(j).ordinal() < pivot.ordinal()) {
                    Collections.swap(A, i, j);
                    break;
                }
            }
        }

        // Second pass: group elements larger than pivot.
        for(int i=A.size()-1; i>=0 && A.get(i).ordinal() >= pivot.ordinal(); i--) {
            /* Look for a larger element. Stop when we reach an element less
              than pivot, since first pass has moved them to the start of A.*/
            for(int j=i-1; j >=0 && A.get(j).ordinal() >= pivot.ordinal(); j--) {
                if(A.get(j).ordinal() > pivot.ordinal()) {
                    Collections.swap(A, i, j);
                    break;
                }
            }
        }
    }

    /*
    O(1) space and O(n) time
     */
    public static void singlePassSolution(int pivotIndex, List<Color> A) {
        final Color pivot = A.get(pivotIndex);
        // First pass: group elements smaller than pivot.
        int smaller = 0;
        for(int i=0; i<A.size(); ++i) {
            if(A.get(i).ordinal() < pivot.ordinal()) {
                Collections.swap(A, smaller, i);
                smaller++;
            }
        }
        // Second pass: group elements larger than pivot.
        int larger = A.size()-1;
        for(int i=A.size()-1; i>=0 && A.get(i).ordinal() >= pivot.ordinal(); --i) {
            if(A.get(i).ordinal() > pivot.ordinal()) {
                Collections.swap(A, larger, i);
                larger--;
            }
        }

    }

    /*
    O(1) space and O(n) time
     */
    public static void singlePassBetterSolution(int pivotIndex, List<Color> A) {

    }

}
