package com.tanpham.playaround.searching;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DataStructureSearchingTest {

	@Test
	public void binarySearchRecursive__nullArray() {
		assertThat(DataStructureSearching.binarySearchRecursive(null, 10), Matchers.equalTo(false));
	}
	
	@Test
	public void binarySearchRecursive__emptyArray() {
		assertThat(DataStructureSearching.binarySearchRecursive(new int[] {}, 10), Matchers.equalTo(false));
	}

	@Test
	public void binarySearchRecursive__itemIsInLatterPart() {
		int[] arr = new int[] {1, 5, 10, 20, 50, 70, 100};
		int toBeSearched = 70;
		assertThat(DataStructureSearching.binarySearchRecursive(arr, toBeSearched), Matchers.equalTo(true));
	}
	
	@Test
	public void binarySearchRecursive__itemIsInFirstPart() {
		int[] arr = new int[] {1, 5, 10, 20, 50, 70, 100};
		int toBeSearched = 5;
		assertThat(DataStructureSearching.binarySearchRecursive(arr, toBeSearched), Matchers.equalTo(true));
	}
	
	@Test
	public void binarySearchRecursive__itemNotFound() {
		int[] arr = new int[] {1, 5, 10, 20, 50, 70, 100};
		int toBeSearched = 6;
		assertThat(DataStructureSearching.binarySearchRecursive(arr, toBeSearched), Matchers.equalTo(false));
	}
	
	// Binary search using approach without recursive
	@Test
	public void binarySearch__nullArray() {
		assertThat(DataStructureSearching.binarySearch(null, 10), Matchers.equalTo(false));
	}
	
	@Test
	public void binarySearch__emptyArray() {
		assertThat(DataStructureSearching.binarySearch(new int[] {}, 10), Matchers.equalTo(false));
	}

	@Test
	public void binarySearch__itemIsInLatterPart() {
		int[] arr = new int[] {1, 5, 10, 20, 50, 70, 100};
		int toBeSearched = 70;
		assertThat(DataStructureSearching.binarySearch(arr, toBeSearched), Matchers.equalTo(true));
	}
	
	@Test
	public void binarySearch__itemIsInFirstPart() {
		int[] arr = new int[] {1, 5, 10, 20, 50, 70, 100};
		int toBeSearched = 5;
		assertThat(DataStructureSearching.binarySearch(arr, toBeSearched), Matchers.equalTo(true));
	}
	
	@Test
	public void binarySearch__itemNotFound() {
		int[] arr = new int[] {1, 5, 10, 20, 50, 70, 100};
		int toBeSearched = 6;
		assertThat(DataStructureSearching.binarySearch(arr, toBeSearched), Matchers.equalTo(false));
	}
	
}
