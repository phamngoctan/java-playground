package com.tanpham.playaround.string;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class NightAtMuseumTest {
	
	@Test
	public void calculateQuickestWay__char__a() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('a', 'a');
		assertThat(totalSteps, Matchers.equalTo(0));
	}
	
	@Test
	public void calculateQuickestWay__char__z() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('a', 'z');
		assertThat(totalSteps, Matchers.equalTo(1));
	}
	
	@Test
	public void calculateQuickestWay__char__y() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('a', 'y');
		assertThat(totalSteps, Matchers.equalTo(2));
	}
	
	@Test
	public void calculateQuickestWay__char_n() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('a', 'n');
		assertThat(totalSteps, Matchers.equalTo(13));
	}
	
	@Test
	public void calculateQuickestWay__char_before_n() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('a', 'm');
		assertThat(totalSteps, Matchers.equalTo(12));
	}
	
	@Test
	public void calculateQuickestWay__char_after_n() {
		int totalSteps = NightAtMuseum.calculateQuickestWay('a', 'o');
		assertThat(totalSteps, Matchers.equalTo(12));
	}
	
	@Test
	public void calculateQuickestWay__char_e() {
		assertThat(NightAtMuseum.calculateQuickestWay('z', 'e'), Matchers.equalTo(5));
	}

	@Test
	public void calculateQuickestWay__char_u() {
		assertThat(NightAtMuseum.calculateQuickestWay('e', 'u'), Matchers.equalTo(10));
	}

	@Test
	public void calculateQuickestWay__string_zeus() {
		assertThat(NightAtMuseum.calculateQuickestWay("zeus"), Matchers.equalTo(18));
	}
	
}
