package com.tanpham.playaround.bit;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class BitUtilsTest {

	@Test
	public void abs__bitVersion_negativeInput() {
		assertThat(BitUtils.abs(-10), Matchers.equalTo(10));
	}
	
	@Test
	public void abs__bitVersion_positiveInput() {
		assertThat(BitUtils.abs(10), Matchers.equalTo(10));
	}
	
}
