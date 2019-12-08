package com.tanpham.playaround.datastructure.heap;

import static org.junit.Assert.assertThat;

import java.util.stream.IntStream;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MaxHeapTest {

	private static final Integer[] EMPTY_ARRAY = new Integer[] {};
	private MaxHeap<Integer> heap;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
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
		heap.initWith(16, 4, 10, 14, 7, 9, 3, 2, 8, 1).buildMaxHeap();
		makeSureArrayEquals(heap.getArr(), new Integer[] {16, 14, 10, 8, 7, 9, 3, 2, 4, 1});
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
		heap.initWith(14, 4, 8).buildMaxHeap();
		
		makeSureArrayEquals(heap.getArr(), new Integer[] {14, 4, 8});
	}
	
	/*
	 *                8
	 *             /     \
	 *            4       14
	 */
	@Test
	public void buildMaxHeap__maxItemIsOnTheRightChild() {
		heap.initWith(8, 4, 14).buildMaxHeap();
		
		makeSureArrayEquals(heap.getArr(), new Integer[] {14, 4, 8});
	}
	
	/*
	 *                4
	 *             /     \
	 *            14       8
	 */
	@Test
	public void buildMaxHeap__maxItemIsOnTheLeftChild() {
		heap.initWith(4, 14, 8).buildMaxHeap();
		
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
		heap.initWith(14, 4, 10, 16, 2, 8).maxHeapify(1);
		
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
		heap.initWith(14, 4, 8, 1, 2, 19).maxHeapify(0);
		
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
		heap.initWith(14, 4, 10, 16, 2, 8).buildMaxHeap();
		
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
		heap.initWith(14, 4, 8);
		
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
		heap.initWith(14, 4, 8);
		
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
		heap.initWith(14, 4, 8);
		
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
	
	@Test
	public void size__emptyHeap() {
		assertThat(heap.size(), Matchers.equalTo(0));
	}
	
	@Test
	public void size__oneItemHeap() {
		heap.insert(10);
		assertThat(heap.size(), Matchers.equalTo(1));
	}
	
	@Test
	public void size__manyItemsInside() {
		heap.insert(18);
		heap.insert(12);
		assertThat(heap.size(), Matchers.equalTo(2));
	}
	
	@Test
	public void size__makeSureInitWithArrayOfItemsShouldIncreaseTheSize() {
		heap.initWith(1, 2, 3, 4, 5, 6);
		assertThat(heap.size(), Matchers.equalTo(6));
	}
	
	@Test
	public void isEmpty__emptyHeap() {
		assertThat(heap.isEmpty(), Matchers.equalTo(true));
	}
	
	@Test
	public void isEmpty__oneItemHeap() {
		heap.insert(10);
		assertThat(heap.isEmpty(), Matchers.equalTo(false));
	}
	
	@Test
	public void isEmpty__manyItemsInside() {
		heap.insert(18);
		heap.insert(12);
		assertThat(heap.isEmpty(), Matchers.equalTo(false));
	}
	
	@Test
	public void isEmpty__makeSureInitWithArrayOfItemsShouldIncreaseTheSize() {
		heap.initWith(1, 2, 3, 4, 5, 6);
		assertThat(heap.isEmpty(), Matchers.equalTo(false));
	}
	
	@Test
	public void getMax__emptyHeap() {
		assertThat(heap.getMax(), Matchers.nullValue());
	}
	
	@Test
	public void getMax__oneItem() {
		heap.insert(1);
		assertThat(heap.getMax(), Matchers.equalTo(1));
	}
	
	@Test
	public void getMax__twoItemsWithoutBeingHeapified__shouldDeliverWrongResult() {
		heap.initWith(10, 15);
		assertThat(heap.getMax(), Matchers.equalTo(10));
	}
	
	@Test
	public void getMax__twoItemsBeingHeapified__shouldDeliverWrongResult() {
		heap.initWith(10, 15).buildMaxHeap();
		assertThat(heap.getMax(), Matchers.equalTo(15));
	}
	
	@Test
	public void extractMax__emptyHeap() {
		assertThat(heap.extractMax(), Matchers.nullValue());
	}
	
	@Test
	public void extractMax__oneItemHeap() {
		heap.insert(10);
		assertThat(heap.extractMax(), Matchers.equalTo(10));
		assertThat(heap.size(), Matchers.equalTo(0));
		assertThat(heap.isEmpty(), Matchers.equalTo(true));
		makeSureArrayEquals(heap.getArr(), EMPTY_ARRAY);
	}
	
	/*
	 *         16                          14      
	 *      /     \        -->          /     \    
	 *     14       10                 8       10 
	 *   /   \     /                 /   \   
	 *  4    2   8                  4     2      
	 */
	@Test
	public void extractMax__deletedItemIsOnTheLeftChild() {
		heap.initWith(16, 14, 10, 4, 2, 8).buildMaxHeap();
		assertThat(heap.extractMax(), Matchers.equalTo(16));
		assertThat(heap.size(), Matchers.equalTo(5));
		makeSureArrayEquals(heap.getArr(), new Integer[] {14, 8, 10, 4, 2});
	}
	
	/*
	 *         16        
	 *      /     \      
	 *     14       10   
	 *   /   \     /     
	 *  4    2   8       
	 */
	@Test
	public void extractMax__toTheVeryEndOfHeap() {
		heap.initWith(16, 14, 10, 4, 2, 8).buildMaxHeap();
		assertThat(heap.extractMax(), Matchers.equalTo(16));
		assertThat(heap.size(), Matchers.equalTo(5));
		
		assertThat(heap.extractMax(), Matchers.equalTo(14));
		assertThat(heap.size(), Matchers.equalTo(4));

		assertThat(heap.extractMax(), Matchers.equalTo(10));
		assertThat(heap.size(), Matchers.equalTo(3));

		assertThat(heap.extractMax(), Matchers.equalTo(8));
		assertThat(heap.size(), Matchers.equalTo(2));
		
		assertThat(heap.extractMax(), Matchers.equalTo(4));
		assertThat(heap.size(), Matchers.equalTo(1));

		assertThat(heap.extractMax(), Matchers.equalTo(2));
		assertThat(heap.size(), Matchers.equalTo(0));
		assertThat(heap.isEmpty(), Matchers.equalTo(true));
		
		makeSureArrayEquals(heap.getArr(), EMPTY_ARRAY);
	}
	
	@Test
	public void remove__emptyHeap() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Cannot trigger the removing at position 0 because the heap is empty");
		heap.remove(0);
	}
	
	@Test
	public void remove__negativePosition() {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Negative position -1 is not accepted");
		heap.remove(-1);
	}
	
	@Test
	public void remove__outOfScopePosition() {
		heap.insert(10);
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Cannot trigger the removing at position 1 because the heap size is just only 0");
		heap.remove(1);
	}
	
	@Test
	public void remove__oneItemHeap() {
		heap.insert(10);
		
		assertThat(heap.remove(0), Matchers.equalTo(10));
		assertThat(heap.isEmpty(), Matchers.equalTo(true));
	}

	@Test
	public void remove__twoItemsHeap() {
		heap.insert(10);
		heap.insert(20);
		assertThat(heap.remove(1), Matchers.equalTo(10));
		assertThat(heap.size(), Matchers.equalTo(1));
		makeSureArrayEquals(heap.getArr(), new Integer[] {20});
	}
	
	@Test
	public void remove__untilTheLastItemOfTheHeap() {
		heap.initWith(10, 100, 50, 35, 90).buildMaxHeap();
		
		assertThat(heap.remove(0), Matchers.equalTo(100));
		assertThat(heap.remove(0), Matchers.equalTo(90));
		assertThat(heap.remove(0), Matchers.equalTo(50));
		assertThat(heap.remove(0), Matchers.equalTo(35));
		assertThat(heap.remove(0), Matchers.equalTo(10));
		
		assertThat(heap.isEmpty(), Matchers.equalTo(true));
		makeSureArrayEquals(heap.getArr(), EMPTY_ARRAY);
	}
	
}
