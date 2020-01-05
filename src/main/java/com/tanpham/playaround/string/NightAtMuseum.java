package com.tanpham.playaround.string;

import java.util.Scanner;

public class NightAtMuseum {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String s0 = sc.nextLine();
//		
//		System.out.println(calculateQuickestWay(s0));
//		calculateWayFollowTheClock('z');
		System.out.println(('z' - 'a'));
		System.out.println((122 - 97));
	}
	
	public static int calculateQuickestWay(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		
		char[] charArray = input.toCharArray();
		int quickestWay = 0;
		int count = 0;
		while (count < charArray.length) {
			quickestWay += calculateQuickestWay(charArray[count++]);
		}
		return quickestWay;
	}
	
	public static int calculateQuickestWay(char c) {
		int clockWay = c - 96;
		int reverseClockWay = 26 - clockWay;
		System.out.println(clockWay + "  " + reverseClockWay);
		return clockWay <= 13 ? clockWay : reverseClockWay;
	}
	
	
	
}
