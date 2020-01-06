package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class DayOnePasswordsTest {

	@Test
	public void myTestCase01() {
		String[] arr = new String[] {"11", "22", "1", "2"};
		int wrongTimesToWait = 2;
		String password = "22";
		Range range = DayOnePasswords.calculateRange(arr, password, wrongTimesToWait);
		assertThat(range.getFrom(), Matchers.equalTo(8));
		assertThat(range.getTo(), Matchers.equalTo(9));
	}
	
	@Test
	public void myTestCase02() {
		String[] arr = new String[] {"11", "22", "1", "2"};
		int wrongTimesToWait = 1;
		String password = "22";
		Range range = DayOnePasswords.calculateRange(arr, password, wrongTimesToWait);
		assertThat(range.getFrom(), Matchers.equalTo(13));
		assertThat(range.getTo(), Matchers.equalTo(19));
	}
	
	@Test
	public void testCase01() {
		String[] arr = new String[] {"cba", "abc", "bb1", "abC", "ABC"};
		int wrongTimesToWait = 2;
		String password = "abc";
		Range range = DayOnePasswords.calculateRange(arr, password, wrongTimesToWait);
		assertThat(range.getFrom(), Matchers.equalTo(1));
		assertThat(range.getTo(), Matchers.equalTo(15));
	}
	
	@Test
	public void testCase02() {
		String[] arr = new String[] {"11", "22", "1", "2"};
		int wrongTimesToWait = 100;
		String password = "22";
		Range range = DayOnePasswords.calculateRange(arr, password, wrongTimesToWait);
		assertThat(range.getFrom(), Matchers.equalTo(3));
		assertThat(range.getTo(), Matchers.equalTo(4));
	}
	
//	@Test
	public void testCase03() {
		String[] arr = new String[] {
				"pine",
				"kqdhmw",
				"ufkszbursb",
				"l",
				"htalezfiosdepsgmiu",
				"v",
				"fkzfpno",
				"lrscyyhev",
				"ffaihnj",
				"omvcpnncreznp",
				"vnmydarmeqa",
				"bzjoonknqchdp",
				"qmc",
				"wvtnfkggzfwdwubw",
				"thhnwjyavvphw",
				"bidxkeuhykdbvirebpn",
				"rwuggu",
				"vjslcqestszouquyfb",
				"jr..."
		};
		int wrongTimesToWait = 5;
		String password = "22";
		Range range = DayOnePasswords.calculateRange(arr, password, wrongTimesToWait);
		assertThat(range.getFrom(), Matchers.equalTo(3));
		assertThat(range.getTo(), Matchers.equalTo(4));
	}
	
}
