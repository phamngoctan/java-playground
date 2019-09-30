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
        if (head == null) {
        	tail = newNode;
        } else {
        	newNode.next = head;
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
			resetHeadTail();
		}
		size--;
		return value;
	}
	
	private void resetHeadTail() {
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
	
	public void pushBack(E value) {
		Node<E> newNode = new Node<>(value);
		if (tail == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		size++;
	}
	
	public E front() {
		if (head == null) {
			return null;
		}
		return head.value;
	}
	
	public E back() {
		if (tail == null) {
			return null;
		}
		return tail.value;
	}
    
	public void insert(int index, E value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (head == null || index == 0) {
			pushFront(value);
			return;
		}
		
		Node<E> next = getItemRightBefore(index);
		
		Node<E> newNode = new Node<E>(value);
		newNode.next = next.next;
		next.next = newNode;
		size++;
		
		//TODO: implement the remaining part for inserting new node at index
	}

	private Node<E> getItemRightBefore(int index) {
		Node<E> next = head;
		int i = 0;
		// Idea is to pick the item before the index to be inserted
		while (next != null && i != index - 1) {
			next = next.next;
			i++;
		}
		return next;
	}
	
	public void prepend(E value) {
		pushFront(value);
	}
	
	public void delete(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0) {
			popFront();
			return;
		}
		
		Node<E> itemRightBefore = getItemRightBefore(index);
		itemRightBefore.next = itemRightBefore.next.next;
		itemRightBefore.next.next = null;
		size--;
		
		// TODO: handle tail & head pointer
	}
	
	public void remove(E value) {
		Node<E> next = head;
		while (next != null) {
			if (next.next != null && next.next.value == value) {
				next.next = next.next.next;
				
				// In-case the item to be removed is at the end of list
				// So the next item of its is null
				if (next.next != null) {
					next.next.next = null;
				}
				size--;
			}
			next = next.next;
		}
		// TODO: handle head case
		// handle tail & head pointer
	}
	
	public E getMiddle() {
		//TODO: also implement the method to find the middle item of linkedlist
		return null;
	}
	
}
