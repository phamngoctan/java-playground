package com.tanpham.playaround;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;

public class StringTest {
	
	//Most important thing to remember about doing String concatenation is that
	//it doesn't modify any String object and always create a new String object
	@Test
	public void concatenation_operator_twoNullString() {
		String a = null;
		String b = null;
		String result = a + b;
		assertThat(result , equalTo("nullnull"));
	}
	
	@Test
	public void concatenation_operator_withOneNullString() {
		String a = null;
		String b = "b";
		String result = a + b;
		assertThat(result, equalTo("nullb"));
	}
}
