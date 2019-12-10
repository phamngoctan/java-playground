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
	
}
