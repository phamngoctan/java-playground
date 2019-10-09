package com.tanpham.playaround.datastructure;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class MyQueueUsingDynamicArrayTest extends MyQueueBaseTest {

	private MyDynamicArrayQueue<String> getActualQueue() {
		return (MyDynamicArrayQueue<String>) myQueue;
	}
	
	@Override
	public MyQueue<String> provideMyQueue() {
		return new MyQueueUsingDynamicArray<String>();
	}
	
	@Test
	public void enqueue_autoExpendingTheSize() {
		for (int i = 0; i < 11; i++) {
			myQueue.enqueue("Value " + i);
		}
		assertThat(myQueue.size(), equalTo(11));
		assertThat(getActualQueue().capacity(), equalTo(20));
		assertThat(myQueue.dequeue(), equalTo("Value 0"));
	}
	
	@Test
	public void dequeue_autoDecreasingTheSize_whenItReducesToOneForthOfTheCapacity() {
		for (int i = 0; i < 11; i++) {
			myQueue.enqueue("Value " + i);
		}
		
		for (int i = 0; i < 6; i++) {
			myQueue.dequeue();
		}
		assertThat(myQueue.size(), equalTo(5));
		assertThat(getActualQueue().capacity(), equalTo(10));
	}
    
}
