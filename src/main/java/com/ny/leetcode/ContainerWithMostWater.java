package com.ny.leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] H = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(H));
    }

    private static int maxArea(int[] H) {
        int l = 0, r = H.length-1;
        int maxArea = 0;
        while(l < r) {
            int b = r - l;
            int h = Math.min(H[l], H[r]);
            int area = b * h;
            maxArea = Math.max(maxArea, area);
            if(H[l] > H[r]) r--;
            else l++;
        }
        return maxArea;
    }

}
