package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

public class Day4ThatIsYourQueueTest {

	@Test
	public void testCase01() {
		List<Integer> patientOrders = Day4ThatIsYourQueue.patientOrders(3, Arrays.asList("N", "N", "E 1", "N", "N", "N"));
		assertThat(patientOrders, Matchers.equalTo(Arrays.asList(1, 2, 1, 3, 2)));
	}
	
	@Test
	public void testCase02() {
		List<Integer> patientOrders = Day4ThatIsYourQueue.patientOrders(10, Arrays.asList("N", "N"));
		assertThat(patientOrders, Matchers.equalTo(Arrays.asList(1, 2)));
	}
	
}
