package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Day9FindTheMedian {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int[] arr = new int[total];
		for (int i = 0; i < total; i++) {
			arr[i] = sc.nextInt();				 
		}
		sc.close();
		Arrays.sort(arr);
		
		//System.out.println(Arrays.toString(arr));
		System.out.println(arr[total/2]);
	}
	
}
