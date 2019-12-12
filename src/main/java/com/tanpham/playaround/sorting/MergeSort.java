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
		return mergeTwoSortedList(firstHead, secondHead, INCREASING_ORDER);
	}
	
	public Node<T> mergeTwoSortedListDecreasingOrder(Node<T> firstHead, Node<T> secondHead) {
		return mergeTwoSortedList(firstHead, secondHead, !INCREASING_ORDER);
	}
	
	private Node<T> mergeTwoSortedList(Node<T> firstHead, Node<T> secondHead, boolean increasingOrder) {
		Node<T> finalSortedList = null;
		Node<T> currentPositionOfFinalSortedList = null;
		Node<T> tempFirstHead = null;
		Node<T> tempSecondHead = null;
		while (firstHead != null || secondHead != null) {
			// without this line, the next item will not be considered because the next pointer is lost in the process
			tempFirstHead = firstHead == null ? null : firstHead.getNext();
			tempSecondHead = secondHead == null ? null : secondHead.getNext();
			
			if (isFirstNodeBiggerThanSecondOneWithNullTolerant(firstHead, secondHead)) {
				if (currentPositionOfFinalSortedList == null) {
					if (increasingOrder) {
						finalSortedList = secondHead;
						currentPositionOfFinalSortedList = finalSortedList.setNext(firstHead);
					} else {
						finalSortedList = firstHead;
						currentPositionOfFinalSortedList = finalSortedList.setNext(secondHead);
					}
				} else {
					if (increasingOrder) {
						currentPositionOfFinalSortedList.setNext(secondHead).setNext(firstHead);
					} else {
						currentPositionOfFinalSortedList.setNext(firstHead).setNext(secondHead);
					}
				}
				
			} else {
				if (currentPositionOfFinalSortedList == null) {
					if (increasingOrder) {
						finalSortedList = firstHead;
						currentPositionOfFinalSortedList = finalSortedList.setNext(secondHead);
					} else {
						finalSortedList = secondHead;
						currentPositionOfFinalSortedList = finalSortedList.setNext(firstHead);
					}
				} else {
					if (increasingOrder) {
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
		if (firstHead == null) {
			return false;
		}
		
		if (secondHead == null) {
			return true;
		}
		
		return firstHead.getValue().compareTo(secondHead.getValue()) > 0;
	}
	
}
