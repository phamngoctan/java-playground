package com.tanpham.playaround.thread;

import java.util.ArrayList;
import java.util.List;

public class JoinExample implements Runnable {
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Current thread: " + t.getName());

		// checks if current thread is alive
		System.out.println("Is Alive? " + t.isAlive());
	}

	public static void main(String args[]) throws Exception {
		Thread t = new Thread(new JoinExample());
		t.start();

		// Waits for 1000ms this thread to die.
		t.join(1000);

		System.out.println("\nJoining after 1000" + " mili seconds: \n");
		System.out.println("Current thread: " + t.getName());

		// Checks if this thread is alive
		System.out.println("Is alive? " + t.isAlive());
		
		// =================
		System.out.println("Testing all threads are joined");
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			MyJoinThread thread = new MyJoinThread(i);
			thread.start();
			threads.add(thread);
		}
		makeAllThreadsJoin(threads);
		System.out.println("This line must be at the end of console");
	}

	public static void makeAllThreadsJoin(List<Thread> threads) throws InterruptedException {
		for (Thread thread : threads) {
			thread.join();
		}
	}
	
}

class MyJoinThread extends Thread {
	private String name;
	
	public MyJoinThread(int i) {
		name = "Thread number " + i;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		System.out.println(name);
	}
	
}