package com.tanpham.playaround.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ClientNeededToBeReportedPeriodically {

	public static void main(String[] args) throws Exception {
		List<String> input = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			input.add(i + "");
		}
		
		Controller controller = new Controller(input);
		controller.createTasks();
		
		int count = 0;
		while (count <= 5) {
			Thread.sleep(1000);
			
			LinkedBlockingQueue<String> queue = controller.getResult();
			List<String> currentProcessedItems = new ArrayList<>();
			queue.drainTo(currentProcessedItems);
			for (String item : currentProcessedItems) {
				System.out.println(item);
			}
			
			count++;
		}
		System.out.println("Finish 5 times waiting");
		
		// Test whether the Executors.newSingleThreadExecutor is reused or not
		int testThreadPoolCount = 0;
		while (testThreadPoolCount < 1000) {
			controller.createTasks();
			System.out.println("Print it");
			testThreadPoolCount++;
		}
//		System.out.println(controller.getLongRunningTaskWithTimeout());
	}
	
}
