package com.tanpham.playaround;

public class MyVector<E extends Object> {
    private static final int DEFAULT_CAPACITY = 10;
    private E arr[];
    private int capacity;
    private int size;
    private int currentIndex;
    
    public MyVector() {
        arr = (E[]) new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        size = 0;
        currentIndex = 0;
    }
    
    public E get(int i) {
        return arr[i];
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public int size() {
        return size;
    }
    
    public boolean add(E item) {
        size++;
        arr[currentIndex] = item;
        currentIndex++;
        return true;
    }
}
