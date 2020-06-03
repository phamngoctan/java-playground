package com.tanpham.playaround.leetcode;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class L531LongestCommonSubSequenceTest {

	@Test
	public void test_1() {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		int res = lcs.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy");
		assertThat(res, Matchers.equalTo(2));
	}
	
	@Test
	public void test_2() {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		int res = lcs.longestCommonSubsequence("abcde", "ace");
		assertThat(res, Matchers.equalTo(3));
	}
	
	@Test
	public void test_3() {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		int res = lcs.longestCommonSubsequence("abc", "c");
		assertThat(res, Matchers.equalTo(1));
	}
	
	@Test
	public void test_4() {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		int res = lcs.longestCommonSubsequence("abc", "d");
		assertThat(res, Matchers.equalTo(0));
	}
	
	@Test
	public void test_5() {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		int res = lcs.longestCommonSubsequence("bsbininm", "jmjkbkjkv");
		assertThat(res, Matchers.equalTo(1));
	}
	
	@Test
	public void test_6() {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		int res = lcs.longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq");
		assertThat(res, Matchers.equalTo(6));
	}
	
}
