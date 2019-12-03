package com.tanpham.playaround.datastructure.heap;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.tanpham.playaround.datastructure.binarytree.TreeNode;

public class HeapTest {

	private Heap<Integer> heap;
	
	@Before
	public void init() {
		heap = new Heap<>();
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
		heap.setRoot(new TreeNode<>(16));
		heap.getRoot().addLeftChild(4);
		heap.getRoot().getLeftChild().addLeftChild(14);
		heap.getRoot().getLeftChild().getLeftChild().addLeftChild(2);
		heap.getRoot().getLeftChild().getLeftChild().addRightChild(8);
		heap.getRoot().getLeftChild().addRightChild(7);
		heap.getRoot().addRightChild(10);
		heap.getRoot().getRightChild().addLeftChild(9);
		heap.getRoot().getRightChild().addRightChild(3);
		
		heap.heapify();
		assertThat("temp", Matchers.equalTo(""));
	}
	
	@Test
	public void buildMaxHeap__happyPath() {
		heap.buildMaxHeap();
		assertThat("temp", Matchers.equalTo(""));
	}
	
}
