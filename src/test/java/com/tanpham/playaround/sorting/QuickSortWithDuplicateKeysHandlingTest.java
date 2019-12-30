package com.tanpham.playaround.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class QuickSortWithDuplicateKeysHandlingTest {
	
	private QuickSortWithDuplicateKeysHandling quickSort;
	
	@Before
	public void init() {
		quickSort = new QuickSortWithDuplicateKeysHandling();
	}
	
	/*
	 * initiating:
	 * i
	 * lt              gt
	 * [5, 3, 8, 6, 1, 9]
	 * 
	 * first loop: no exchange, just increase i
	 * lt  i           gt
	 * [5, 3, 8, 6, 1, 9]
	 * 
	 * second loop: exchange 5, 3, increase both i & lt
	 *     lt i        gt
	 * [3, 5, 8, 6, 1, 9]
	 * 
	 * third loop: exchange 8, 9, decrease gt
	 *     lt i     gt
	 * [3, 5, 9, 6, 1, 8]
	 * 
	 * forth loop: exchange 9, 1, decrease gt
	 *     lt i  gt   
	 * [3, 5, 1, 6, 9, 8]
	 * 
	 * fifth loop: exchange 5, 1, increase both i & lt
	 *           i
	 *       lt  gt   
	 * [3, 1, 5, 6, 9, 8]
	 * 
	 * sixth loop: exchange 6, 6 decrease gt
	 *       gt  i
	 *       lt     
	 * [3, 1, 5, 6, 9, 8]
	 * 
	 * gt > i ==> stop while
	 * 
	 */
	@Test
	public void withoutDuplicatedKeys__butTheEndItemIsLargest__itDoesNotMatter() {
		int[] arr = new int[] {5, 3, 8, 6, 1, 9};
		int nextPoint = quickSort.partition(arr, 0, 5);
		
		assertThat(nextPoint, Matchers.equalTo(2));
		assertThat(arr, Matchers.equalTo(new int[] {3, 1, 5, 6, 9, 8}));
	}
	
}
