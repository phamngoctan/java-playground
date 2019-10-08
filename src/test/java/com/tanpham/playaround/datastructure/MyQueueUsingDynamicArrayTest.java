package com.tanpham.playaround.datastructure;

public class MyQueueUsingDynamicArrayTest extends MyQueueBaseTest {

	@Override
	public MyQueue<String> provideMyQueue() {
		return new MyQueueUsingDynamicArray<String>();
	}
    
}
