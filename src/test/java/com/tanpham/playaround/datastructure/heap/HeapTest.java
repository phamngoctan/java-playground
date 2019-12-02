package com.tanpham.playaround.datastructure.heap;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

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
	 *         
	 */
	@Test
	public void maxHeapify__happyPath() {
//		heap.getRoot().setLeftChild(leftChild);
		heap.heapify();
		assertThat("temp", Matchers.equalTo(""));
	}
	
}
