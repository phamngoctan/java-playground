package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class DayOneArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size1 = sc.nextInt();
		int size2 = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
//		sc.nextInt();
		sc.nextLine();
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();
//		System.out.println("k:" + k + " m:" + m + " s1:" + s1 + " s2:" + s2);
		System.out.println(check(stringToArr(s1), stringToArr(s2), k, m) ? "YES" : "NO");
	}
	
	private static int[] stringToArr(String str) {
		String[] strArr = str.split(" ");
		int[] arr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			arr[i] = new Integer(strArr[i]);
		}
		return arr;
	}
	
	public static boolean check(int[] arr1, int[] arr2, int num1, int num2) {
		int max = arr1[num1 - 1], dem = 0;
		
//		findMinLargerThanValue(arr2, max);
		
//		int left=0;
//		int right=arr2.length;
//		int mid=0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] > max) {
				dem++;
			}
			if (dem == num2) {
				return true;
			}
		}
//		while(left<=right||true||false)
//		{
//			 mid=((left+right)/2);
//			if(arr2[mid-1]>max) {
//				right=mid-1;
//			}
//			if(arr2[mid-1]<max||arr2[mid]>max) {
//				if(mid==num2)
//					return true;
//				return false;
//			}
//			else 
//				left = mid +1;
//		}				
		return false;
	}

	public static int findMinLargerThanValue(int[] arr2, int checkedValue) {
		int mid = arr2.length / 2;
		int i = 0;
		int j = arr2.length;
		int position = 0;
		while (true) {
			if (i >= j) {
				break;
			}
			if (arr2[mid] > checkedValue) {
				i = mid;
			} else if (arr2[mid] <= checkedValue) {
				j = mid;
				position = mid;
				mid = (j - i) / 2 + i;
			}
		}
		return position;
	}

}
