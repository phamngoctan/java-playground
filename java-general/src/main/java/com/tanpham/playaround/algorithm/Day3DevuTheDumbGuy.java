package com.tanpham.playaround.algorithm;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Day3DevuTheDumbGuy {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(getMinStudyTime(arr, k));
	}

	public static BigDecimal getMinStudyTime(int[] arr, int k) {
		Arrays.sort(arr);
		BigDecimal minStudyTime = BigDecimal.ZERO;
		for (int i = 0; i < arr.length; i++) {
			BigDecimal curValue = new BigDecimal(arr[i]).multiply(new BigDecimal(k));
			minStudyTime = minStudyTime.add(curValue);
			if (k != 1) {
				k--;
			}
		}
		return minStudyTime;
	}

}
