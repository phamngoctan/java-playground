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
    
    public int capacity() {
        return capacity;
    }
    
    public int size() {
        return size;
    }
    
    public boolean push(E item) {
    	int nextIndex = currentIndex + 1;
        return insert(nextIndex, item);
    }
    
    //TODO: refactor currentIndex variable, remove it I think
    // First enhancement, should not replace the item, instead, move the item to the right
    // add the newly created item to the specific index
    public boolean insert(int index, E item) {
        int nextIndexOfArray = currentIndex + 1;
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index > nextIndexOfArray) {
            throw new ArrayIndexOutOfBoundsException(index + " > " + nextIndexOfArray);
        }
                
        if (nextIndexOfArray == capacity) {
            increaseCapacity();
        }
        
        increaseSizeOnlyWhenIndexOfNewItemEqualNextIndexOfArray(index, nextIndexOfArray);
        currentIndex++;
        arr[index] = item;
        return true;
    }

	private void increaseSizeOnlyWhenIndexOfNewItemEqualNextIndexOfArray(int index,
			int nextIndexOfArray) {
		if (index == nextIndexOfArray) {
            size++;
        }
	}
    
    private void increaseCapacity() {
        int newCapacity = (int) (FACTOR * DEFAULT_CAPACITY);
        E[] newCapacityArr = (E[]) new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newCapacityArr[i] = arr[i];
        }
        arr = newCapacityArr;
        capacity = newCapacity;
    }

	public boolean isEmpty() {
		return size == 0;
	}

	public E at(int i) {
		return arr[i];
	}
}
