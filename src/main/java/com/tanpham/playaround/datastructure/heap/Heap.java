package com.tanpham.playaround.datastructure.heap;

import com.tanpham.playaround.datastructure.binarysearchtree.Node;

public class Heap<T> {
	private Node<T>[] arr;
	private Node<T> root;
	
	@SuppressWarnings("unchecked")
	public Heap() {
		arr = new Node[16];
	}
	
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	// TODO: add more method for the heap
	// Add the method for adding new node to the HEAP
	
	public void heapify() {
		int halfLength = arr.length/2;
		for (int i = halfLength; i >= 0; i--) {
			maxHeapify(arr, i);
		}
	}

	/**
	 * Correct the subtree at position
	 * @param atPosition
	 */
	private void maxHeapify(Node<T>[] visualizedArray, int atPosition) {
		
	}

}
