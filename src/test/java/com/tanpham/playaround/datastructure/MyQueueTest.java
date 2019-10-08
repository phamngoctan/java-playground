package com.tanpham.playaround.datastructure;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.junit.Before;

public class MyQueueTest {

    private MyQueue<String> myQueue;
    
    @Before
    public void init() {
        myQueue = new MyQueueUsingLinkList<>();
    }
    
    @Test
    public void sizeShouldBeZero_whenQueueIsEmpty() {
    	assertThat(myQueue.size(), equalTo(0));
    }
    
    @Test
    public void empty_inCaseEmptyQueue() {
        assertThat(myQueue.empty(), equalTo(true));
    }
    
    @Test
    public void empty_inCaseNotEmptyQueue() {
        myQueue.enqueue("Java");
        assertThat(myQueue.empty(), equalTo(false));
    }
    
    @Test
    public void size_inCaseNotEmptyQueue() {
        myQueue.enqueue("Java");
        assertThat(myQueue.size(), equalTo(1));
    }
    
    @Test
    public void size_inCaseManyItemsInQueue() {
        myQueue.enqueue("Java");
        myQueue.enqueue("Python");
        assertThat(myQueue.size(), equalTo(2));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void dequeue_inCaseTheQueueHasNoItem() {
    	myQueue.dequeue();
    	assertThat(myQueue.size(), equalTo(1));
    }
    
    @Test
    public void dequeue_inCaseQueueHasOneItem() {
        myQueue.enqueue("Java");
        assertThat(myQueue.dequeue(), equalTo("Java"));
        assertThat(myQueue.size(), equalTo(0));
    }
    
    @Test
    public void enqueue_manyItemsToTheQueue() {
        myQueue.enqueue("Java");
        myQueue.enqueue("Python");
        assertThat(myQueue.size(), equalTo(2));
        assertThat(myQueue.dequeue(), equalTo("Java"));
        assertThat(myQueue.dequeue(), equalTo("Python"));
    }
    
}
