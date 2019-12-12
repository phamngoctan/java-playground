package com.tanpham.playaround.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.tanpham.playaround.datastructure.Node;

public class MergeSortTest {
	
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
		Node<Integer> secondHead = new Node<>(10);
		firstHead.setNext(new Node<>(15));
		
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
		firstHead.setNext(new Node<>(10));
		Node<Integer> secondHead = new Node<>(15);
		
		Node<Integer> sortedList = mergeSort.mergeTwoSortedListDecreasingOrder(firstHead, secondHead);
		assertThat(sortedList, Matchers.notNullValue());
		assertThat(sortedList.getValue(), Matchers.equalTo(15));
		assertThat(sortedList.getNext().getValue(), Matchers.equalTo(10));
		assertThat(sortedList.getNext().getNext().getValue(), Matchers.equalTo(5));
	}
	
}
