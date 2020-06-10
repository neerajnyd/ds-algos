package com.ny.leetcode.may2020;

import java.util.*;

public class Day30_KClosestPointsToOrigin {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(
                new int[][]
                {
                        {0, 1}, {1, 0}
                }, 2
        )));
    }

    public static int[][] kClosest(int[][] points, int K) {

        int len = points.length;
        int left = 0;
        int right = len - 1;

        while(left <= right){
            int partitionIndex = partition(points,left,right);
            if(partitionIndex == K){
                break;
            }
            if(partitionIndex < K){
                left = partitionIndex + 1;
            }else{
                right = partitionIndex - 1;
            }
        }

        return Arrays.copyOfRange(points,0,K);
    }

    public static int partition(int[][] points,int left,int right){
        int[] pivot = points[left];

        while(left < right){
            while(left < right && compare(points[right],pivot) <= 0) right--;
            points[left] = points[right];
            while(left < right && compare(points[left],pivot) >= 0) left++;
            points[right] = points[left];
        }
        points[left] = pivot;

        return left;
    }

    public static int compare(int[] point1,int[] point2){
        return (point2[1] * point2[1] + point2[0] * point2[0]) - point1[1] * point1[1] - point1[0] * point1[0];
    }

    public static int[][] kClosest_AcceptedButSlow(int[][] points, int k) {
        List<int[]> R = new ArrayList<>();
        long[] distances = new long[points.length];
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Map<Long, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < distances.length; i++) {
            int[] point = points[i];
            long aDistance = euclideanDistance_AcceptedButSlow(points[i][0], points[i][1]);
            distances[i] = aDistance;
            List<int[]> valueList = map.getOrDefault(aDistance, new ArrayList<>());
            valueList.add(point);
            map.put(distances[i], valueList);
            minHeap.add(distances[i]);
        }
        for (int i = 0; i < k;) {
            Long minDist = minHeap.poll();
            List<int[]> valueList = map.get(minDist);
            for (int j = 0; j < valueList.size() && i < k; j++) {
                R.add(valueList.get(j));
                i++;
            }
        }
        return R.toArray(new int[R.size()][]);
    }

    private static long euclideanDistance_AcceptedButSlow(int x, int y) {
        return ((long)x*x) + ((long)y*y);
    }

}
