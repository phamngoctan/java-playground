package com.tanpham.playaround.sorting;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.tanpham.playaround.sorting.QuickSortWithDuplicateKeysHandling.NextBoundary;

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
		NextBoundary nextBoundary = quickSort.partition(arr, 0, 5);
		
		assertThat(nextBoundary.lowBoundary, Matchers.equalTo(1));
		assertThat(nextBoundary.highBoundary, Matchers.equalTo(3));
		assertThat(arr, Matchers.equalTo(new int[] {3, 1, 5, 6, 9, 8}));
	}
	
	/*
	 * initiating:
	 * i
	 * lt                       gt
	 * [5, 3, 7, 8, 6, 7, 9, 7, 10]
	 * 
	 * first loop:
	 *     i
	 * lt                       gt
	 * [5, 3, 7, 8, 6, 7, 9, 7, 10]
	 * 
	 * second loop:
	 *        i
	 *     lt                   gt
	 * [3, 5, 7, 8, 6, 7, 9, 7, 10]
	 * 
	 * third loop:
	 *        i
	 *     lt                 gt
	 * [3, 5, 10, 8, 6, 7, 9, 7, 7]
	 * 
	 * 4th loop:
	 *        i
	 *     lt                 gt
	 * [3, 5, 10, 8, 6, 7, 9, 7, 7]
	 * 
	 * 5th loop:
	 *        i
	 *     lt             gt
	 * [3, 5, 7, 8, 6, 7, 9, 10, 7]
	 * 
	 * 6th loop:
	 *        i
	 *     lt          gt
	 * [3, 5, 9, 8, 6, 7, 7, 10, 7]
	 * 
	 * 7th loop:
	 *        i
	 *     lt       gt
	 * [3, 5, 7, 8, 6, 9, 7, 10, 7]
	 * 
	 * 8th loop:
	 *        i
	 *     lt    gt
	 * [3, 5, 6, 8, 7, 9, 7, 10, 7]
	 * 
	 * 9th loop:
	 *        i
	 *     lt gt
	 * [3, 5, 8, 6, 7, 9, 7, 10, 7]
	 * 
	 * 10th loop: swap i, gt means 8 vs 8
	 *     gt i
	 *     lt 
	 * [3, 5, 8, 6, 7, 9, 7, 10, 7]
	 * 
	 * stop
	 * 
	 */
	@Test
	public void withDuplicatedKeys__butDuplicatedKeyIsNotTheComparedPoint() {
		int arr[] = new int[] {5, 3, 7, 8, 6, 7, 9, 7, 10};
		
		NextBoundary nextBoundary = quickSort.partition(arr, 0, 8);
		
		assertThat(nextBoundary.lowBoundary, Matchers.equalTo(0));
		assertThat(nextBoundary.highBoundary, Matchers.equalTo(2));	
		assertThat(arr, Matchers.equalTo(new int[] {3, 5, 8, 6, 7, 9, 7, 10, 7}));
	}
	
	/*
	 * initiating:
	 * i
	 * lt                       gt
	 * [7, 3, 5, 8, 6, 7, 9, 7, 10]
	 * 
	 * first loop: always increase i without changing anything :)
	 *     i
	 * lt                       gt
	 * [7, 3, 5, 8, 6, 7, 9, 7, 10]
	 * 
	 * 2nd loop:
	 *     i
	 * lt                       gt
	 * [7, 3, 5, 8, 6, 7, 9, 7, 10]
	 * 
	 * 3rd loop:
	 *        i
	 *     lt                   gt
	 * [3, 7, 5, 8, 6, 7, 9, 7, 10]
	 * 
	 * 4th loop:
	 *           i
	 *        lt                gt
	 * [3, 5, 7, 8, 6, 7, 9, 7, 10]
	 * 
	 * 5th loop:
	 *           i
	 *        lt              gt
	 * [3, 5, 7, 10, 6, 7, 9, 7, 8]
	 * 
	 * 6th loop: just increase i, no exchange needed
	 *              i
	 *        lt          gt
	 * [3, 5, 7, 7, 6, 7, 9, 10, 8]
	 * 
	 * 7th loop:
	 *                 i
	 *           lt       gt
	 * [3, 5, 6, 7, 7, 7, 9, 10, 8]
	 * 
	 * 8th loop: just increase i, no exchange needed
	 *                    i
	 *           lt       gt
	 * [3, 5, 6, 7, 7, 7, 9, 10, 8]
	 * 
	 * 9th loop: swap i vs gt means 9 vs 9, decrease gt
	 *                    i
	 *           lt    gt
	 * [3, 5, 6, 7, 7, 7, 9, 10, 8]
	 * 
	 * stop
	 * 
	 */
	@Test
	public void withDuplicatedKeys__duplicatedKeyIsTheComparedPoint() {
		int arr[] = new int[] {7, 3, 5, 8, 6, 7, 9, 7, 10};
		
		NextBoundary nextBoundary = quickSort.partition(arr, 0, 8);
		
		assertThat(nextBoundary.lowBoundary, Matchers.equalTo(2));
		assertThat(nextBoundary.highBoundary, Matchers.equalTo(6));	
		assertThat(arr, Matchers.equalTo(new int[] {3, 5, 6, 7, 7, 7, 9, 10, 8}));
	}
	
	@Test
	public void quickSort__proceed() {
		int arr[] = new int[] {7, 3, 5, 8, 6, 7, 9, 7, 10};
		
		quickSort.proceed(arr);
		assertThat(arr, Matchers.equalTo(new int[] {3, 5, 6, 7, 7, 7, 8, 9, 10}));
	}
	
	@Test
	public void quickSort__oneItem() {
		int arr[] = new int[] {7};
		
		quickSort.proceed(arr);
		assertThat(arr, Matchers.equalTo(new int[] {7}));
	}
	
	/*
	 * Nothing happens
	 */
	@Test
	public void quickSort__nullArr() {
		quickSort.proceed(null);
	}
	
}
