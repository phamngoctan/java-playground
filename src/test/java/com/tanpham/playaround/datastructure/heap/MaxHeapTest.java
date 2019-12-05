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
	 *                16                           16       
	 *             /     \        -->           /     \     
	 *            4       10                   14      10   
	 *          /   \     / \                /   \     / \  
	 *         14    7   9   3              8     7   9   3 
	 *       /   \   /                    /   \   /         
	 *      2     8 1                    2     4 1          
	 */
	@Test
	public void maxHeapify__happyPath() {
		Integer[] inputArr = new Integer[] {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		heap.setArr(inputArr).buildMaxHeap();
		
		Integer[] expectedArr = new Integer[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		assertThat(inputArr, Matchers.equalTo(expectedArr));
	}
	
	/*
	 *                14
	 *             /     \
	 *            4       8
	 */
	@Test
	public void buildMaxHeap__doNothing_itIsAlreadyAMaxHeap() {
		Integer[] inputArr = new Integer[] {14, 4, 8};
		heap.setArr(inputArr).buildMaxHeap();
		
		assertThat(heap.getArr(), Matchers.equalTo(new Integer[] {14, 4, 8}));
	}
	
	/*
	 *                8
	 *             /     \
	 *            4       14
	 */
	@Test
	public void buildMaxHeap__maxItemIsOnTheRightChild() {
		Integer[] inputArr = new Integer[] {8, 4, 14};
		heap.setArr(inputArr).buildMaxHeap();
		
		assertThat(heap.getArr(), Matchers.equalTo(new Integer[] {14, 4, 8}));
	}
	
	/*
	 *                4
	 *             /     \
	 *            14       8
	 */
	@Test
	public void buildMaxHeap__maxItemIsOnTheLeftChild() {
		Integer[] inputArr = new Integer[] {4, 14, 8};
		heap.setArr(inputArr).buildMaxHeap();
		
		assertThat(heap.getArr(), Matchers.equalTo(new Integer[] {14, 4, 8}));
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
	
	/*
	 *                14                   16      
	 *             /     \     -->      /     \    
	 *            4       10           14       10  
	 *          /   \     /          /   \     /   
	 *         16    2   8          4    2   8    
	 */
	@Test
	public void maxHeapify__anotherHappyCase() {
		Integer[] inputArr = new Integer[] {14, 4, 10, 16, 2, 8};
		heap.setArr(inputArr).buildMaxHeap();
		
		Integer[] expectedArr = new Integer[] {16, 14, 10, 4, 2, 8};
		assertThat(heap.getArr(), Matchers.equalTo(expectedArr));
	}
	
	/*
	 *                14            14     
	 *             /     \  -->  /     \   
	 *            4       8     4       8  
	 *                         /
	 *                        1
	 */
	@Test
	public void insert__intoMaxHeap__thereIsNoChangeInsideTheHeap() {
		Integer[] inputArr = new Integer[] {14, 4, 8};
		heap.setArr(inputArr);
		
		heap.insert(1);
		
		Integer[] expectedArr = new Integer[] {14, 4, 8, 1};
		assertThat(heap.getArr(), Matchers.equalTo(expectedArr));
	}
	
}
