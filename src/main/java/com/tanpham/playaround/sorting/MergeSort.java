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
		
		return null;
	}
	
}
