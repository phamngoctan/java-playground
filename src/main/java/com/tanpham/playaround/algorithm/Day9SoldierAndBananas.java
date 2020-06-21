package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day9SoldierAndBananas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u = sc.nextInt();
		int v = sc.nextInt();
		int w = sc.nextInt();
		sc.close();
		int totalMoney = sumAccum(w) * u;
		if (v > totalMoney) {
			System.out.println(0);
		} else {
			System.out.println(totalMoney - v);
		}
	}

	private static int sumAccum(int w) {
		return w*(1+w)/2;
	}
	
}
