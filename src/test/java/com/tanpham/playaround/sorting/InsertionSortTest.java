package com.tanpham.playaround.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest {

	private InsertionSort insertionSort;
	
	@Before
	public void init() {
		insertionSort = new InsertionSort();
	}
	
	@Test
	public void happyPath() {
		int[] arr = new int[] {7, 3, 9, 5};
		insertionSort.proceed(arr);
		
		assertThat(arr, Matchers.equalTo(new int[] {3, 5, 7, 9}));
	}
	
	@Test
	public void happyPath__2() {
		int[] arr = new int[] {7, 3, 9, 5, 1, 8, 100, 50, 46, 25};
		insertionSort.proceed(arr);
		
		assertThat(arr, Matchers.equalTo(new int[] {1, 3, 5, 7, 8, 9, 25, 46, 50, 100}));
	}
	
	@Test
	public void happyPath__onlyOneItemInInputArray() {
		int[] arr = new int[] {7};
		insertionSort.proceed(arr);
		
		assertThat(arr, Matchers.equalTo(new int[] {7}));
	}
	
	@Test
	public void happyPath__nullArray() {
		insertionSort.proceed(null);
	}
}
