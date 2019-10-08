package com.tanpham.playaround.datastructure;

public class MyQueueUsingDynamicArray<E> implements MyQueue<E> {
	
	private double DEFAULT_CAPACITY = 10;
	private double DEFAULT_FACTOR = 1.5;
	private E[] arr;
	private int size;
	
	public MyQueueUsingDynamicArray() {
		arr = createNewGenericArray();
	}

	@SuppressWarnings("unchecked")
	private E[] createNewGenericArray() {
		return (E[]) new Object[(int) DEFAULT_CAPACITY];
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
		arr[size] = value;
		size++;
		//TODO: please extend the array in case it reaches the full of capacity
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

}
