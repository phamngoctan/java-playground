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
        currentIndex = -1;
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
        arr[++currentIndex] = item;
        return true;
    }
    
    public boolean add(int index, E item) {
        int currentIndexOfTheAddingFunction = currentIndex + 1;
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index > currentIndexOfTheAddingFunction) {
            throw new ArrayIndexOutOfBoundsException(index + " > " + currentIndexOfTheAddingFunction);
        }
        if (index == currentIndexOfTheAddingFunction) {
            size++;
        }
        arr[index] = item;
        currentIndex = index;
        return true;
    }
}
