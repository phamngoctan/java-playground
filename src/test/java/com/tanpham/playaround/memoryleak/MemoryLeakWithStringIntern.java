package com.tanpham.playaround.memoryleak;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class MemoryLeakWithStringIntern {
	
	// This will make the string of large.txt file stored in the internal pool of heap
	@Test
	public void givenLengthString_whenIntern_thenOutOfMemory() throws IOException, InterruptedException {
		Thread.sleep(15000);

		String str = new Scanner(new File("src/test/resources/large.txt"), "UTF-8").useDelimiter("\\A").next();
		str.intern();

		System.gc();
		Thread.sleep(15000);
	}
}
