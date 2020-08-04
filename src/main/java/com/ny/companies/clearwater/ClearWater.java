package com.ny.companies.clearwater;

import java.util.*;

public class ClearWater {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(-5);
        arr.add(6);
		int i = splitIntoTwo(arr);
		System.out.println(i);
	}

    // Question : Merge the given 2 arrays into one
    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        int m = a.size();
        int n = b.size();
        if(m==0) return b;
        if(n==0) return a;
        List<Integer> c = new ArrayList<>(m + n);
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i < m && j < n && a.get(i) < b.get(j))
                c.add(a.get(i++));
            else if (i < m && j < n && a.get(i).equals(b.get(j))) {
                c.add(a.get(i++));
                c.add(b.get(j++));
            }
            else if (i < m && j < n && a.get(i) > b.get(j))
                c.add(b.get(j++));
            else if (i < m && j == n)
                c.add(a.get(i++));
            else if (i == m/* && j < n*/)
                c.add(b.get(j++));
        }
        return c;
    }

    // Question : Find if the given list of numbers has duplicate
    public static boolean containsDuplicate(List<Integer> numbers) {
		Set<Integer> set = new HashSet<>();
		for (Integer number : numbers)
            if (!set.add(number))
                return true;
        return false;
    }

    // Question : Split the given list of integers into 2, such that sum of left partition elements
    // is greater than that of right partition.
    public static int splitIntoTwo(List<Integer> arr) {
        int count = 0;
        int lTotal = 0;
        int rTotal = 0;
        int len = arr.size();
        if (len == 0)
            return 0;
        lTotal = arr.get(0);
        for (int i = 1; i < len; i++) rTotal += arr.get(i);
        if (lTotal > rTotal)
            count++;
        for (int i = 1; i < len - 1; i++) {
            lTotal += arr.get(i);
            rTotal -= arr.get(i);
            if (lTotal > rTotal)
                count++;
        }
        return count;
    }

}

// Question : Task was to implement below classes to provide the area
class Circle {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public int getArea() {
        double area = (float) 3.14159265 * radius * radius;
        return (int) Math.ceil(area);
    }
}

class Rectangle {
    private float height;
    private float width;

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public int getArea() {
        double area = (float) height * width;
        return (int) Math.ceil(area);
    }
}

class Square {
    private float width;

    public Square(float width) {
        this.width = width;
    }

    public int getArea() {
        double area = (float) width * width;
        return (int) Math.ceil(area);
    }
}