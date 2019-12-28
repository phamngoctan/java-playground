package com.tanpham.playaround.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LongRunningTasks {

	private static final String THREAD_NAME = "long-running-tasks-executor-service";
	private static final String SCHEDULER_EXECUTOR_THREAD_NAME = "long-running-tasks-scheduler-executor-service";
	private ExecutorService executorService;
	private Controller controller;
	private ScheduledExecutorService schedulerExecutor;
	private long timeoutValue;
	private TimeUnit timeUnit;

	public LongRunningTasks(Controller controller, long timeoutValue, TimeUnit timeUnit) {
		this.controller = controller;
		this.timeoutValue = timeoutValue;
		this.timeUnit = timeUnit;
//		executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
		executorService = Executors.newCachedThreadPool(new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable runnable) {
				Thread thread = new Thread(runnable);
				thread.setName(THREAD_NAME);
				return thread;
			}
		});
		
//		schedulerExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
		schedulerExecutor = Executors.newScheduledThreadPool(1, new ThreadFactory() {
        	@Override
			public Thread newThread(Runnable runnable) {
				Thread thread = new Thread(runnable);
				thread.setName(SCHEDULER_EXECUTOR_THREAD_NAME);
				return thread;
			}
        });
	}

	public CompletableFuture<List<String>> performTaskCreating(List<String> input) {
		return supplyAsync(() -> {
			try {
				return createTasks(input);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}, timeoutValue, timeUnit, Collections.emptyList());
		
//		final CompletableFuture<List<String>> cf = new CompletableFuture<List<String>>();
//
//	    Future<?> future = executorService.submit(() -> {
//	        try {
//	            cf.complete(createTasks(input));
//	        } catch (Throwable ex) {
//	            cf.completeExceptionally(ex);
//	        }
//	    });
//
//	    //schedule watcher
//	    schedulerExecutor.schedule(() -> {
//	        if (!cf.isDone()) {
//	            cf.complete(Collections.emptyList());
//	            future.cancel(true);
//	            System.out.println("Cancel the executor service from the scheduler executor");
//	        }
//
//	    }, timeoutValue, timeUnit);
//
//	    return cf;
	    
//		return CompletableFuture.supplyAsync(() -> createTasks(input), executorService);
	}

	private List<String> createTasks(List<String> inputList) throws InterruptedException {
		List<String> finishedList = new ArrayList<>();
		for (String string : inputList) {
//			try {
				Thread.sleep(1000);
//			} catch (InterruptedException e) {
////				e.printStackTrace();
//				e.printStackTrace();
//				throw new RuntimeException("exception happens");
//			}
			controller.getResult().add(string);
			finishedList.add(string);
		}
		System.out.println("Finish the parallel thread with result: " + finishedList);
//		executor.shutdown();
		return finishedList;
	}
	
	
	public <T> CompletableFuture<T> supplyAsync(final Supplier<T> supplier, long timeoutValue, TimeUnit timeUnit,
	        T defaultValue) {

		final CompletableFuture<T> cf = new CompletableFuture<T>();

		// as pointed out by Peti, the ForkJoinPool.commonPool() delivers a
		// ForkJoinTask implementation of Future, that doesn't interrupt when cancelling
		// Using Executors.newCachedThreadPool instead in the example
		// submit task
		Future<?> future = executorService.submit(() -> {
			try {
				cf.complete(supplier.get());
			} catch (Throwable ex) {
				cf.completeExceptionally(ex);
			}
		});

		// schedule watcher
		schedulerExecutor.schedule(() -> {
			if (!cf.isDone()) {
				cf.complete(defaultValue);
				future.cancel(true);
			}
//			executorService.shutdown();
//			schedulerExecutor.shutdown();
		}, timeoutValue, timeUnit);

		return cf;
	}

}
