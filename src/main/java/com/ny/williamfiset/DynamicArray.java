package com.ny.williamfiset;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0; //length user things array is
    private int capacity; //actual capacity of the array

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity " + capacity);
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T element) {
        arr[index] = element;
    }

    public void clear() {
        for (int i = 0; i < len; i++) arr[i] = null;
        len = 0;
    }

    public void add(T element) {
        if (len >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity = capacity * 2;
            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) newArr[i] = arr[i];
            arr = newArr;
        }
        arr[len++] = element;
    }

    //also decreases capcaity to len-1 since add adds capacity
    public T removeAt(int index) {
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();
        T removed = arr[index];

        T[] newArr = (T[]) new Object[len - 1];

        for (int i = 0, j = 0; i < len; i++, j++) {
            /*if(i==index) i++;
            newArr[j] = arr[i];*/
            if (i == index) j--; //essentially skipping the element at i
            else newArr[j] = arr[i];
        }
        arr = newArr;
        capacity = --len; //decrement length AND shorten capacity to what is available in arr
        return removed;
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) return false;
        removeAt(indexOf);
        return true;
    }

    private int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (obj == null) {
                if (arr[i] == null) {
                    return i;
                }
            } else {
                if (obj.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }

            @Override
            public void remove() {
//                removeAt(0);
                throw new UnsupportedOperationException("Use removeAt or remove methods for removing from the array");
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        return Arrays.stream(arr)
                .map(Objects::toString)
                .collect(Collectors.joining(", ", "[", "]"));

    }
}
