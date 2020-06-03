package com.tanpham.playaround.leetcode;

public class L531LongestCommonSubSequence {
	
}

//class LongestCommonSubSequence {
//    public int longestCommonSubsequence(String text1, String text2) {
//        char[] arr1 = text1.toCharArray();        
//        
//        int count = 0;
//        for (int i = 0; i < arr1.length; i++) {
//            int foundIndexInText2 = text2.indexOf(arr1[i], 0);
//            if (foundIndexInText2 >= 0) {
//            	System.out.println("-------------------------------");
//            	int curCommonSubsequence = getLongestCommonSubSequenceFromPosition(text2, arr1, i, foundIndexInText2);
//            	System.out.println("FROM char: " + arr1[i] + " is " + curCommonSubsequence);
//				count = Math.max(count, curCommonSubsequence);
//            }
//        }
//        return count;
//    }
//
//	private int getLongestCommonSubSequenceFromPosition(String text2, char[] arr1, int i, int foundIndexInText2) {
//		System.out.println("index of " + arr1[i] + " is " + foundIndexInText2);
//		int curCount = 1;
//		int curIndexInText2 = foundIndexInText2 + 1;
//		int j = i + 1;
//		while (j < arr1.length && curIndexInText2 < text2.length()) {
//			int nextIndexInText2 = text2.indexOf(arr1[j], curIndexInText2);
//			System.out.println("index of " + arr1[j] + " is " + nextIndexInText2);
//		    if (nextIndexInText2 >= 0) {
//		    	curIndexInText2 = nextIndexInText2 + 1;
//		    	curCount++;
//		    }
//			j++;
//		}
//		return curCount;
//	}
//}

class LongestCommonSubSequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();        
        char[] arr2 = text2.toCharArray();
        
        int[][] counter = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    counter[i][j] = 1 + counter[i - 1][j - 1];
                } else {
                    counter[i][j] = Math.max(counter[i][j - 1], counter[i - 1][j]);
                }
            }
        }
        return counter[arr1.length][arr2.length];
    }
}