package com.tanpham.playaround.datastructure;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class MyQueueUsingDynamicArrayTest extends MyQueueBaseTest {

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
		assertThat(myQueue.dequeue(), equalTo("Value 0"));
	}
    
}
