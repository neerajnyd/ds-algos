package com.ny.leetcode.comp;

public class MaxPointsInA_Circle {

    public int numPoints(int[][] points, int r) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (d2(points[i], points[j]) > 4 * r * r) continue;
                if (d2(points[i], points[j]) == 0) continue;
                double theta = Math.acos(Math.sqrt(d2(points[i], points[j])) / (2 * r));
                double base = Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]);
                for (int u : new int[]{-1, 1}) {
                    double cx = points[i][0] + r * Math.cos(base + u * theta);
                    double cy = points[i][1] + r * Math.sin(base + u * theta);
                    int ct = 0;
                    for (int[] point : points) {
                        if ((cx - point[0]) * (cx - point[0]) + (cy - point[1]) * (cy - point[1])
                                        <
                                r * r + 1e-7)
                            ct++;
                    }
                    ans = Math.max(ans, ct);
                }
            }
        }
        return ans;
    }

    long d2(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

}
