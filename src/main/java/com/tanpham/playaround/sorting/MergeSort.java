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
		Node<T> tempFirstHead = null;
		Node<T> tempSecondHead = null;
		while (firstHead != null || secondHead != null) {
			// without this line, the next item will not be considered because the next pointer is lost in the process
			tempFirstHead = firstHead.getNext();
			tempSecondHead = secondHead.getNext();
			
			if (isFirstNodeBiggerThanSecondOneWithNullTolerant(firstHead, secondHead)) {
				if (currentPositionOfFinalSortedList == null) {
					if (INCREASING_ORDER) {
						finalSortedList = secondHead;
						currentPositionOfFinalSortedList = finalSortedList.setNext(firstHead);
					} else {
						finalSortedList = firstHead;
						currentPositionOfFinalSortedList = finalSortedList.setNext(secondHead);
					}
				} else {
					if (INCREASING_ORDER) {
						currentPositionOfFinalSortedList.setNext(secondHead).setNext(firstHead);
					} else {
						currentPositionOfFinalSortedList.setNext(firstHead).setNext(secondHead);
					}
				}
				
			} else {
				if (currentPositionOfFinalSortedList == null) {
					if (INCREASING_ORDER) {
						finalSortedList = firstHead;
						currentPositionOfFinalSortedList = finalSortedList.setNext(secondHead);
					} else {
						finalSortedList = secondHead;
						currentPositionOfFinalSortedList = finalSortedList.setNext(firstHead);
					}
				} else {
					if (INCREASING_ORDER) {
						currentPositionOfFinalSortedList = currentPositionOfFinalSortedList.setNext(firstHead).setNext(secondHead);
					} else {
						currentPositionOfFinalSortedList = currentPositionOfFinalSortedList.setNext(secondHead).setNext(firstHead);
					}
				}

			}
			
			firstHead = tempFirstHead;
			secondHead = tempSecondHead;
		}
		return finalSortedList;
	}

	private boolean isFirstNodeBiggerThanSecondOneWithNullTolerant(Node<T> firstHead, Node<T> secondHead) {
		return firstHead.getValue().compareTo(secondHead.getValue()) > 0;
	}
	
}
