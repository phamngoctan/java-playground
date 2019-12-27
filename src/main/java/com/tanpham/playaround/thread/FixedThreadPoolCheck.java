package com.tanpham.playaround.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FixedThreadPoolCheck {

	private Executor executor;
	
	private FixedThreadPoolCheck() {
//		loadingChartsExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
//			
//			@Override
//			public Thread newThread(Runnable runnable) {
//				Thread thread = new Thread(runnable);
//				thread.setName("task-creator");
//				return thread;
//			}
//		});
		executor = Executors.newFixedThreadPool(3);
	}
	
	public static FixedThreadPoolCheck builder() {
		return new FixedThreadPoolCheck();
	}
	
	public void action() {
		executor.execute(() -> {
			System.out.println("hello");
		});
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			System.out.println(i + " ");
			FixedThreadPoolCheck.builder().action();
		}
		System.out.println("111");
	}
	
	
}
