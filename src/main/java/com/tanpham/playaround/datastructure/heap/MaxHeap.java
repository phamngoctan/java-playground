package com.tanpham.playaround.datastructure.heap;

public class MaxHeap<T extends Comparable<? super T>> {
	private T[] arr;
	
	@SuppressWarnings("unchecked")
	public MaxHeap() {
		arr = (T[]) new Comparable[32];
	}
	
	public MaxHeap<T> setArr(T[] inputArr) {
		arr = inputArr;
		return this;
	}
	
	public T[] getArr() {
		return arr;
	}
	
	// TODO: add more method for the heap
	
	/**
	 * Given a Binary Heap and a new element to be added to this Heap. <br/>
	 * The task is to insert the new element to the Heap maintaining the properties of Heap.
	 */
	public void insert(T value) {
		//TODO: implement the insertion
	}
	
	public void extractMax(T value) {
		// TODO: implement the deletion
		// Special case: delete the root, swap with the last leaf
	}
	
	public void heapify() {
		// Original idea from Professor Srini Devadas
//		int halfLength = arr.length/2;
//		for (int i = halfLength; i >= 0; i--) {
//			maxHeapify(arr, i);
//		}
		int halfLength = arr.length/2 - 1;
//		System.out.println(halfLength);
		for (int i = halfLength; i >= 0; i--) {
			maxHeapify(arr, i);
		}
	}

	/**
	 * Correct the subtree at position
	 * @param atPosition
	 */
	public void maxHeapify(T[] visualizedArray, int atPosition) {
//		visualizedArray[atPosition].getValue().equals(obj)
//		if (visualizedArray[atPosition].getValue()) {
//			
//		}
		System.out.println("Level " + atPosition);
		
		int max = visualizedArray.length;
		int index = 0;
		int leftChild = 0;
		int righChild = 0;

		while (atPosition < max) {
			index = atPosition;

			leftChild = 2 * atPosition + 1;
			righChild = leftChild + 1;

			if (leftChild < max && visualizedArray[leftChild].compareTo(visualizedArray[index]) > 0) {
				index = leftChild;
			}

			if (righChild < max && visualizedArray[righChild].compareTo(visualizedArray[index]) > 0) {
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
	 * Build max heap from unordered array <br/>
	 * 1. find max element A[1] <br/>
	 * 2. swap element A[n] with A[1] <br/>
	 *     now the max element is at the end of array<br/>
	 * 3. discard node n from heap by decrementing heap size <br/>
	 * 4. new root may violate max heap property but the child are max
	 */
	public void buildMaxHeap() {
		// TODO Auto-generated method stub
		
	}

}
