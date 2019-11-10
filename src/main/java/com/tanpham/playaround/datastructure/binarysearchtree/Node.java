package com.tanpham.playaround.datastructure.binarysearchtree;

public class Node<T> {
	private T data;
	private Node<T> leftChild;
	private Node<T> rightChild;
	
	public Node() {
		// Empty constructor
	}

	public Node(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}

}
