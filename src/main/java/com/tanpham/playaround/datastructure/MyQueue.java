package com.tanpham.playaround.datastructure;

/**
 * This kind of datastructure can be implemented in two ways.<br/>
 * First one is following the idea of LinkedList which is the list of Node<E> point to next one.
 * The insertion time will cost O(n) but the search will be linear time O(n). <br/>
 * Secondly, following the idea of Vector to use the array of items which can be search in O(1) time but it costs every time we insert or delete an item O(n).
 * We have to do the shift right or shift left the whole array. <br/>
 */
public class MyQueue<E> {

    private int size;
    
    public MyQueue() {
        size = 0;
    }
    
    public void enqueue(E value) {
        // TODO: auto generated code
    }

    public boolean empty() {
        return size == 0;
    }
    
}
