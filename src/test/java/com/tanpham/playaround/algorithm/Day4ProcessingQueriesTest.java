package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

public class Day4ProcessingQueriesTest {

	@Test
	public void testCase01() {
		List<List<Integer>> requests = Arrays.asList(Arrays.asList(2, 9),
														Arrays.asList(4, 8),
														Arrays.asList(10, 9),
														Arrays.asList(15, 2),
														Arrays.asList(19, 1)
														);
		assertThat(Day4ProcessingQueries.getServerProcessedTime(requests, 1),
						Matchers.equalTo(new ArrayList<>(
								Arrays.asList(11, 19, -1, 21, 22))));
	}
	
}
