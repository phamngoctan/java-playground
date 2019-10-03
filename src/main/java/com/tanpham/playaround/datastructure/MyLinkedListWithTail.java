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
        validateBoundaryOfIndex(index);
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
    	if (size <= 0) {
    		throw new IndexOutOfBoundsException();
    	}
    	E value = head.value;
    	
    	// Need to make sure the old head point to NOWHERE
    	Node<E> tmp = head.next;
		head.next = null;
    	
    	head = tmp;
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
		
		if (newNode.next == null) {
		    tail = newNode;
		}
		size++;
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
	
	public void remove(E value) {
	    if (size == 0) {
	        return;
	    }
	    
//	    if (size == 1 && value == head.value) {
//	        popFront();
//	        return;
//	    }
	    
	    
	    // Handle the remove for non-head items
		Node<E> next = head;
		while (next != null) {
			if (next.next != null && next.next.value.equals(value)) {
				next.next = next.next.next;
				
				// In-case the item to be removed is at the end of list
				// So the next item of its is null
				if (next.next != null) {
					next.next.next = null;
				} else {
				    // In case the next.next item is null, then the current item should be the tail
				    tail = next;
				}
				size--;
			}
			next = next.next;
		}
		
		if (value == head.value) {
		    popFront();
		}
		
		if (tail != null && value == tail.value) {
		    popBack();
		}
		
		// handle tail & head pointer
	}
	
	// The idea to implement this method can be use to implement the reverse linkedlist
	public E getMiddle() {
	    if (size == 0) {
	        return null;
	    }
	    if (size == 1) {
	        return head.value;
	    }
	    
	    Node<E> next = head;
	    Node<E> fasterNode = head;
	    while (fasterNode != null && fasterNode.next != null) {
	        next = next.next;
	        fasterNode = fasterNode.next.next;
	    }
		return next.value;
	}

    public void reverse() {
        if (size <= 1) {
            return;
        }
        
        Node<E> newLinkedListNode = null;
        Node<E> next = head;
        while (next != null) {
        	
        	Node<E> nodeToBeAdded = new Node<>(next.value);
        	if (newLinkedListNode == null) {
        		tail = nodeToBeAdded;
        	}
        	
        	nodeToBeAdded.next = newLinkedListNode;
        	newLinkedListNode = nodeToBeAdded;
    		
        	next = next.next;
        }
        head = newLinkedListNode;
    }
	
	//Not up-to-date like erase method
	public void delete(int index) {
		validateBoundaryOfIndex(index);
		
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

	public E erase(int index) {
		validateBoundaryOfIndex(index);
		
		Node<E> next = head;
		int i = 0;
		while (next != null && i < index - 1) {
			i++;
		}
		
		// index is right at the head
		if (next.next == null) {
			return popFront();
		}
		
		// index is right at the tail
		// a -> b -> null
		// b is our index and its next item is null
		if (next.next.next == null) {
			tail = next.next;
		} else {
			next.next = next.next.next;
			next.next.next = null;
		}
		
		size--;
		return next.next.value;
	}

	private void validateBoundaryOfIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	// Cheat people
	public E valueOfIndexCountFromEnd(int indexFromEnd) {
		int valueCountFromHead = size - 1 - indexFromEnd;
		return valueAt(valueCountFromHead);
	}
	
}
