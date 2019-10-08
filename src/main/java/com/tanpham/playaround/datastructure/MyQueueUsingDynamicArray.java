package com.tanpham.playaround.datastructure;

public class MyQueueUsingDynamicArray<E> implements MyQueue<E> {
	
	private double DEFAULT_CAPACITY = 10;
	private double DEFAULT_FACTOR = 1.5;
	private int size;
	private E[] arr;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

}
