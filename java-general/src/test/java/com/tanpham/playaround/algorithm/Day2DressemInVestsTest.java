package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tanpham.playaround.algorithm.Day2DressemInVests.Pair;

public class Day2DressemInVestsTest {
	
	@Test
	public void testCase01() {
		int[] soldierArr = new int[] {1, 2, 3, 3, 4};
		int[] vestArr = new int[] {1, 3, 5};
		List<Pair> result = Day2DressemInVests.check(soldierArr, vestArr, 0, 0);
		assertThat(result.size(), Matchers.equalTo(2));
		assertThat(result.get(0).getSolderNumber(), Matchers.equalTo(1));
		assertThat(result.get(0).getVestNumber(), Matchers.equalTo(1));
		assertThat(result.get(1).getSolderNumber(), Matchers.equalTo(3));
		assertThat(result.get(1).getVestNumber(), Matchers.equalTo(2));
	}
	
	@Test
	public void testCase02() {
		int[] soldierArr = new int[] {1, 5, 9};
		int[] vestArr = new int[] {3, 5, 7};
		List<Pair> result = Day2DressemInVests.check(soldierArr, vestArr, 2, 2);
		assertThat(result.size(), Matchers.equalTo(3));
		assertThat(result.get(0).getSolderNumber(), Matchers.equalTo(1));
		assertThat(result.get(0).getVestNumber(), Matchers.equalTo(1));
		assertThat(result.get(1).getSolderNumber(), Matchers.equalTo(2));
		assertThat(result.get(1).getVestNumber(), Matchers.equalTo(2));
		assertThat(result.get(2).getSolderNumber(), Matchers.equalTo(3));
		assertThat(result.get(2).getVestNumber(), Matchers.equalTo(3));
	}

}
