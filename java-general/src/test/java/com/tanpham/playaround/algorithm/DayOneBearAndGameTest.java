package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayOneBearAndGameTest {

	@Test
	public void noBoringTimeMeansNoInputBoringTime() {
		assertThat(Day1BearAndGame.calculateBearWatchingTime(new int[] {}), Matchers.equalTo(90));
	}
	
	@Test
	public void noBoringTimeMeansNoInputBoringTime__nullInput() {
		assertThat(Day1BearAndGame.calculateBearWatchingTime(null), Matchers.equalTo(90));
	}
	
	@Test
	public void onlyOneBoringTime__beforeMinute15th() {
		assertThat(Day1BearAndGame.calculateBearWatchingTime(new int[] {10}), Matchers.equalTo(90));
	}
	
	@Test
	public void onlyOneBoringTime__inMinute15th() {
		assertThat(Day1BearAndGame.calculateBearWatchingTime(new int[] {15}), Matchers.equalTo(90));
	}
	
	@Test
	public void onlyOneBoringTime__afterMinute15th() {
		assertThat(Day1BearAndGame.calculateBearWatchingTime(new int[] {19}), Matchers.equalTo(15));
	}
	
	@Test
	public void manyBoringTimes__1() {
		assertThat(Day1BearAndGame.calculateBearWatchingTime(new int[] {7, 20, 88}), Matchers.equalTo(35));
	}
	
	@Test
	public void manyBoringTimes__2() {
		assertThat(Day1BearAndGame.calculateBearWatchingTime(new int[] {16, 20, 30, 40, 50, 60, 70, 80, 90}), Matchers.equalTo(15));
	}
	
	@Test
	public void manyBoringTimes__3() {
		assertThat(Day1BearAndGame.calculateBearWatchingTime(new int[] {15, 20, 30, 40, 50, 60, 70, 80, 90}), Matchers.equalTo(90));
	}
	
	@Test
	public void manyBoringTimes__4() {
		assertThat(Day1BearAndGame.calculateBearWatchingTime(new int[] {14, 29, 44, 59, 73}), Matchers.equalTo(88));
	}
	
}
