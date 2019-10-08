package com.tanpham.playaround.datastructure;

public interface MyQueue<E> {
	public boolean empty();
	public int size();
	public void enqueue(E value);
	public E dequeue();
}
