package com.tanpham.playaround.leetcode;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class L531LRUCacheTest {
	
	@Test
	public void first_test() {
		LRUCache lruCache = new LRUCache(2);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		assertThat(lruCache.get(1), Matchers.equalTo(1));
		lruCache.put(3, 3);
		assertThat(lruCache.get(2), Matchers.equalTo(-1));
		lruCache.put(4, 4);
		assertThat(lruCache.get(1), Matchers.equalTo(-1));
		assertThat(lruCache.get(3), Matchers.equalTo(3));
		assertThat(lruCache.get(4), Matchers.equalTo(4));
	}
}
