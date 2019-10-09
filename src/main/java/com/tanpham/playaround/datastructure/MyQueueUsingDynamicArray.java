package com.tanpham.playaround.datastructure;

public class MyQueueUsingDynamicArray<E> implements MyQueue<E> {
	
	private int DEFAULT_CAPACITY = 10;
	private int DEFAULT_FACTOR = 2;
	private E[] arr;
	private int size;
	
	public MyQueueUsingDynamicArray() {
		arr = createNewGenericArray((int) DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	private E[] createNewGenericArray(int capacity) {
		return (E[]) new Object[capacity];
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enqueue(E value) {
		if (size == arr.length) {
			resize(arr.length * DEFAULT_FACTOR);
		}
		arr[size] = value;
		size++;
	}

	@Override
	public E dequeue() {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		E value = arr[0];
		
		for (int i = 0; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[size] = null;
		size--;
		// TODO: please reduce the capacity in case it shrinks to 1/4 of the current capacity
		
		return value;
	}
	
	private void resize(int sizeToAdjust) {
		E[] newArray = createNewGenericArray(sizeToAdjust);
		int toWhatSize = sizeToAdjust > arr.length ? arr.length : sizeToAdjust;
		for (int i = 0; i < toWhatSize; i++) {
			newArray[i] = arr[i];
		}
		arr = newArray;
	}

}
