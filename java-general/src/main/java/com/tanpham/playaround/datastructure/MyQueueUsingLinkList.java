package com.tanpham.playaround.datastructure;

public class MyQueueUsingLinkList<E> implements MyQueue<E> {

    private int size;
    private Node<E> head;
    private Node<E> oneItemBeforeTail;
    
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
    		size++;
    		return;
    	} else if (size == 1) {
    		Node<E> newNode = new Node<>(value);
    		head.next = newNode;
    		oneItemBeforeTail = head;
    		size++;
    		return;
    	}
    	
    	Node<E> newNode = new Node<>(value);
    	oneItemBeforeTail.next.next = newNode;
    	oneItemBeforeTail = oneItemBeforeTail.next;
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
		}
		result.next = null;
		size--;
		return result.value;
	}

}
