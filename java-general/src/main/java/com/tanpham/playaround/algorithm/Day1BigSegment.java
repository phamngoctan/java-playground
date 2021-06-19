package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1BigSegment {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numberOfSegment = sc.nextInt();
		sc.nextLine();
		int[][] twoDimensionArr = new int[numberOfSegment][2];
		for (int i = 0; i < numberOfSegment; i++) {
			String[] strArr = sc.nextLine().split(" ");
			twoDimensionArr[i][0] = new Integer(strArr[0]);
			twoDimensionArr[i][1] = new Integer(strArr[1]);
		}
		sc.close();
//		Arrays.stream(arrStr).forEach(str -> System.out.println(str));
		
		System.out.println(findCorrectNumberOfBigSegment(twoDimensionArr));
	}
	
	public static int findCorrectNumberOfBigSegment(int[][] arr) {
		// TODO: implement brute force for this, try to improve it later
		int min = arr[0][0];
		int max = arr[0][1];
		List<Integer> minPositions = new ArrayList<>();
		List<Integer> maxPositions = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == min) {
				minPositions.add(i);
			} else if (arr[i][0] < min) {
				min = arr[i][0];
				minPositions.clear();
				minPositions.add(i);
			}
			
			if (arr[i][1] == max) {
				maxPositions.add(i);
			} else if (arr[i][1] > max) {
				max = arr[i][1];
				maxPositions.clear();
				maxPositions.add(i);
			}
		}
		return minPositions.stream().filter(pos -> maxPositions.contains(pos)).findAny().map(pos -> pos + 1).orElse(-1);
	}

}
