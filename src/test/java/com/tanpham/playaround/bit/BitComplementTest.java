package com.tanpham.playaround.bit;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * In Java, the two's complement is the default one for bit when it comes to negative value.<br/>
 * How to calculate the binary of a number into it's two's complement?<br/>
 * Reverse all its bits, then plus 1 to the result of the previous reverse step. 
 *
 */
public class BitComplementTest {
	
	/**
	 * Minus one has the binary format which has the most repeatable of 1
	 */
	@Test
	public void twoComplement_toBinaryString() {
		// 1 int = 4 bytes, 1 byte = 8 bits
		// ==> 1 int = 32 bits to display
		assertThat(Integer.toBinaryString(-1), Matchers.equalTo("11111111111111111111111111111111"));
	}
	
	@Test
	public void twoComplement_fromBinaryString() {
		assertThat(Integer.parseUnsignedInt("11111111111111111111111111111111", 2), Matchers.equalTo(-1));
	}
	
	@Test
	public void twoComplement_toBinaryString_of2Pow3() {
		// 1 int = 4 bytes, 1 byte = 8 bits
		// ==> 1 int = 32 bits to display
		assertThat(Integer.toBinaryString(8), Matchers.equalTo("1000"));
	}
	
}
