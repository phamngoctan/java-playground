package com.tanpham.playaround.datastructure;

public class MyQueueUsingLinkedListTest extends MyQueueBaseTest {

	@Override
	public MyQueue<String> provideMyQueue() {
		return new MyQueueUsingLinkList<>();
	}
    
}
