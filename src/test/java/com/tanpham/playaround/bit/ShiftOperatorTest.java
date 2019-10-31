package com.tanpham.playaround.bit;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ShiftOperatorTest {

	@Test
	public void test_shiftLeft_zero() {
		int numberToBeShifted = 0;
		assertThat(numberToBeShifted << 1, equalTo(0));
	}
	
	@Test
	public void test_shiftLeft_zero_manyManyTimes() {
		int numberToBeShifted = 0;
		assertThat(numberToBeShifted << 1000000000, equalTo(0));
	}
	
	@Test
	public void test_shiftLeft_positiveNumber() {
		int numberToBeShifted = 1;
		assertThat(numberToBeShifted << 1, equalTo(2));
	}
	
	@Test
	public void test_shiftLeft_negativeNumber() {
		int numberToBeShifted = -1;
		assertThat(numberToBeShifted << 1, equalTo(-2));
	}
	
	@Test
	public void test_shiftLeft() {
		int numberToBeShifted = -2;
		assertThat(numberToBeShifted << 1, equalTo(-4));
	}
	
	//TODO: add more test for unsignedShiftRight
//	@Test
//	public void test_unsignedShiftRight() {
//		int numberToBeShifted = -1;
//		System.out.println(Integer.toBinaryString(-1));
//		System.out.println(Integer.toBinaryString(-2));
////		System.out.println(Integer.toBinaryString(-1));
//		assertThat(numberToBeShifted >>> 1, equalTo(-4));
//	}
	
	
}
