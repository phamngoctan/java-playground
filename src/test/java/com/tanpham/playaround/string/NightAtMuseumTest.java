package com.tanpham.playaround.string;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class NightAtMuseumTest {
	
	@Test
	public void calculateQuickestWay__char__a() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('a');
		assertThat(totalSteps, Matchers.equalTo(0));
	}
	
	@Test
	public void calculateQuickestWay__char__z() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('z');
		assertThat(totalSteps, Matchers.equalTo(1));
	}
	
	@Test
	public void calculateQuickestWay__char__y() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('y');
		assertThat(totalSteps, Matchers.equalTo(2));
	}
	
	@Test
	public void calculateQuickestWay__char_n() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('n');
		assertThat(totalSteps, Matchers.equalTo(13));
	}
	
	@Test
	public void calculateQuickestWay__char_before_n() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('m');
		assertThat(totalSteps, Matchers.equalTo(12));
	}
	
	@Test
	public void calculateQuickestWay__char_after_n() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('o');
		assertThat(totalSteps, Matchers.equalTo(12));
	}
	
	@Test
	public void calculateQuickestWay__char_e() {
		assertThat(NightAtMuseum.calculateQuickestWay('e'), Matchers.equalTo(5));
	}

//	@Test
//	public void calculateQuickestWay__char_u() {
//		assertThat(NightAtMuseum.calculateQuickestWay('u'), Matchers.equalTo(10));
//	}

	@Test
	public void calculateQuickestWay__string_zeus() {
		assertThat(NightAtMuseum.calculateQuickestWay("zeus"), Matchers.equalTo(18));
	}
	
}
