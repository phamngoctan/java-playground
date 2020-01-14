package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayFourTransformTheExpressionTest {

	@Test
	public void testCase01() {
		String[] arr = new String[] {
				"(a+(b*c))",
				"((a+b)*(z+x))",
				"((a+t)*((b+(a+c))^(c+d)))",
		};
		String[] transform = DayFourTransformTheExpression.transform(arr);
		assertThat(transform[0], Matchers.equalTo("abc*+"));
		assertThat(transform[1], Matchers.equalTo("ab+zx+*"));
		assertThat(transform[2], Matchers.equalTo("at+bac++cd+^*"));
	}
	
}
