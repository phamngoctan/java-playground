package com.tanpham.playaround.sorting;

import java.util.Optional;

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
		
		Node<T> middleItem = findMiddleItem(inputHead);
		
		return null;
	}
	
	// Dynamic this, change the middle item to the first part
	// 4 items -> the second item should be returned
	public Node<T> findMiddleItem(Node<T> inputHead) {
		if (inputHead == null) {
			return null;
		}
		
		Node<T> next = inputHead;
		Node<T> twoXNext = inputHead;
		
		while (twoXNext != null
				&& twoXNext.getNext() != null
				&& twoXNext.getNext().getNext() != null) {
			next = next.getNext();
			twoXNext = twoXNext.getNext().getNext();
		}
		return next;
	}

	public Node<T> mergeTwoSortedList(Node<T> firstHead, Node<T> secondHead) {
		return mergeTwoSortedList(firstHead, secondHead, INCREASING_ORDER);
	}
	
	public Node<T> mergeTwoSortedListDecreasingOrder(Node<T> firstHead, Node<T> secondHead) {
		return mergeTwoSortedList(firstHead, secondHead, !INCREASING_ORDER);
	}
	
	private Node<T> mergeTwoSortedList(Node<T> firstHead, Node<T> secondHead, boolean increasingOrder) {
		if (firstHead == null && secondHead == null) {
			return null;
		}
		
		Node<T> finalSortedList = null;
		Node<T> currentPositionOfFinalSortedList = null;
		
		while (firstHead != null || secondHead != null) {
			boolean shouldPickFirstItemCurrent = shouldPickFirstItem(firstHead, secondHead, increasingOrder);
			boolean shouldPickFirstItemNext = shouldPickFirstItem(firstHead, getNextNullTolerant(secondHead), increasingOrder);
			if (shouldPickFirstItemCurrent && shouldPickFirstItemNext) {
				if (finalSortedList == null) {
					finalSortedList = firstHead;
					currentPositionOfFinalSortedList = firstHead;
				} else {
					currentPositionOfFinalSortedList = currentPositionOfFinalSortedList.setNext(firstHead);
				}
				firstHead = getNextNullTolerant(firstHead);
			} else {
				if (finalSortedList == null) {
					finalSortedList = secondHead;
					currentPositionOfFinalSortedList = secondHead;
				} else {
					currentPositionOfFinalSortedList = currentPositionOfFinalSortedList.setNext(secondHead);
				}
				secondHead = getNextNullTolerant(secondHead);
			}
		}
		
		return finalSortedList;
	}
	
	public boolean shouldPickFirstItem(Node<T> firstHead, Node<T> secondHead, boolean increasingOrder) {
		if (firstHead == null) {
			return false;
		}
		
		if (secondHead == null) {
			return true;
		}
		
		boolean firstNodeBiggerThanSecondOne = isFirstNodeBiggerThanSecondOneWithNullTolerant(firstHead, secondHead);
		
		//TODO: refactor this if else statement
		if (firstNodeBiggerThanSecondOne && increasingOrder) {
			return false;
		} else if (firstNodeBiggerThanSecondOne && !increasingOrder) {
			return true;
		} else if (!firstNodeBiggerThanSecondOne && increasingOrder) {
			return true;
		} else {
			return false;
		}
	}
	
	private Node<T> getNextNullTolerant(Node<T> node) {
		return node == null ? null : node.getNext();
	}

	private boolean isFirstNodeBiggerThanSecondOneWithNullTolerant(Node<T> firstHead, Node<T> secondHead) {
		return firstHead.getValue().compareTo(secondHead.getValue()) > 0;
	}
	
}
