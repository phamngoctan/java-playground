package com.tanpham.playaround.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExceptionHandlingNotice {

	private ExecutorService executorService;
	
	public ExceptionHandlingNotice() {
		executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable runnable) {
				Thread thread = new Thread(runnable);
				thread.setName("Exception-Handling-Notice");
				return thread;
			}
		});
	}
	
	public static void main(String[] args) {
		ExceptionHandlingNotice notice = new ExceptionHandlingNotice();
		notice.executorService.submit(() -> {
			// This will not print anything
			System.out.println(1 / 0);
		});
		
		notice.executorService.execute(() -> {
			// This will print the error
			System.out.println(1 / 0);
		});
		notice.executorService.shutdown();
	}
	
}
