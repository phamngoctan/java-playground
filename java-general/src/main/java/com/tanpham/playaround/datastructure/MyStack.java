package com.tanpham.playaround.datastructure;

/**
 * TODO: come back to the class one day to handle the increasing of size when pushing more then the current capacity
 */
public class MyStack<E> {
	
	private static final double DEFAULT_CAPACITY = 10;
    //private static final double FACTOR = 2;
	private E[] arr;
	private int size;
	
	public MyStack() {
		arr = createNewArray((int) DEFAULT_CAPACITY);
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
    private E[] createNewArray(int newCapacity) {
        return (E[]) new Object[newCapacity];
    }
	
	public boolean empty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}

	/**
	 * Get the item without removing it out of the stack
	 */
	public E peek() {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		return arr[size-1];
	}

	public E pop() {
		E value = arr[size];
		size--;
		return value;
	}

	public void push(E value) {
		arr[size] = value;
		size++;
	}

	public int search(String string) {
		// TODO Auto-generated method stub
		return -1;
	}

}
