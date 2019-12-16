package com.tanpham.playaround.datastructure;

public class Node<E> {
	Node<E> next;
	E value;

	public Node(E value) {
		this.value = value;
	}

	public Node<E> getNext() {
		return next;
	}
	
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	public Node<E> initNextNodeByValue(E value) {
		this.next = new Node<>(value);
		return this.next;
	}
	
	public Node<E> setNextNodeIgnoringNullValue(Node<E> node) {
		// this makes a trick when handling the merge of two sorted list
		if (node == null) {
			return this;
		}
		this.next = node;
		return this.next;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
    
}
