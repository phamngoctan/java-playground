package com.tanpham.playaround.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.tanpham.playaround.datastructure.Node;

public class MergeSortTest {
	
	private static final boolean INCREASING_ORDER = true;
	private static final boolean DECREASING_ORDER = !INCREASING_ORDER;
	private MergeSort<Integer> mergeSort;
	
	@Before
	public void init() {
		mergeSort = new MergeSort<>();
	}
	
	@Test
	public void mergeSort__nullHead() {
		assertThat(mergeSort.proceed(null), Matchers.nullValue());
	}
	
	@Test
	public void mergeSort__oneNode() {
		Node<Integer> head = new Node<>(10);
		assertThat(mergeSort.proceed(head).getValue(), Matchers.equalTo(10));
	}
	
	@Test
	public void mergeSort__twoNodesToFacilitateTheRecursiveCall() {
		Node<Integer> head = new Node<>(10);
		head.setNext(15);
		Node<Integer> proceededList = mergeSort.proceed(head);
		assertThat(proceededList.getValue(), Matchers.equalTo(15));
		assertThat(proceededList.getNext(), Matchers.equalTo(10));
	}
	
	@Test
	public void mergeSort__multipleNodes() {
		Node<Integer> head = new Node<>(10);
		head.setNext(20).setNext(5);
		Node<Integer> newHeadResult = mergeSort.proceed(head);
		assertThat(newHeadResult, Matchers.equalTo(20));
		assertThat(newHeadResult, Matchers.equalTo(10));
		assertThat(newHeadResult, Matchers.equalTo(5));
	}
	//TODO: add more test for mergeSort here
	
	//========================================
	// test the small part of the mergesort, merge two sorted list
	@Test
	public void mergeTwoSortedList__eachListOneItem() {
		Node<Integer> firstHead = new Node<>(5);
		Node<Integer> secondHead = new Node<>(10);
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedList(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(5));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(10));
	}
	
	@Test
	public void mergeTwoSortedList__eachListOneItem_nodeOfSecondOneSmaller() {
		Node<Integer> firstHead = new Node<>(10);
		Node<Integer> secondHead = new Node<>(5);
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedList(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(5));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(10));
	}
	
	@Test
	public void mergeTwoSortedList__firstListLongerThanSecondOne() {
		Node<Integer> firstHead = new Node<>(5);
		firstHead.setNext(new Node<>(15));
		Node<Integer> secondHead = new Node<>(10);
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedList(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(5));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(10));
		assertThat(sortedList.getNext().getNext().getValue(), Matchers.equalTo(15));
	}
	
	@Test
	public void mergeTwoSortedList__secondListLongerThanFirstOne() {
		Node<Integer> firstHead = new Node<>(5);
		firstHead.setNext(new Node<>(15));

		Node<Integer> secondHead = new Node<>(10);
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedList(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(5));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(10));
		assertThat(sortedList.getNext().getNext().getValue(), Matchers.equalTo(15));
	}
	
	//// Decreasing order test
	@Test
	public void mergeTwoSortedListDecreasingOrder__eachListOneItem() {
		Node<Integer> firstHead = new Node<>(5);
		Node<Integer> secondHead = new Node<>(10);
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedListDecreasingOrder(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(10));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(5));
	}
	
	@Test
	public void mergeTwoSortedListDecreasingOrder__eachListOneItem_nodeOfSecondOneSmaller() {
		Node<Integer> firstHead = new Node<>(10);
		Node<Integer> secondHead = new Node<>(5);
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedListDecreasingOrder(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(10));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(5));
	}
	
	@Test
	public void mergeTwoSortedListDecreasingOrder__firstListLongerThanSecondOne() {
		Node<Integer> firstHead = new Node<>(15);
		firstHead.setNext(new Node<>(5));
		Node<Integer> secondHead = new Node<>(10);
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedListDecreasingOrder(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(15));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(10));
		assertThat(sortedList.getNext().getNext().getValue(), Matchers.equalTo(5));
	}
	
	@Test
	public void mergeTwoSortedListDecreasingOrder__secondListLongerThanFirstOne() {
		Node<Integer> firstHead = new Node<>(10);
		Node<Integer> secondHead = new Node<>(15);
		firstHead.setNext(new Node<>(5));
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedListDecreasingOrder(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(15));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(10));
		assertThat(sortedList.getNext().getNext().getValue(), Matchers.equalTo(5));
	}
	
	@Test
	public void mergeTwoSortedListDecreasingOrder__pointerShouldSkipTheFirstNodeTwice__inTheFirstPosition() {
		Node<Integer> firstHead = new Node<>(5);
		Node<Integer> secondHead = new Node<>(15);
		secondHead.setNext(new Node<>(10));
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedListDecreasingOrder(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(15));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(10));
		assertThat(sortedList.getNext().getNext().getValue(), Matchers.equalTo(5));
	}
	
	/// complete new approach
	@Test
	public void mergeTwoSortedList__nullInput() {
		assertThat(mergeSort.mergeTwoSortedList(null, null), Matchers.nullValue());
	}
	
	/*
	 * 
	 *           ^
	 * 5    15   |
	 * x
	 * 
	 */
	@Test
	public void shouldPickFirstItem__secondBigger_increaseOrder() {
		boolean shouldPickFirstItem = mergeSort.shouldPickFirstItem(new Node<>(5), new Node<>(15), INCREASING_ORDER);
		assertThat(shouldPickFirstItem, Matchers.equalTo(true));
	}

	/*
	 * 
	 *           
	 * 5    15   |
	 * x         v
	 * 
	 */
	@Test
	public void shouldPickFirstItem__secondBigger_decreaseOrder() {
		boolean shouldPickFirstItem = mergeSort.shouldPickFirstItem(new Node<>(5), new Node<>(15), DECREASING_ORDER);
		assertThat(shouldPickFirstItem, Matchers.equalTo(false));
	}
	
	/*
	 * 
	 *           ^
	 * 15    5   |
	 *       x
	 * 
	 */
	@Test
	public void shouldPickFirstItem__firstBigger_increaseOrder() {
		boolean shouldPickFirstItem = mergeSort.shouldPickFirstItem(new Node<>(15), new Node<>(5), INCREASING_ORDER);
		assertThat(shouldPickFirstItem, Matchers.equalTo(false));
	}

	/*
	 * 
	 *           
	 * 15    5   |
	 * x         v
	 * 
	 */
	@Test
	public void shouldPickFirstItem__firstBigger_decreaseOrder() {
		boolean shouldPickFirstItem = mergeSort.shouldPickFirstItem(new Node<>(15), new Node<>(5), DECREASING_ORDER);
		assertThat(shouldPickFirstItem, Matchers.equalTo(true));
	}
	
	/*
	 * 
	 *             ^
	 * 5    null   |
	 * x
	 * 
	 */
	@Test
	public void shouldPickFirstItem__secondNull_increaseOrder() {
		boolean shouldPickFirstItem = mergeSort.shouldPickFirstItem(new Node<>(5), null, INCREASING_ORDER);
		assertThat(shouldPickFirstItem, Matchers.equalTo(true));
	}

	/*
	 * 
	 *           
	 * 5    null   |
	 * x           v
	 * 
	 */
	@Test
	public void shouldPickFirstItem__secondNull_decreaseOrder() {
		boolean shouldPickFirstItem = mergeSort.shouldPickFirstItem(new Node<>(5), null, DECREASING_ORDER);
		assertThat(shouldPickFirstItem, Matchers.equalTo(true));
	}
	
	/*
	 * 
	 *             ^
	 * null    5   |
	 *         x
	 * 
	 */
	@Test
	public void shouldPickFirstItem__firstNull_increaseOrder() {
		boolean shouldPickFirstItem = mergeSort.shouldPickFirstItem(null, new Node<>(5), INCREASING_ORDER);
		assertThat(shouldPickFirstItem, Matchers.equalTo(false));
	}

	/*
	 * 
	 *           
	 * null    5   |
	 *         x   v
	 * 
	 */
	@Test
	public void shouldPickFirstItem__firstNull_decreaseOrder() {
		boolean shouldPickFirstItem = mergeSort.shouldPickFirstItem(null, new Node<>(5), DECREASING_ORDER);
		assertThat(shouldPickFirstItem, Matchers.equalTo(false));
	}
	
	// =================
	// For support the mergeSort, we have to split it into two parts
	// To do it, we need to find the middle item of linkedlist
	
	@Test
	public void findMiddleItem__nullHead() {
		Node<Integer> middleItem = mergeSort.findMiddleItem(null);
		
		assertThat(middleItem, Matchers.equalTo(null));
	}
	
	@Test
	public void findMiddleItem__oneItem() {
		Node<Integer> inputHead = new Node<Integer>(10);
		Node<Integer> middleItem = mergeSort.findMiddleItem(inputHead);
		
		assertThat(middleItem.getValue(), Matchers.equalTo(10));
	}
	
	/*
	 * 10 -> 5
	 */
	@Test
	public void findMiddleItem__twoItems() {
		Node<Integer> inputHead = new Node<Integer>(10);
		inputHead.setNext(5);
		Node<Integer> middleItem = mergeSort.findMiddleItem(inputHead);
		
		assertThat(middleItem.getValue(), Matchers.equalTo(10));
	}
	
	/*
	 * 10 -> 5 -> 20
	 */
	@Test
	public void findMiddleItem__threeItems() {
		Node<Integer> inputHead = new Node<Integer>(10);
		inputHead.setNext(5).setNext(20);
		Node<Integer> middleItem = mergeSort.findMiddleItem(inputHead);
		
		assertThat(middleItem.getValue(), Matchers.equalTo(5));
	}
	
	/*
	 * 10 -> 5 -> 20 -> 11
	 */
	@Test
	public void findMiddleItem__fourItems() {
		Node<Integer> inputHead = new Node<Integer>(10);
		inputHead.setNext(5).setNext(20).setNext(11);
		Node<Integer> middleItem = mergeSort.findMiddleItem(inputHead);
		
		assertThat(middleItem.getValue(), Matchers.equalTo(5));
	}
	
	/*
	 * 10 -> 5 -> 20 -> 11 -> 18
	 */
	@Test
	public void findMiddleItem__fiveItems() {
		Node<Integer> inputHead = new Node<Integer>(10);
		inputHead.setNext(5).setNext(20).setNext(11).setNext(18);
		Node<Integer> middleItem = mergeSort.findMiddleItem(inputHead);
		
		assertThat(middleItem.getValue(), Matchers.equalTo(20));
	}
	
	/*
	 * 10 -> 5 -> 20 -> 11 -> 18 -> 25
	 */
	@Test
	public void findMiddleItem__sixItems() {
		Node<Integer> inputHead = new Node<Integer>(10);
		inputHead.setNext(5).setNext(20).setNext(11).setNext(18).setNext(25);
		Node<Integer> middleItem = mergeSort.findMiddleItem(inputHead);
		
		assertThat(middleItem.getValue(), Matchers.equalTo(20));
	}
}
