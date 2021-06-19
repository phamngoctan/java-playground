package com.tanpham.playaround.datastructure;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public abstract class MyQueueBaseTest {

    protected MyQueue<String> myQueue;
    
    @Before
    public void init() {
        myQueue = provideMyQueue();
    }
    
    public abstract MyQueue<String> provideMyQueue();
    
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
    public void enqueue_twoItemsToTheQueue() {
        myQueue.enqueue("Java");
        myQueue.enqueue("Python");
        assertThat(myQueue.size(), equalTo(2));
        assertThat(myQueue.dequeue(), equalTo("Java"));
        assertThat(myQueue.dequeue(), equalTo("Python"));
        assertThat(myQueue.empty(), equalTo(true));
    }
    
    @Test
    public void enqueue_manyItemsToTheQueue() {
    	myQueue.enqueue("Java");
        myQueue.enqueue("Python");
        myQueue.enqueue("Swift");
        myQueue.enqueue("JavaScript");
        assertThat(myQueue.size(), equalTo(4));
        assertThat(myQueue.dequeue(), equalTo("Java"));
        assertThat(myQueue.dequeue(), equalTo("Python"));
        assertThat(myQueue.dequeue(), equalTo("Swift"));
        assertThat(myQueue.dequeue(), equalTo("JavaScript"));
        assertThat(myQueue.empty(), equalTo(true));
    }
    
}
