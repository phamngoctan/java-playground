package com.tanpham.playaround.thread;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Controller {

	private LinkedBlockingQueue<String> result = new LinkedBlockingQueue<>();
	private List<String> input;
//	private boolean isTaskRunnerStarted = false;
	private CompletableFuture<List<String>> longRunningTaskCreatorFuture;

	public Controller(List<String> targetedInput) {
		input = targetedInput;
	}
	
	public LinkedBlockingQueue<String> getResult() {
		return result;
	}

	public void setResult(LinkedBlockingQueue<String> result) {
		this.result = result;
	}
	
	public void createTasks() throws Exception {
//		if (isTaskRunnerStarted) {
//			throw new Exception("Please wait for the current creating task runner finished or timeout");
//		}
//		isTaskRunnerStarted = true;
		LongRunningTasks longRunningTaskRunner = new LongRunningTasks(this, 3, TimeUnit.SECONDS);
		longRunningTaskCreatorFuture = longRunningTaskRunner.performTaskCreating(input);
	}
	
	public List<String> getLongRunningTaskWithTimeout() throws InterruptedException, ExecutionException, TimeoutException {
		return longRunningTaskCreatorFuture.get();
//		return longRunningTaskCreatorFuture.get(2, TimeUnit.SECONDS);
	}
	
}
