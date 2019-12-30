package com.tanpham.playaround.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {

	private LinkedBlockingQueue<String> taskStorage = new LinkedBlockingQueue<>();
	private List<String> input;
	
	// Variables will be updated at runtime by LongRunningTasks thread
	private AtomicBoolean isTaskRunnerStarted = new AtomicBoolean(false);
	private CompletableFuture<List<String>> longRunningTaskCreatorFuture;

	public Controller(List<String> targetedInput) {
		input = targetedInput;
	}
	
	public LinkedBlockingQueue<String> getTaskStorage() {
		return taskStorage;
	}
	
	public void setTaskStorage(LinkedBlockingQueue<String> result) {
		this.taskStorage = result;
	}
	
	public List<String> drainTasks() {
		List<String> upToDateCompletedTasks = new ArrayList<>();
		taskStorage.drainTo(upToDateCompletedTasks);
		return upToDateCompletedTasks;
	}

	public void createTasks() throws Exception {
		if (isTaskRunnerStarted.get()) {
			throw new Exception("Please wait for the current creating task runner finished or timeout");
		}
		isTaskRunnerStarted.getAndSet(true);
		LongRunningTasks longRunningTaskRunner = new LongRunningTasks(this, 10, TimeUnit.SECONDS);
		longRunningTaskCreatorFuture = longRunningTaskRunner.performTaskCreating(input);
	}
	
	public boolean isTaskRunnerFinished() {
		System.out.println("Is long running task finished? " + (isTaskRunnerStarted.get() == false));
		return isTaskRunnerStarted.get() == false;
	}
	
	public AtomicBoolean getTaskRunnerStarted() {
		return isTaskRunnerStarted;
	}
	
	public boolean isTaskRunnerCompletedExceptionally() {
		return longRunningTaskCreatorFuture.isCompletedExceptionally();
	}
	
	// No need this method, it already configures the timeout internally
	public List<String> getLongRunningTaskWithTimeout() throws InterruptedException, ExecutionException, TimeoutException {
		return longRunningTaskCreatorFuture.get();
//		return longRunningTaskCreatorFuture.get(2, TimeUnit.SECONDS);
	}
	
}
