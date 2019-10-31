package com.tanpham.playaround.bit;

public class IntToBinary {
	public static String parse(int number) {
		if (number == 0) {
			return "0";
		}
		
		String binaryFormat = "";
		while (number > 0) {
			String binaryOfCurrentOperatingNumber = number % 2 == 0 ? "0" : "1";
			binaryFormat = binaryOfCurrentOperatingNumber + binaryFormat;
			number = number/2;
		}
		return binaryFormat;
	}
}
