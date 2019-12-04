package com.tanpham.playaround.datastructure.heap;

public class MaxHeap<T> {
	private T[] arr;
	
	@SuppressWarnings("unchecked")
	public MaxHeap() {
		arr = (T[]) new Object[32];
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
		int halfLength = arr.length/2;
		for (int i = halfLength; i >= 0; i--) {
			maxHeapify(arr, i);
		}
	}

	/**
	 * Correct the subtree at position
	 * @param atPosition
	 */
	private void maxHeapify(T[] visualizedArray, int atPosition) {
//		visualizedArray[atPosition].getValue().equals(obj)
//		if (visualizedArray[atPosition].getValue()) {
//			
//		}
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
