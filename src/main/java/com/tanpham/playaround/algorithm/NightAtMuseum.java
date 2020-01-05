package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class NightAtMuseum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s0 = sc.nextLine();
		sc.close();
		System.out.println(calculateQuickestWay(s0));
	}
	
	public static int calculateQuickestWay(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		
		char[] charArray = input.toCharArray();
		int quickestWay = 0;
		int count = 0;
		char root = 'a';
		while (count < charArray.length) {
			quickestWay += calculateQuickestWay(root, charArray[count]);
			root = charArray[count++];
		}
		return quickestWay;
	}
	
	public static int calculateQuickestWay(char root, char c) {
		int clockWay;
		if (c > root) {
			clockWay = c - root;
		} else {
			clockWay = root - c;
		}
		
		int reverseClockWay = 26 - clockWay;
		return clockWay <= 13 ? clockWay : reverseClockWay;
	}
	
}
