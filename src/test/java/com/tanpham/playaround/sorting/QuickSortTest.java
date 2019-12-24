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
	public void quickSort__happyPath() {
		int[] arr = new int[] {1, 2, 7, 8, 5, 9, 4, 15, 25};
		quickSort.proceed(arr);
		
		assertThat(arr, Matchers.equalTo(new int[] {1, 2, 4, 5, 7, 8, 9, 15, 25}));
	}
	
	@Test
	public void quickSort__inReverseOrder() {
		int[] arr = new int[] {25, 15, 9, 5, 8, 7, 4, 2, 1};
		quickSort.proceed(arr);
		
		assertThat(arr, Matchers.equalTo(new int[] {1, 2, 4, 5, 7, 8, 9, 15, 25}));
	}
	
	@Test
	public void quickSort__inCorrectOrder() {
		int[] arr = new int[] {1, 2, 4, 5, 7, 8, 9, 15, 25};
		quickSort.proceed(arr);
		
		assertThat(arr, Matchers.equalTo(new int[] {1, 2, 4, 5, 7, 8, 9, 15, 25}));
	}
	
	@Test
	public void quickSort__1Million() {
		int million = 1000000;
		int[] arr = new int[million];
		int[] expectedResult = new int[million];
		for (int i = 0; i < million; i++) {
			arr[i] = i;
			expectedResult[i] = i;
		}
		QuickSort.shuffleArray(arr);
		
		quickSort.proceed(arr);
		
		assertThat(arr, Matchers.equalTo(expectedResult));
	}
	
	@Test
	public void partition__inCaseBiggestValueAtFirst_theReturnShouldBeOnLastPosition() {
		int[] arr = new int[] {15, 4, 8, 2};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		assertThat(nextPartitionPoint, Matchers.equalTo(3));
		assertThat(arr, Matchers.equalTo(new int[] {2, 4, 8, 15}));
	}
	
	@Test
	public void partition__inCaseSmallestValueAtFirst_theReturnedValueShouldBeOnFirstPosition() {
		int[] arr = new int[] {2, 15, 4, 8};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		assertThat(nextPartitionPoint, Matchers.equalTo(0));
		
		makeSureNoChangeInTheOriginalArray(new int[] {2, 15, 4, 8}, arr);
	}
	
	private void makeSureNoChangeInTheOriginalArray(int[] originalArr, int[] arr) {
		assertThat(originalArr, Matchers.equalTo(arr));
	}

	@Test
	public void partition__exchangeInternalPoint() {
		int[] arr = new int[] {5, 6, 3, 2};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		
		assertThat(nextPartitionPoint, Matchers.equalTo(2));
		assertThat(arr, Matchers.equalTo(new int[] {3, 2, 5, 6}));
	}
	
	@Test
	public void partition__inCaseTheInputAlreadySorted() {
		int[] arr = new int[] {2, 5, 8, 11};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		
		assertThat(nextPartitionPoint, Matchers.equalTo(0));
		assertThat(arr, Matchers.equalTo(new int[] {2, 5, 8, 11}));
	}
	
	@Test
	public void partition__inCaseTheInputIsReverted() {
		int[] arr = new int[] {11, 8, 5, 2};
		int nextPartitionPoint = quickSort.partition(arr, 0, 3);
		
		assertThat(nextPartitionPoint, Matchers.equalTo(3));
		assertThat(arr, Matchers.equalTo(new int[] {2, 8, 5, 11}));
	}
	
	@Test
	public void partition__partitionPointIsThirdLargestValue() {
		int[] arr = new int[] {7, 8, 5, 9, 4};
		int nextPartitionPoint = quickSort.partition(arr, 0, 4);
		
		assertThat(nextPartitionPoint, Matchers.equalTo(2));
		assertThat(arr, Matchers.equalTo(new int[] {5, 4, 7, 9, 8}));
	}
	
	@Test
	public void partition__whenThereAreOtherItemsOutOfTheInput_itShouldNotBeTouched() {
		int[] arr = new int[] {1, 2, 7, 8, 5, 9, 4, 15, 25};
		int nextPartitionPoint = quickSort.partition(arr, 2, 6);
		
		assertThat(nextPartitionPoint, Matchers.equalTo(4));
		assertThat(arr, Matchers.equalTo(new int[] {1, 2, 5, 4, 7, 9, 8, 15, 25}));
	}
	
}
