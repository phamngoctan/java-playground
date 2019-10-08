package com.tanpham.playaround.datastructure;

/**
 * This kind of datastructure can be implemented in two ways.<br/>
 * First one is following the idea of LinkedList which is the list of Node<E> point to next one.
 * The insertion time will cost O(1) but the search will be linear time O(n), that means dequeue at tail would be O(n) because you'd need the next to last element, causing a full traversal each dequeue. <br/>
 * Secondly, following the idea of Vector to use the dynamic array of items.
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
