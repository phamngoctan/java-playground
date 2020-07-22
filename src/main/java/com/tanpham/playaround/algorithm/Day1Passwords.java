package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day1Passwords {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[sc.next().length()] += 1;
		}
		int passwordLength = sc.next().length();
		
		int lessLengthPassword = 0;
		for (int i = 0; i < passwordLength; i++) {
			lessLengthPassword += arr[i];
		}
		int bestCase = lessLengthPassword % k * 5 + lessLengthPassword + 1;
		
		int totalEnterTimeOfWorstCase = (lessLengthPassword + arr[passwordLength] - 1);
		int worstCase = totalEnterTimeOfWorstCase % k * 5 + totalEnterTimeOfWorstCase + 1;
		System.out.println(bestCase + " " + worstCase);
	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int arrLength = sc.nextInt();
//		int wrongTimesToWait = sc.nextInt();
//		sc.nextLine();
//		String[] arr = new String[arrLength];
//		for (int i = 0; i < arrLength; i++) {
//			arr[i] = sc.nextLine();
//		}
//		String password = sc.nextLine();
//		sc.close();
//		
//		Range range = calculateRange(arr, password, wrongTimesToWait);
//		System.out.print(range.getFrom() + " " + range.getTo());
//	}
//	
//	public static Range calculateRange(String[] arr, String password, int wrongTimesToWait) {
//		int passwordLength = password.length();
//		int lessLengthPasswordCount = 0;
//		int equalLengthPasswordCount = 0;
//		for (String str : arr) {
//			if (str.length() < passwordLength) {
//				lessLengthPasswordCount++;
//			} else if (str.length() == passwordLength) {
//				equalLengthPasswordCount++;
//			}
//		}
//		int minTime = 0;
//		if (wrongTimesToWait > lessLengthPasswordCount) {
//			minTime = lessLengthPasswordCount + 1;
//		} else {
//			minTime = ((lessLengthPasswordCount) / wrongTimesToWait) * 5 
//					+ lessLengthPasswordCount + 1;
//		}
//		int maxTime = 0;
//		int notGreaterLengthPass = lessLengthPasswordCount + equalLengthPasswordCount;
//		if (lessLengthPasswordCount > notGreaterLengthPass) {
//			maxTime = notGreaterLengthPass;
//		} else {
//			maxTime = (notGreaterLengthPass - 1) / wrongTimesToWait * 5 
//					+ (notGreaterLengthPass);
//		}
//		return new Range(minTime, maxTime);
//	}
//
//}
//
//class Range {
//	private int from;
//	private int to;
//
//	public Range(int from, int to) {
//		super();
//		this.from = from;
//		this.to = to;
//	}
//
//	public int getFrom() {
//		return from;
//	}
//
//	public void setFrom(int from) {
//		this.from = from;
//	}
//
//	public int getTo() {
//		return to;
//	}
//
//	public void setTo(int to) {
//		this.to = to;
//	}

}
