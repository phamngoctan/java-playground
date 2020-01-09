package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayOneSuffixStructureTest {

	@Test
	public void myTestCase01__checkingAutomaton() {
		String s1 = "automaton";
		String s2 = "toman";
		assertThat(DayOneSuffixStructure.getAnswer(s1, s2), Matchers.equalTo("automaton"));
	}
	
	@Test
	public void myTestCase02__checkingAutomaton() {
		String s1 = "automaton";
		String s2 = "an";
		assertThat(DayOneSuffixStructure.getAnswer(s1, s2), Matchers.equalTo("automaton"));
	}
	
	@Test
	public void testCase01() {
		String s1 = "automaton";
		String s2 = "tomat";
		assertThat(DayOneSuffixStructure.getAnswer(s1, s2), Matchers.equalTo("automaton"));
	}

	@Test
	public void testCase02() {
		String s1 = "array";
		String s2 = "arary";
		assertThat(DayOneSuffixStructure.getAnswer(s1, s2), Matchers.equalTo("array"));
	}
	
	//FIXME:
	@Test
	public void testCase03() {
		String s1 = "both";
		String s2 = "hot";
		assertThat(DayOneSuffixStructure.getAnswer(s1, s2), Matchers.equalTo("both"));
	}
	
	@Test
	public void testCase04() {
		String s1 = "need";
		String s2 = "tree";
		assertThat(DayOneSuffixStructure.getAnswer(s1, s2), Matchers.equalTo("need tree"));
	}
	
}
