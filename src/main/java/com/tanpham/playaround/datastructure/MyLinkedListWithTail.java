package com.tanpham.playaround.datastructure;

public class MyLinkedListWithTail<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;
    
    private class Node<E> {
        Node<E> next;
        E value;
        
        public Node(E value) {
            this.value = value;
        }
    }
    
    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public E valueAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> next = head;
        int i = 0;
        while (next != null) {
            if (i == index) {
                return next.value;
            }
            i++;
            next = next.next;
        }
        return null;
    }

    public void pushFront(E value) {
        Node<E> newNode = new Node<>(value);
        if (head != null) {
            newNode.next = head;
        } else {
        	tail = newNode;
        }
        head = newNode;
        
        size++;
    }
    
    public E popFront() {
    	E value = head.value;
    	head = head.next;
    	consistentHeadOrTailNull();
    	size--;
    	return value;
    }

	private void consistentHeadOrTailNull() {
		if (head == null) {
    		tail = null;
    	}
	}

	public E popBack() {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		E value = tail.value;
		
		Node<E> itemBeforeTail = pickItemRightBeforeTail();
		if (itemBeforeTail != null) {
			tail = itemBeforeTail;
		} else {
			// This case happen when there is only one item in the linkedlist
			resetLinkedList();
		}
		size--;
		return value;
	}
	
	private void resetLinkedList() {
		tail = null;
		head = null;
	}

	public E pickValueRightBeforeTail() {
		Node<E> item = pickItemRightBeforeTail();
		if (item != null) {
			return item.value;
		}
		return null;
	}
	
	private Node<E> pickItemRightBeforeTail() {
		if (size < 2) {
			return null;
		}
		Node<E> next = head;
		while (next.next != null && next.next.next != null) {
			next = next.next;
		}
		return next;
	}
    
}
