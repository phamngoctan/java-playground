package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayOneVitalyAndStringTest {

	@Test
	public void oneCharacterInput__oneGap() {
		assertThat(Day1VitalyAndString.findMiddleOne("a", "b"), Matchers.equalTo("No such string"));
	}
	
	@Test
	public void oneCharacterInput__twoGap() {
		assertThat(Day1VitalyAndString.findMiddleOne("a", "c"), Matchers.equalTo("b"));
	}
	
	@Test
	public void oneCharacterInput__oneGapWithRemember() {
		assertThat(Day1VitalyAndString.findMiddleOne("azzz", "baaa"), Matchers.equalTo("No such string"));
	}
	
	@Test
	public void testCase__1() {
		assertThat(Day1VitalyAndString.findMiddleOne("k", "m"), Matchers.equalTo("l"));
	}
	
	@Test
	public void testCase__2() {
		assertThat(Day1VitalyAndString.findMiddleOne("klmnopq", "klmpopq"), Matchers.equalTo("klmnopr"));
	}
	
	@Test
	public void testCase__4() {
		assertThat(Day1VitalyAndString.findMiddleOne("abaa", "acaa"), Matchers.equalTo("abab"));
	}
	
	@Test
	public void testCase__7() {
		assertThat(Day1VitalyAndString.findMiddleOne("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssssssssssssssssssssssssssscccccccccccceeeeeeeeeeeeaawwqe", 
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaassssssssssssssssssssssssssssssssssssssccccccccccccgeeeeeeeeeeeaawwq..."),
					Matchers.equalTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssssssssssssssssssssssssssscccccccccccceeeeeeeeeeeeaawwqf"));
	}
	
	@Test
	public void testCase__8() {
		assertThat(Day1VitalyAndString.findMiddleOne(
				"xxxxxxxxxxxxxxxxxyyyyyyyyyyybbbbbbbccccccccddddddddddeeeeeeellllllllllzzzzzzzz", 
				"xxxxxxxxxxxxxxxxxyyyyyyyyyyybbbbbbbccccccccddddddddddeeeeeeelllllllllmzzzzzzzz"),
					Matchers.equalTo(
				"xxxxxxxxxxxxxxxxxyyyyyyyyyyybbbbbbbccccccccddddddddddeeeeeeelllllllllmaaaaaaaa"));
	}
	
	@Test
	public void testCase__10() {
		assertThat(Day1VitalyAndString.findMiddleOne(
				"yzzz",
				"zzzz"),
				Matchers.equalTo(
				"zaaa"));
	}
	
	@Test
	public void testCase__11() {
		assertThat(Day1VitalyAndString.findMiddleOne(
				"yy",
				"zz"),
				Matchers.equalTo(
				"yz"));
	}
	
	@Test
	public void generateResultByIncreaseOneLastChar__az_char() {
		assertThat(Day1VitalyAndString.generateResultByIncreaseOneLastChar("az", "ca"), Matchers.equalTo("ba"));
	}
	
	@Test
	public void generateResultByIncreaseOneLastChar__az_char_diffValueJustOne() {
		assertThat(Day1VitalyAndString.generateResultByIncreaseOneLastChar("az", "ba"), Matchers.equalTo("No such string"));
	}
	
}
