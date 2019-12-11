package com.tanpham.playaround.sorting;

import com.tanpham.playaround.datastructure.Node;

public class MergeSort<T extends Comparable<T>> {
	
	private static final boolean INCREASING_ORDER = true;

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
		Node<T> finalSortedList = null;
		Node<T> currentPositionOfFinalSortedList = null;
		while (firstHead != null || secondHead != null) {
			if (isFirstNodeBiggerThanSecondOneWithNullTolerant(firstHead, secondHead)) {
				if (currentPositionOfFinalSortedList == null) {
					if (INCREASING_ORDER) {
						finalSortedList = secondHead;
						currentPositionOfFinalSortedList = finalSortedList;
					} else {
						finalSortedList = firstHead;
						currentPositionOfFinalSortedList = finalSortedList;
					}
				} else {
					if (INCREASING_ORDER) {
						currentPositionOfFinalSortedList.setNext(secondHead);
					} else {
						currentPositionOfFinalSortedList.setNext(firstHead);
					}
				}
			}
			firstHead = firstHead.getNext();
			secondHead = secondHead.getNext();
		}
		return firstHead;
	}

	private boolean isFirstNodeBiggerThanSecondOneWithNullTolerant(Node<T> firstHead, Node<T> secondHead) {
		return firstHead.getValue().compareTo(secondHead.getValue()) > 0;
	}
	
}
