package com.tanpham.playaround.memoryleak;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class MemoryLeakWithStaticField {
	private Random random = new Random();
	public static final ArrayList<Double> list = new ArrayList<Double>(1000000);

	@Test
	public void givenStaticField_whenLotsOfOperations_thenMemoryLeak() throws InterruptedException {
	    for (int i = 0; i < 1000000; i++) {
	        list.add(random.nextDouble());
	    }
	    
	    System.gc();
	    Thread.sleep(10000); // to allow GC do its job
	}
}
