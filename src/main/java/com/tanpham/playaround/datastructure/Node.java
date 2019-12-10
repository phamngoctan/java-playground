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

	public Node<E> setNext(E value) {
		this.next = new Node<>(value);
		return this.next;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

}
