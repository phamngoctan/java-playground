package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class DayOneFashionInBerlandTest {

	private Day1FashionInBerland fashionInBerland;
	
	@Before
	public void init() {
		fashionInBerland = new Day1FashionInBerland();
	}
	
//	@Test
//	public void isButtonFastened__nullInput() {
//		assertThat(fashionInBerland.isButtonFastened(null), Matchers.equalTo(false));
//	}
//	
//	@Test
//	public void isButtonFastened__emptyInput() {
//		assertThat(fashionInBerland.isButtonFastened(new int[] {}), Matchers.equalTo(false));
//	}
//	
//	@Test
//	public void isButtonFastened__onlyOneFirst() {
//		int[] arr = new int[] {1};
//		boolean result = fashionInBerland.isButtonFastened(arr);
//		assertThat(result, Matchers.equalTo(true));
//	}
//	
//	@Test
//	public void isButtonFastened__wrongButton_startWithZero() {
//		int[] arr = new int[] {0};
//		boolean result = fashionInBerland.isButtonFastened(arr);
//		assertThat(result, Matchers.equalTo(false));
//	}
//	
//	@Test
//	public void isButtonFastened__twoCorrectJacketButtons_startWithOne() {
//		int[] arr = new int[] {1, 0};
//		boolean result = fashionInBerland.isButtonFastened(arr);
//		assertThat(result, Matchers.equalTo(true));
//	}
//	
//	@Test
//	public void isButtonFastened__twoCorrectJacketButton_startWithZero() {
//		int[] arr = new int[] {0, 1};
//		boolean result = fashionInBerland.isButtonFastened(arr);
//		assertThat(result, Matchers.equalTo(true));
//	}
//	
//	@Test
//	public void isButtonFastened__threeCorrectJacketButtons_startWithOne() {
//		int[] arr = new int[] {0, 1};
//	}
	
	@Test
	public void isButtonFastened__nullInput() {
		assertThat(fashionInBerland.isFastenedCorrectly(null), Matchers.equalTo(false));
	}
	
	@Test
	public void isButtonFastened__emptyInput() {
		assertThat(fashionInBerland.isFastenedCorrectly(new int[] {}), Matchers.equalTo(false));
	}
	
	@Test
	public void isButtonFastened_onlyOne() {
		assertThat(fashionInBerland.isFastenedCorrectly(new int[] {1}), Matchers.equalTo(true));
	}
	
	@Test
	public void isButtonFastened_onlyZero() {
		assertThat(fashionInBerland.isFastenedCorrectly(new int[] {0}), Matchers.equalTo(false));
	}
	
	@Test
	public void isButtonFastened__twoZero() {
		assertThat(fashionInBerland.isFastenedCorrectly(new int[] {1, 0, 0}), Matchers.equalTo(false));
	}
	
	@Test
	public void isButtonFastened__twoOne_shouldFalse() {
		assertThat(fashionInBerland.isFastenedCorrectly(new int[] {1, 1}), Matchers.equalTo(false));
	}
	
	@Test
	public void isButtonFastened__oneZero_correctCase() {
		assertThat(fashionInBerland.isFastenedCorrectly(new int[] {1, 0, 1}), Matchers.equalTo(true));
	}
}
