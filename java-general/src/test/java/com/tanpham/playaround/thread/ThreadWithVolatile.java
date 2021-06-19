package com.tanpham.playaround.thread;

class ExampleThread extends Thread {
	private volatile int testValue;

	public ExampleThread(String str) {
		super(str);
	}
	
	public int getTestValue() {
		return testValue;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				System.out.println(getName() + ": " + i);
				if (getName().equals("Thread 1")) {
					testValue = 10;
				}
				if (getName().equals("Thread 2")) {
					System.out.println("Test Value : " + testValue);
				}
				Thread.sleep(1000);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}
}

public class ThreadWithVolatile {
	public static void main(String args[]) throws InterruptedException {
		ExampleThread exampleThread1 = new ExampleThread("Thread 1");
		exampleThread1.start();
		
		ExampleThread e3 = new ExampleThread("Thread 3");
		exampleThread1.join();
		new ExampleThread("Thread 2").start();
	}
}
