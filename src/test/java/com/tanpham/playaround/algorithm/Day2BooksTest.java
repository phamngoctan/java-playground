package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class Day2BooksTest {

	@Test
	public void testCase01() {
		int[] arr = new int[] {3, 1, 2, 1};
		assertThat(Day2Books.getNumberOfCanBeReadBooks(arr, 5), Matchers.equalTo(3));
	}
	
	@Test
	public void testCase02() {
		int[] arr = new int[] {2, 2, 3};
		assertThat(Day2Books.getNumberOfCanBeReadBooks(arr, 3), Matchers.equalTo(1));
	}
	
	@Test
	public void testCase03() {
		int[] arr = new int[] {2, 5, 6, 25, 22, 21, 7, 9, 7, 22, 25, 25, 22, 24, 27, 26, 12, 22, 28, 27, 27, 9, 8, 1, 29, 6, 20, 18, 28, 16, 20, 23, 23, 9, 1, 10, 15, 18, 21, 30, 7, 18, 4, 28, 6, 5, 21, 10, 22, 5, 21, 27, 17, 4, 21, 4, 25, 4, 5, 30, 21, 5, 21, 12, 25, 1, 2, 23, 26, 22};
		assertThat(Day2Books.getNumberOfCanBeReadBooks(arr, 200), Matchers.equalTo(15));
	}
	
}
