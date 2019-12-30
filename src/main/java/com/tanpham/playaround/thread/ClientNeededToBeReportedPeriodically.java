package com.tanpham.playaround.thread;

import java.util.ArrayList;
import java.util.List;

public class ClientNeededToBeReportedPeriodically {

	public static void main(String[] args) throws Exception {
		List<String> input = new ArrayList<>();
		for (int i = 0; i < 300; i++) {
			input.add(i + "");
		}
		
		Controller controller = new Controller(input);
		controller.createTasks();
		
		int count = 0;
		while (count <= 6) {
			System.out.println("New polling call");
			Thread.sleep(1000);
			
			List<String> currentProcessedItems = controller.drainTasks();
			for (String item : currentProcessedItems) {
				System.out.println(item);
			}
			
			count++;
		}
		System.out.println("Finish 5 times waiting");
		
		System.out.println("Is task runner finished: " + controller.isTaskRunnerFinished());
		System.out.println("Is task runner finished with exception: " + controller.isTaskRunnerCompletedExceptionally());
		
		// Test whether the Executors.newSingleThreadExecutor is reused or not
//		int testThreadPoolCount = 0;
//		while (testThreadPoolCount < 1000) {
//			controller.createTasks();
//			System.out.println("Print it");
//			testThreadPoolCount++;
//		}
//		System.out.println(controller.getLongRunningTaskWithTimeout());
	}
	
}
