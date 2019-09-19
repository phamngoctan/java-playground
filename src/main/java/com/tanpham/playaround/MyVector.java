package com.tanpham.playaround;

public class MyVector<E extends Object> {
    private static final double DEFAULT_CAPACITY = 10;
    private static final double FACTOR = 1.5;
    private E arr[];
    private int capacity;
    private int size;
    private int currentIndex;
    
    public MyVector() {
        arr = (E[]) new Object[(int) DEFAULT_CAPACITY];
        capacity = (int) DEFAULT_CAPACITY;
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
        currentIndex = index;
        
        if (currentIndexOfTheAddingFunction == capacity) {
            increaseSize();
        }
        
        arr[index] = item;
        return true;
    }
    
    private void increaseSize() {
        int newCapacity = (int) (FACTOR * size);
        System.out.println(newCapacity);
        E[] newCapacityArr = (E[]) new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newCapacityArr[i] = arr[i];
        }
        arr = newCapacityArr;
    }
}
