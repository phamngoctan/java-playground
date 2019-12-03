package com.tanpham.playaround.datastructure.heap;

import com.tanpham.playaround.datastructure.binarytree.TreeNode;

public class Heap<T> {
	private TreeNode<T>[] arr;
	private TreeNode<T> root;
	
	@SuppressWarnings("unchecked")
	public Heap() {
		arr = new TreeNode[16];
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
	
	// TODO: add more method for the heap
	
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
	private void maxHeapify(TreeNode<T>[] visualizedArray, int atPosition) {
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
