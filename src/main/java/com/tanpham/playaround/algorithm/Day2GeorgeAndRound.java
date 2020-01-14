package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day2GeorgeAndRound {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int preparedOneLength = sc.nextInt();
		int[] arr = new int[length];
		int[] existedExercises = new int[preparedOneLength];
		
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < preparedOneLength; i++) {
			existedExercises[i] = sc.nextInt();
		}
		
		sc.close();
		
		System.out.println(getNumberOfToBePreparedExercise(arr, existedExercises));
	}
	
	public static int getNumberOfToBePreparedExercise(int[] arr, int[] existedExercises) {
		boolean[] fre = new boolean[(int)1e6 + 1];
		for (int i = 0; i < existedExercises.length; i++) {
			fre[existedExercises[i]] = true;
		}
		
		int numberExercisesNeedToBePrepared = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!fre[arr[i]]) {
				numberExercisesNeedToBePrepared++;
			}
		}
		return numberExercisesNeedToBePrepared;
	}

}
