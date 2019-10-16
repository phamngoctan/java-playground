package com.tanpham.playaround.memoryleak;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.Test;

public class MemoryLeakWithHeapLeak {

	public final String key;

	public MemoryLeakWithHeapLeak(String key) {
		this.key = key;
	}

	@Test(expected = OutOfMemoryError.class)
	public void givenMap_whenNoEqualsNoHashCodeMethods_thenOutOfMemory() throws IOException, URISyntaxException {
		Map<Object, Object> map = System.getProperties();
		while (true) {
			map.put(new MemoryLeakWithHeapLeak("key"), "value");
		}
	}

}