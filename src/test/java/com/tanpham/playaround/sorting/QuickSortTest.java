package com.tanpham.playaround.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

	private QuickSort quickSort;
	
	@Before
	public void init() {
		quickSort = new QuickSort();
	}
	
	@Test
	public void partition__inCaseBiggestValueAtFirst() {
		int[] arr = new int[] {15, 4, 8, 2};
		int partitionPoint = quickSort.partition(arr, 0, 3);
		assertThat(partitionPoint, Matchers.equalTo(0));
	}
	
}
