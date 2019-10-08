package com.tanpham.playaround.datastructure;

/**
 * This kind of data structure can be implemented in two ways.<br/>
 * First one is following the idea of LinkedList which is the list of Node<E> point to next one.
 * The insertion time will cost O(1) but the search will be linear time O(n), that means dequeue at tail would be O(n) because you'd need the next to last element, causing a full traversal each dequeue. <br/>
 * Secondly, following the idea of Vector to use the dynamic array of items.<br/><br/>
 * 
 * In this class implementation, I would go with option enqueue the new item to the tail.<br/>
 * The dequeue will be beneficial from this step because it takes O(1).
 */
public class MyQueueUsingLinkList<E> implements MyQueue<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;
    
    public MyQueueUsingLinkList() {
        size = 0;
    }
    
    @Override
	public int size() {
		return size;
	}
    
    @Override
    public boolean empty() {
        return size == 0;
    }
    
    @Override
    public void enqueue(E value) {
    	if (size == 0) {
    		head = new Node<>(value);
    		tail = head;
    		size++;
    		return;
    	}
    	
    	size++;
    }

	@Override
	public E dequeue() {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> result = head;
		if (head.next != null) {
			head = head.next;
			result.next = null;
		}
		size--;
		return head.value;
	}

}
