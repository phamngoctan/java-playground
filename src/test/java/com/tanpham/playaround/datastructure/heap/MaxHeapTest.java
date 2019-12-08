package com.tanpham.playaround.datastructure.heap;

import static org.junit.Assert.assertThat;

import java.util.stream.IntStream;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {

	private MaxHeap<Integer> heap;
	
	@Before
	public void init() {
		heap = new MaxHeap<>(Integer.class);
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
		heap.setArr(16, 4, 10, 14, 7, 9, 3, 2, 8, 1).buildMaxHeap();
		Integer[] expectedArr = new Integer[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		Integer[] actual = heap.getArr();
		makeSureArrayEquals(actual, expectedArr);
	}
	
	private void makeSureArrayEquals(Integer[] actual, Integer[] expected) {
		IntStream.range(0, expected.length).forEach(i -> {
			assertThat(String.format("Wrong value detected at position %s", i),
						actual[i], Matchers.equalTo(expected[i]));
		});
	}
	
	/*
	 *                14
	 *             /     \
	 *            4       8
	 */
	@Test
	public void buildMaxHeap__doNothing_itIsAlreadyAMaxHeap() {
		heap.setArr(14, 4, 8).buildMaxHeap();
		
		makeSureArrayEquals(heap.getArr(), new Integer[] {14, 4, 8});
	}
	
	/*
	 *                8
	 *             /     \
	 *            4       14
	 */
	@Test
	public void buildMaxHeap__maxItemIsOnTheRightChild() {
		heap.setArr(8, 4, 14).buildMaxHeap();
		
		makeSureArrayEquals(heap.getArr(), new Integer[] {14, 4, 8});
	}
	
	/*
	 *                4
	 *             /     \
	 *            14       8
	 */
	@Test
	public void buildMaxHeap__maxItemIsOnTheLeftChild() {
		heap.setArr(4, 14, 8).buildMaxHeap();
		
		makeSureArrayEquals(heap.getArr(), new Integer[] {14, 4, 8});
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
		heap.setArr(14, 4, 10, 16, 2, 8).maxHeapify(1);
		
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
		heap.setArr(14, 4, 8, 1, 2, 19).maxHeapify(0);
		
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
		heap.setArr(14, 4, 10, 16, 2, 8).buildMaxHeap();
		
		Integer[] expectedArr = new Integer[] {16, 14, 10, 4, 2, 8};
		makeSureArrayEquals(heap.getArr(), expectedArr);
	}
	
	/*
	 *                14            14     
	 *             /     \  -->  /     \   
	 *            4       8     4       8  
	 *                         /
	 *                        1
	 */
	@Test
	public void insert__intoMaxHeap__leftChildInserted__thereIsNoChangeInsideTheHeap() {
		heap.setArr(14, 4, 8);
		
		heap.insert(1);
		
		Integer[] expectedArr = new Integer[] {14, 4, 8, 1};
		makeSureArrayEquals(heap.getArr(), expectedArr);
	}
	
	/*
	 *                14            18     
	 *             /     \  -->  /     \   
	 *            4       8    14       8  
	 *                         /
	 *                        4
	 */
	@Test
	public void insert__intoMaxHeap__leftChildInserted__theRootIsChanged() {
		heap.setArr(14, 4, 8);
		
		heap.insert(18);
		
		Integer[] expectedArr = new Integer[] {18, 14, 8, 4};
		makeSureArrayEquals(heap.getArr(), expectedArr);
	}
	
	/*
	 *                14            14     
	 *             /     \  -->  /     \   
	 *            4       8     9       8  
	 *                         /
	 *                        4
	 */
	@Test
	public void insert__intoMaxHeap__leftChildInserted__theNodeAboveIsChanged() {
		heap.setArr(14, 4, 8);
		
		heap.insert(9);
		
		Integer[] expectedArr = new Integer[] {14, 9, 8, 4};
		makeSureArrayEquals(heap.getArr(), expectedArr);
	}
	
	@Test
	public void insert__completeTree_fromScratch() {
		heap.insert(19);
		heap.insert(29);
		heap.insert(1);
		heap.insert(40);
		makeSureArrayEquals(heap.getArr(), new Integer[] {40, 29, 1, 19});
	}
	
}
