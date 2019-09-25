package com.tanpham.playaround;

public class MyVector<E extends Object> {
    private static final double DEFAULT_CAPACITY = 10;
    private static final double FACTOR = 2;
    private E arr[];
    private int capacity;
    private int size;
    private int currentIndex;
    
    public MyVector() {
        arr = createNewArray((int) DEFAULT_CAPACITY);
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
    /**
     * when it reaches capacity, resize to double the size
     */
    public boolean insert(int index, E item) {
        int nextIndexOfArray = currentIndex + 1;
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Position to insert cannot less than Zero");
        }
        if (index > nextIndexOfArray) {
            throw new ArrayIndexOutOfBoundsException(index + " > " + nextIndexOfArray);
        }

        if (nextIndexOfArray == capacity - 1) {
            increaseCapacity();
        }
        
        increaseSizeOnlyWhenIndexOfNewItemEqualNextIndexOfArray(index, nextIndexOfArray);
        currentIndex++;
        shiftElementsToRight(index);
        arr[index] = item;
        return true;
    }

	private void increaseSizeOnlyWhenIndexOfNewItemEqualNextIndexOfArray(int index,
			int nextIndexOfArray) {
//		if (index == nextIndexOfArray) {
            size++;
//        }
	}
    
    private void increaseCapacity() {
        int newCapacity = (int) (FACTOR * DEFAULT_CAPACITY);
        E[] newCapacityArr = createNewArray(newCapacity);
        for (int i = 0; i < capacity; i++) {
            newCapacityArr[i] = arr[i];
        }
        arr = newCapacityArr;
        capacity = newCapacity;
    }
    
    private void decreaseCapacity() {
        int newCapacity = (int) (capacity / FACTOR);
        E[] newCapacityArr = createNewArray(newCapacity);
        for (int i = 0; i < newCapacity; i++) {
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
	
	public void prepend(E value) {
        insert(0, value);
    }
	
	/**
	 * when popping an item, if size is 1/4 of capacity, resize to half
	 */
	public E pop() {
	    return delete(size - 1);
	}
	
	private void shiftElementsToRight(int index) {
	    int i = size - 1;
	    while (i >= index && i < capacity) {
	        arr[i + 1] = arr[i];
	        i--;
	    }
	}
	
	@SuppressWarnings("unchecked")
    private E[] createNewArray(int newCapacity) {
        return (E[]) new Object[newCapacity];
    }
	
	public E delete(int index) {
	    E deletedItemValue = arr[index];
	    shiftTrailingElementsToLeft(index);
        arr[size - 1] = null;
        currentIndex--;
        size--;
        if (size <= capacity / 4) {
            decreaseCapacity();
        }
        return deletedItemValue;
	}
	
	private void shiftTrailingElementsToLeft(int index) {
	    int i = index;
	    while (i < size) {
	        arr[i] = arr[i + 1];
            i++;
	    }
	}
	
	public int find(E value) {
	    for (int i = 0; i < size; i++) {
	        if (arr[i] == value) {
	            return i;
	        }
	    }
	    return -1;
	}
    
}
