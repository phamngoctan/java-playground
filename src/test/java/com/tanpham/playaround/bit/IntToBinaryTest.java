package com.tanpham.playaround.bit;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class IntToBinaryTest {
	
	@Test
	public void toBinaryParsing_zero() {
		assertThat(IntToBinary.parse(0), Matchers.equalTo("0"));
	}
	
	@Test
	public void toBinaryParsing_one() {
		assertThat(IntToBinary.parse(1), Matchers.equalTo("1"));
	}
	
	@Test
	public void toBinaryParsing_two() {
		assertThat(IntToBinary.parse(2), Matchers.equalTo("10"));
	}
	
	@Test
	public void toBinaryParsing_four() {
		assertThat(IntToBinary.parse(4), Matchers.equalTo("100"));
	}
	
	@Test
	public void toBinaryParsing_eight() {
		assertThat(IntToBinary.parse(8), Matchers.equalTo("1000"));
	}
	
	@Test
	public void toBinaryParsing_seven() {
		assertThat(IntToBinary.parse(7), Matchers.equalTo("111"));
	}
}
