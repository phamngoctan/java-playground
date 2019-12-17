package com.tanpham.playaround.sorting;

import com.tanpham.playaround.datastructure.Node;

public class MergeSort<T extends Comparable<T>> {
	
	private static final boolean INCREASING_ORDER = true;
	private static final boolean DECREASING_ORDER = !INCREASING_ORDER;
	
	//======================================
	//======Merge sort for linkedlist=======
	//======================================
	/**
	 * Merge sort with increasing order
	 */
	public Node<T> proceed(Node<T> inputHead) {
		
		
		// Idea to implement the Merge sort
		// 1: split the linkedlist into two parts
		// 2: call recursively the proceed for first part & second part
		// 3: merge the two sorted parts & return the sorted linkedlist
		
		
		return mergeSortWithSpecificOrder(inputHead, INCREASING_ORDER);
	}
	
	public Node<T> proceedInDecreasingOrder(Node<T> inputHead) {
		return mergeSortWithSpecificOrder(inputHead, DECREASING_ORDER);
	}

	private Node<T> mergeSortWithSpecificOrder(Node<T> inputHead, boolean increasingOrder) {
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
		
		
		// 1: split the linkedlist into two parts
		Node<T> middleItem = findMiddleItem(inputHead);
		Node<T> firstPart = inputHead;
		Node<T> secondPart = middleItem.getNext();
		middleItem.setNext(null);
		
		Node<T> firstSortedPart = mergeSortWithSpecificOrder(firstPart, increasingOrder);
		Node<T> secondSortedPart = mergeSortWithSpecificOrder(secondPart, increasingOrder);
		
		return mergeTwoSortedList(firstSortedPart, secondSortedPart, increasingOrder);
	}
	
	
	// Dynamic this, change the middle item to the first part
	// 4 items -> the second item should be returned
	public Node<T> findMiddleItem(Node<T> inputHead) {
		if (inputHead == null) {
			return null;
		}
		
		Node<T> next = inputHead;
		Node<T> twoXNext = inputHead;
		
		while (twoXNext.getNext() != null
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
	
	// This can be improved 
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
					currentPositionOfFinalSortedList = currentPositionOfFinalSortedList.setNextNodeIgnoringNullValue(firstHead);
				}
				firstHead = getNextNullTolerant(firstHead);
			} else {
				if (finalSortedList == null) {
					finalSortedList = secondHead;
					currentPositionOfFinalSortedList = secondHead;
				} else {
					currentPositionOfFinalSortedList = currentPositionOfFinalSortedList.setNextNodeIgnoringNullValue(secondHead);
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
	
	//======================================
	//========Merge sort for array==========
	//======================================
	
	/*
	 * Precondition:
	 * arr[low..mid] sorted
	 * arr[mid+1...high] sorted
	 */
	public void mergeSortedArrays(Comparable[] arr, Comparable auxiliary[], int low, int mid, int high) {
		for (int k = low; k <= high; k++) { // copy to another array & sort it
			auxiliary[k] = arr[k];
		}
		
		int i = low;
		int j = mid + 1;
		
		for (int k = low; k <= high; k++) {
			if (i > mid) { // first array is out of items
				arr[k] = auxiliary[j]; j++;
			} else if (j > high) { // second array is out of items
				arr[k] = auxiliary[i]; i++;
			} else if (less(auxiliary[j], auxiliary[i])) {
				arr[k] = auxiliary[j]; j++;
			} else {
				arr[k] = auxiliary[i]; i++;
			}
		}
	}
	
	public void sort(Comparable[] arr, Comparable[] auxiliary, int low, int high) {
		if (high <= low) {
			return;
		}
		int mid = low + (high - low)/2;
		sort(arr, auxiliary, low, mid);
		sort(arr, auxiliary, mid + 1, high);
		mergeSortedArrays(arr, auxiliary, low, mid, high);
	}

	private boolean less(Comparable item1, Comparable item2) {
		return item1.compareTo(item2) < 0;
	}
	
}
