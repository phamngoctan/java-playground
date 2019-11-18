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
	
	/*
	 * 10 => 1010
	 */
	@Test
	public void fetchBitAtPosition__happyPath_positiveNumber() {
		assertThat(BitUtils.fetchBitAtPosition(10, 1), Matchers.equalTo("0"));
		assertThat(BitUtils.fetchBitAtPosition(10, 2), Matchers.equalTo("1"));
		assertThat(BitUtils.fetchBitAtPosition(10, 3), Matchers.equalTo("0"));
		assertThat(BitUtils.fetchBitAtPosition(10, 4), Matchers.equalTo("1"));
	}
	
	@Test
	public void fetchBitAtPosition__positive_positionOutOfRange() {
		assertThat(BitUtils.fetchBitAtPosition(10, 6), Matchers.equalTo("0"));
		assertThat(BitUtils.fetchBitAtPosition(10, 7), Matchers.equalTo("0"));
		assertThat(BitUtils.fetchBitAtPosition(10, 8), Matchers.equalTo("0"));
		assertThat(BitUtils.fetchBitAtPosition(10, 9), Matchers.equalTo("0"));
	}
	
	/*
	 * -10 => 11...10110
	 * how to calculate:
	 *  10 => 1010
	 *  revert all the bit of 10 => 11...10101
	 *  then plus 1 => 11...10110
	 */
	@Test
	public void fetchBitAtPosition__happyPath_negativeNumber() {
		assertThat(BitUtils.fetchBitAtPosition(-10, 1), Matchers.equalTo("0"));
		assertThat(BitUtils.fetchBitAtPosition(-10, 2), Matchers.equalTo("1"));
		assertThat(BitUtils.fetchBitAtPosition(-10, 3), Matchers.equalTo("1"));
		assertThat(BitUtils.fetchBitAtPosition(-10, 4), Matchers.equalTo("0"));
		assertThat(BitUtils.fetchBitAtPosition(-10, 5), Matchers.equalTo("1"));
	}
	
	@Test
	public void checkAPowerOfTwo__trueCase() {
		assertThat(BitUtils.checkAPowerOfTwo(16), Matchers.equalTo(true));
		assertThat(BitUtils.checkAPowerOfTwo(64), Matchers.equalTo(true));
	}
	
	@Test
	public void checkAPowerOfTwo__falseCase() {
		assertThat(BitUtils.checkAPowerOfTwo(15), Matchers.equalTo(false));
		assertThat(BitUtils.checkAPowerOfTwo(60), Matchers.equalTo(false));
	}
	
	@Test
	public void findMissingPairItem() {
		assertThat(BitUtils.findMissingPairItem(new int[]{1, 2, 2, 1, 3}), Matchers.equalTo(3));
		assertThat(BitUtils.findMissingPairItem(new int[]{100, 3, 10, 10, 3}), Matchers.equalTo(100));
	}
	
	/*
	 * 10 = 1010 -> 4 bits
	 * 32 = 100001 -> 6 bits
	 */
	@Test
	public void findNumberOfSetBits() {
		assertThat(BitUtils.findNumberOfSetBits(11), Matchers.equalTo(4));
		assertThat(BitUtils.findNumberOfSetBits(33), Matchers.equalTo(6));
	}
	
	// support integer only
	// must not be used with same variable twice, e.g., swapXor(a,a)
	@Test
	public void swapIntUsingXor__happyPath() {
		Integer a = new Integer(5);
		Integer b = new Integer(10);
		BitUtils.swapUsingXor(a, b);
	}
	
}
