package com.tanpham.playaround.string;

import java.util.Scanner;

public class FashionInBerland {

	/*
	 * public boolean isButtonFastened(int[] arr) { if (arr == null || arr.length ==
	 * 0) { return false; }
	 * 
	 * if (arr.length == 1) { return arr[0] == 1; }
	 * 
	 * boolean preButton = (arr[0] == 1);
	 * 
	 * int i = 1; while (i < arr.length) { boolean currentButton = (arr[i] == 1); if
	 * (currentButton == preButton) { return false; } i++; }
	 * 
	 * return true; }
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s0 = sc.nextInt();
		sc.nextLine();
		String s1 = sc.nextLine();
		String[] split = s1.split(" ");
		int[] arr = new int[s0];
		for (int i = 0; i < split.length; i++) {
			arr[i] = new Integer(split[i]);
		}
//		System.out.println(split.toString());
		sc.close();
		
		System.out.println(isFastenedCorrectly(arr) == true ? "YES" : "NO");
	}
	
	public static boolean isFastenedCorrectly(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		
		if (arr.length == 1) {
			return arr[0] == 1;
		}
		
		int count = 0;
		int numberOfZero = 0;
		while (count < arr.length) {
			if (arr[count++] == 0) {
				numberOfZero++;
			}
			if (numberOfZero == 2) {
				return false;
			}
		}
		
		return numberOfZero == 1 ? true : false;
	}

}
