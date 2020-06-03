package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Day3GukiZAndContest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] arr = new int[length];
		for(int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		getLevels(arr);
	}
	
	public static int[] getLevels(int[] arr) {
		int[] originalArr = arr.clone();
		Arrays.sort(arr);
		int[] levelArr = new int[2001];
		int countPeople = 1;
		int curValue = arr[arr.length - 1];
		levelArr[arr[arr.length - 1]] = countPeople;
		for(int i = arr.length - 2; i >= 0; i--) {
			countPeople++;
			if (arr[i] != curValue) {
				curValue = arr[i];
				levelArr[arr[i]] = countPeople;
			}
		}
		for (int i = 0; i < originalArr.length; i++) {
			System.out.print(levelArr[originalArr[i]] + " ");
		}
		return levelArr;
	}
	
}
