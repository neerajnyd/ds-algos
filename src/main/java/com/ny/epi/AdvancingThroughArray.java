package com.ny.epi;

import java.util.List;

import static sun.swing.MenuItemLayoutHelper.max;

public class AdvancingThroughArray {

    public static boolean canReachEnd(List<Integer> A) {

        int lastReachableIndex = 0, lastIndex = A.size()-1;

        for(int i=0; i<=lastReachableIndex && lastReachableIndex < lastIndex; ++i) {
            lastReachableIndex = max(lastReachableIndex, i + A.get(i));
        }

        return lastReachableIndex >= lastIndex;

    }
}
