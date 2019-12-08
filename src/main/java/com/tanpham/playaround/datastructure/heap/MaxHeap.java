package com.tanpham.playaround.datastructure.heap;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * This MaxHeap does not consider the dynamic array. Just hard code the default length is 100. </br>
 * Out of this length would not be covered.
 */
public class MaxHeap<T extends Comparable<T>> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] arr;
	private int size;
	final Class<T> typeParameterClass;
	
	public MaxHeap(Class<T> typeClass) {
		size = 0;
		//arr = (T[]) new Comparable[DEFAULT_CAPACITY];
		typeParameterClass = typeClass;
		arr = createNewGenericArray(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	private T[] createNewGenericArray(int capacity) {
		return (T[]) Array.newInstance(typeParameterClass, capacity);
	}
	
	public MaxHeap<T> setArr(T... inputArr) {
		if (Objects.isNull(inputArr)) {
			return this;
		}
		
		if (inputArr.length > DEFAULT_CAPACITY) {
			throw new RuntimeException("Does not support the initial items larger than the default capacity: " + DEFAULT_CAPACITY);
		}
		
		for (int i = 0; i < inputArr.length; i++) {
			arr[i] = inputArr[i];
			size++;
		}
		return this;
	}
	
	public int size() {
		return size;
	}
	
	public T[] getArr() {
		return arr;
	}
	
	public void extractMax(T value) {
		// TODO: implement the deletion
		// Special case: delete the root, swap with the last leaf
	}
	
	/**
	 * Build max heap from unordered array <br/>
	 * 1. find max element A[1] <br/>
	 * 2. swap element A[n] with A[1] <br/>
	 *     now the max element is at the end of array<br/>
	 * 3. discard node n from heap by decrementing heap size <br/>
	 * 4. new root may violate max heap property but the child are max
	 */
	public void buildMaxHeap() {
		// Original idea from Professor Srini Devadas
		// From lastRootPosition to zero in the array are always the nodes which have sub tree. 
		// Those nodes should be considered to be heapified.
		int lastRootPosition = size/2 - 1;
		for (int i = lastRootPosition; i >= 0; i--) {
			maxHeapify(arr, i);
		}
	}

	public void maxHeapify(int atPosition) {
		maxHeapify(arr, atPosition);
	}
	
	// TODO: consider to implement it again :)
	/**
	 * Correct the subtree at position
	 * @param atPosition
	 */
	private void maxHeapify(T[] visualizedArray, int atPosition) {
		int max = size;
		int index = 0;
		int leftChild = 0;
		int righChild = 0;

		while (atPosition < max) {
			index = atPosition;

			leftChild = 2 * atPosition + 1;
			righChild = leftChild + 1;

			if (leftChild < max 
					&& Objects.nonNull(visualizedArray[leftChild])
					&& Objects.nonNull(visualizedArray[index])
					&& visualizedArray[leftChild].compareTo(visualizedArray[index]) > 0) {
				index = leftChild;
			}

			if (righChild < max 
					&& Objects.nonNull(visualizedArray[righChild])
					&& Objects.nonNull(visualizedArray[index])
					&& visualizedArray[righChild].compareTo(visualizedArray[index]) > 0) {
				index = righChild;
			}

			if (index == atPosition) {
				return;
			}

			swap(visualizedArray, atPosition, index);

			atPosition = index;
		}
	}

	private void swap(T[] visualizedArray, int firstItemIndex, int secondItemIndex) {
		T temp = visualizedArray[firstItemIndex];
		visualizedArray[firstItemIndex] = visualizedArray[secondItemIndex];
		visualizedArray[secondItemIndex] = temp;
	}
	
	/**
	 * Given a Binary Heap and a new element to be added to this Heap. <br/>
	 * The task is to insert the new element to the Heap maintaining the properties of Heap.
	 */
	public void insert(T value) {
		if (arr.length == size) {
			increaseSize();
		}
		
		int positionToAddNewValue = size;
		arr[positionToAddNewValue] = arr[0];
		
		arr[0] = value;
		size++;
		buildMaxHeap();
	}
	
	private void increaseSize() {
		T[] newArr = createNewGenericArray(arr.length * 2);
		for (int i = 0; i <= arr.length; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
	
}
