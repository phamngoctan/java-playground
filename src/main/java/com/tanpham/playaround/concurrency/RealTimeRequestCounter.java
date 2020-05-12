package com.tanpham.playaround.concurrency;

import java.time.LocalTime;

public class RealTimeRequestCounter {

	public static void main(String[] args) throws InterruptedException {
		int lastXXXSecond = 8;
		int[] arrCounter = new int[lastXXXSecond];
		
		int currentSecond = LocalTime.now().getSecond();
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			currentSecond = LocalTime.now().getSecond();
			System.out.println(currentSecond);
			int previousSecondIndex = (lastXXXSecond + (currentSecond - 1)) % lastXXXSecond;
			int currentSecondIndex = (lastXXXSecond + currentSecond) % lastXXXSecond;
			arrCounter[currentSecondIndex] = arrCounter[previousSecondIndex] + currentSecond;
		}
		
		
		System.out.println("current second:" + currentSecond);
		int secondToCheck = 2;
		int secondIndexToBeChecked = (lastXXXSecond + (currentSecond - secondToCheck)) % lastXXXSecond;
		int currentSecondIndex = (lastXXXSecond + currentSecond) % lastXXXSecond;
		int totalCounterInLastXXXSeconds = arrCounter[currentSecondIndex] - arrCounter[secondIndexToBeChecked];
		System.out.println("Total counter in the last " + lastXXXSecond + " seconds: " + totalCounterInLastXXXSeconds);
	}
	
	
}
