package com.tanpham.playaround.algorithm.binarysearch;

import java.util.Arrays;

/**
 * NOTES:
 * - overflow when calculating mid
 * - binary search with first matched value (https://thebittheories.com/the-curious-case-of-binary-search-the-famous-bug-that-remained-undetected-for-20-years-973e89fc212)
 * - binary search with last matched value
 * - lower bound
 * - upper bound
 */
public class Setup {

	public static void main(String[] args) {
		int[] arr = new int[] {
				1, 2, 5, 9, 10, 100, 1000, 1400
		};
		int res = binarySearch(arr, 0, arr.length - 1, 2);
		if (res == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("Found");
		}
		
		int[] arrFirstMatched = new int[] {
				1, 1, 1, 1, 1
		};
		Arrays.sort(arrFirstMatched);
		System.out.println("Input arr: " + Arrays.toString(arrFirstMatched));
		int binarySearchFirstMatched = binarySearchFirstMatched(arrFirstMatched, 0, 4, 1);
		if (binarySearchFirstMatched == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("binarySearchFirstMatched: Found at (should be 1) " + (binarySearchFirstMatched + 1));
		}
		
		int binarySearchLastMatched = binarySearchLastMatched(arrFirstMatched, 0, arrFirstMatched.length - 1, 1);
		if (binarySearchLastMatched == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("binarySearchLastMatched: Found at (should be 5) " + (binarySearchLastMatched + 1));
		}
		
		int binarySearchSecondLastMatched = binarySearchSecondLastMatched(arrFirstMatched, 0, arrFirstMatched.length - 1, 1);
		if (binarySearchSecondLastMatched == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("binarySearchSecondLastMatched: Found at (should be 4) " + (binarySearchSecondLastMatched + 1));
		}
		
		int binarySearchSecondFirstMatched = binarySearchSecondFirstMatched(arrFirstMatched, 0, arrFirstMatched.length - 1, 1);
		if (binarySearchSecondFirstMatched == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("binarySearchSecondFirstMatched: Found at (should be 2) " + (binarySearchSecondFirstMatched + 1));
		}
		
		int[] arrUpperBound = new int[]{1, 4, 5, 7, 7, 7, 7, 9};
		int binarySearchUpperBound = binarySearchUpperBound(arrUpperBound, 0, arrUpperBound.length - 1, 7);
		if (binarySearchUpperBound == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("binarySearchSecondFirstMatched: Found at (should be 6) " + (binarySearchUpperBound + 1));
		}
		
		int binarySearchUpperBound2 = binarySearchUpperBound(arrUpperBound, 0, arrUpperBound.length - 1, 8);
		if (binarySearchUpperBound2 == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("binarySearchSecondFirstMatched: Found at (should be 7) " + (binarySearchUpperBound2 + 1));
		}
		
		int binarySearchUpperBound3 = binarySearchUpperBound(arrUpperBound, 0, arrUpperBound.length - 1, 6);
		if (binarySearchUpperBound3 == -1) {
			System.out.println("Not found!");
		} else {
			System.out.println("binarySearchSecondFirstMatched: Found at (should be 3) " + (binarySearchUpperBound3 + 1));
		}
		
	}

	private static int binarySearch(int[] arr, int left, int right, int valueToBeChecked) {
		int mid;
		while (left <= right) {
			//mid = (left + right) / 2; // NONO: 20 years to be fixed, overflow possibly
			mid = left + (right - left) / 2;
			if (valueToBeChecked < arr[mid]) {
				right = mid - 1;
			} else if (valueToBeChecked == arr[mid]) {
				return mid;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	private static int binarySearchFirstMatched(int[] arr, int left, int right, int valueToBeChecked) {
		while (left <= right) {
			int mid = left + (right - left)/2;
			if ((mid == left || valueToBeChecked > arr[mid - 1])
					&& valueToBeChecked == arr[mid]) {
				return mid;
			}
			// Be carefull with the order of IF statement
//			else if (valueToBeChecked > arr[mid]) {
//				right = mid - 1;
//			} else {
//				left = mid + 1;
//			}
			 else if (valueToBeChecked > arr[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	private static int binarySearchLastMatched(int[] arr, int left, int right, int valueToBeChecked) {
		int mid;
		while (left <= right) {
			mid = left + (right - left)/2;
			if (valueToBeChecked == arr[mid] && (mid == right || valueToBeChecked < arr[mid + 1])) {
				return mid;
			} else if (valueToBeChecked < arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	private static int binarySearchSecondLastMatched(int[] arr, int left, int right, int valueToBeChecked) {
		while (left <= right) {
			int mid = left + (right - left)/2;
			if ((mid == left || valueToBeChecked > arr[mid - 1])
					&& valueToBeChecked == arr[mid]) {
				return mid;
			} 
			else if (valueToBeChecked > arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	// NOT tested
	private static int binarySearchSecondFirstMatched(int[] arr, int left, int right, int x) {
		while (left <=  right) {
			int mid = left + (right - left)/2;
			if ((mid == right - 1
					 || x < arr[mid + 1])
					&& x == arr[mid]) {
				return right;
			} else if (x > arr[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	private static int binarySearchUpperBound(int[] arr, int left, int right, int target) {
		if (arr == null || arr.length == 0) {
            return 0;
        }
        if (target < arr[0]) {
            return -1;
        }
        
        if (target >= arr[right]) {
            return right;
        }
        
        while (left < right - 1) {
        	int mid = left + (right - left)/2;
        	if (arr[mid] <= target) {
        		left = mid;
        	} else {
        		right = mid - 1;
        	}
        }
        return arr[right] <= target ? right : left;
	}
	
	private static int binarySearchLowerBound(int[] arr, int left, int right, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (target <= arr[0]) {
            return 0;
        }
        if (target > arr[right]) {
            return -1;
        }
        while (left  <  right) {
            int m = left + (right - left ) / 2 ;

            if (arr[m] >= target) {
                right = m;
            }else {
                left = m + 1;
            }
        }
        return right;
    }
	
}
