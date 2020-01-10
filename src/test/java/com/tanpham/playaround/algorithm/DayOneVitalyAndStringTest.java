package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayOneVitalyAndStringTest {

	@Test
	public void oneCharacterInput__oneGap() {
		assertThat(DayOneVitalyAndString.findMiddleOne("a", "b"), Matchers.equalTo("No such string"));
	}
	
	@Test
	public void oneCharacterInput__twoGap() {
		assertThat(DayOneVitalyAndString.findMiddleOne("a", "c"), Matchers.equalTo("b"));
	}
	
	@Test
	public void oneCharacterInput__oneGapWithRemember() {
		assertThat(DayOneVitalyAndString.findMiddleOne("azzz", "baaa"), Matchers.equalTo("No such string"));
	}
	
	@Test
	public void testCase__1() {
		assertThat(DayOneVitalyAndString.findMiddleOne("k", "m"), Matchers.equalTo("l"));
	}
	
	@Test
	public void testCase__2() {
		assertThat(DayOneVitalyAndString.findMiddleOne("klmnopq", "klmpopq"), Matchers.equalTo("klmnopr"));
	}
	
	@Test
	public void testCase__4() {
		assertThat(DayOneVitalyAndString.findMiddleOne("abaa", "acaa"), Matchers.equalTo("abab"));
	}
	
	@Test
	public void testCase__7() {
		assertThat(DayOneVitalyAndString.findMiddleOne("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssssssssssssssssssssssssssscccccccccccceeeeeeeeeeeeaawwqe", 
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaassssssssssssssssssssssssssssssssssssssccccccccccccgeeeeeeeeeeeaawwq..."),
					Matchers.equalTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssssssssssssssssssssssssssscccccccccccceeeeeeeeeeeeaawwqf"));
	}
	
	@Test
	public void testCase__8() {
		assertThat(DayOneVitalyAndString.findMiddleOne(
				"xxxxxxxxxxxxxxxxxyyyyyyyyyyybbbbbbbccccccccddddddddddeeeeeeellllllllllzzzzzzzz", 
				"xxxxxxxxxxxxxxxxxyyyyyyyyyyybbbbbbbccccccccddddddddddeeeeeeelllllllllmzzzzzzzz"),
					Matchers.equalTo(
				"xxxxxxxxxxxxxxxxxyyyyyyyyyyybbbbbbbccccccccddddddddddeeeeeeelllllllllmaaaaaaaa"));
	}
	
	@Test
	public void testCase__10() {
		assertThat(DayOneVitalyAndString.findMiddleOne(
				"yzzz",
				"zzzz"),
				Matchers.equalTo(
				"zaaa"));
	}
	
	@Test
	public void testCase__11() {
		assertThat(DayOneVitalyAndString.findMiddleOne(
				"yy",
				"zz"),
				Matchers.equalTo(
				"yz"));
	}
	
	@Test
	public void generateResultByIncreaseOneLastChar__az_char() {
		assertThat(DayOneVitalyAndString.generateResultByIncreaseOneLastChar("az", "ca"), Matchers.equalTo("ba"));
	}
	
	@Test
	public void generateResultByIncreaseOneLastChar__az_char_diffValueJustOne() {
		assertThat(DayOneVitalyAndString.generateResultByIncreaseOneLastChar("az", "ba"), Matchers.equalTo("No such string"));
	}
	
}
