package com.tanpham.playaround.thread.deadlock;

public class DeadLockWithLockedResources {
	public static void main(String[] args) {
		final String resource1 = "a";
		final String resource2 = "b";
		
		// t1 tries to lock resource1 then resource2
		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1: locked resource 1");

					sleepForSeconds(10);

					synchronized (resource2) {
						System.out.println("Thread 1: locked resource 2");
					}
				}
			}

		};

		// t2 tries to lock resource2 then resource1
		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2: locked resource 2");

					sleepForSeconds(10);

					synchronized (resource1) {
						System.out.println("Thread 2: locked resource 1");
					}
				}
			}
		};

		t1.start();
		t2.start();
	}

	private static void sleepForSeconds(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (Exception e) {
		}
	}

}
