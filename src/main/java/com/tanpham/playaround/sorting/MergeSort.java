package com.tanpham.playaround.sorting;

import com.tanpham.playaround.datastructure.Node;

public class MergeSort<T> {

	public Node<T> proceed(Node<T> inputHead) {
		if (inputHead == null) {
			return null;
		}
		
		if (inputHead.getNext() == null) {
			return inputHead;
		}
		
		// Idea to implement the Merge sort
		// 1: split the linkedlist into two parts
		// 2: call recursively the proceed for first part & second part
		// 3: merge the two sorted parts & return the sorted linkedlist
		
		return null;
	}
	
	public Node<T> mergeTwoSortedList(Node<T> firstHead, Node<T> secondHead) {
		return firstHead;
	}
	
}
