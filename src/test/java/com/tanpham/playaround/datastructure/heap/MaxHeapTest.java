package com.tanpham.playaround.datastructure.heap;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {

	private MaxHeap<Integer> heap;
	
	@Before
	public void init() {
		heap = new MaxHeap<Integer>();
	}
	
	/*
	 *                16
	 *             /     \
	 *            4       10
	 *          /   \     / \
	 *         14    7   9   3
 	 *       /   \   /
	 *      2     8 1
	 */
	@Test
	public void maxHeapify__happyPath() {
//		heap.setRoot(new TreeNode<>(16));
//		heap.getRoot().addLeftChild(4);
//		heap.getRoot().getLeftChild().addLeftChild(14);
//		heap.getRoot().getLeftChild().getLeftChild().addLeftChild(2);
//		heap.getRoot().getLeftChild().getLeftChild().addRightChild(8);
//		heap.getRoot().getLeftChild().addRightChild(7);
//		heap.getRoot().addRightChild(10);
//		heap.getRoot().getRightChild().addLeftChild(9);
//		heap.getRoot().getRightChild().addRightChild(3);
		
		heap.heapify();
		assertThat("temp", Matchers.equalTo(""));
	}
	
	@Test
	public void buildMaxHeap__happyPath() {
		heap.buildMaxHeap();
		assertThat("temp", Matchers.equalTo(""));
	}
	
	/*
	 *                14
	 *             /     \
	 *            4       10
	 *          /   \     /
	 *         16    2   8
	 */
	@Test
	public void maxHeapify__atNodeWithTwoChildren_noMoreSubTree() {
		Integer[] inputArr = new Integer[] {14, 4, 10, 16, 2, 8};
		heap.setArr(inputArr).maxHeapify(inputArr, 1);
		
		Integer[] result = heap.getArr();
		assertThat(result[1], Matchers.equalTo(16));
	}
	
	/*
	 *                14
	 *             /     \
	 *            4       8
	 *          /   \     /
	 *         1     2   19
	 */
	@Test
	public void maxHeapify__heapifyTheRootButTheRightChildTreeIsNotHeapifiedYet() {
		Integer[] inputArr = new Integer[] {14, 4, 8, 1, 2, 19};
		heap.setArr(inputArr).maxHeapify(inputArr, 0);
		
		Integer[] result = heap.getArr();
		assertThat(result[0], Matchers.equalTo(14));
	}
	
}
