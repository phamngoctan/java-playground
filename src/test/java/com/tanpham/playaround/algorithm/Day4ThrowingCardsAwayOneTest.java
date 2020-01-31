package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.tanpham.playaround.algorithm.Day4ThrowingCardsAwayOne.Pair;

public class Day4ThrowingCardsAwayOneTest {

	@Test
	public void myTestCase01() {
		Pair result = Day4ThrowingCardsAwayOne.proceed(2);
		assertThat(result.remainingCard, Matchers.equalTo(2));
		assertThat(result.discardedCards, Matchers.equalTo(new ArrayList<>(Arrays.asList(1))));
	}
	
	@Test
	public void myTestCase02() {
		Pair result = Day4ThrowingCardsAwayOne.proceed(1);
		assertThat(result.remainingCard, Matchers.equalTo(1));
		assertThat(result.discardedCards, Matchers.equalTo(new ArrayList<>()));
	}
	
	@Test
	public void testCase01() {
		Pair result = Day4ThrowingCardsAwayOne.proceed(7);
		assertThat(result.remainingCard, Matchers.equalTo(6));
		assertThat(result.discardedCards, Matchers.equalTo(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 4, 2))));
	}
	
	@Test
	public void testCase02() {
		Pair result = Day4ThrowingCardsAwayOne.proceed(19);
		assertThat(result.remainingCard, Matchers.equalTo(6));
		assertThat(result.discardedCards, Matchers.equalTo(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 4, 8, 12, 16, 2, 10, 18, 14))));
	}
	
	@Test
	public void testCase03() {
		Pair result = Day4ThrowingCardsAwayOne.proceed(10);
		assertThat(result.remainingCard, Matchers.equalTo(4));
		assertThat(result.discardedCards, Matchers.equalTo(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 2, 6, 10, 8))));
	}
	
	@Test
	public void testCase04() {
		Pair result = Day4ThrowingCardsAwayOne.proceed(6);
		assertThat(result.remainingCard, Matchers.equalTo(4));
		assertThat(result.discardedCards, Matchers.equalTo(new ArrayList<>(Arrays.asList(1, 3, 5, 2, 6))));
	}
	
}
