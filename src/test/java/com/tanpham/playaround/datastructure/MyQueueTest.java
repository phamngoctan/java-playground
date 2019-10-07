package com.tanpham.playaround.datastructure;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.junit.Before;

public class MyQueueTest {

    private MyQueue<String> myQueue;
    
    @Before
    public void init() {
        myQueue = new MyQueue<>();
    }
    
    @Test
    public void enqueue_toTheEmptyQueue() {
        
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
    
}
