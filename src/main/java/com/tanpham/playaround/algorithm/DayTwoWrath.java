package com.tanpham.playaround.algorithm;

public class DayTwoWrath {

	/*
	 * Implementation idea:
	 * - ans = n - n_killed
	 * - last_pos_killed
	 * - j is farest_pos_of_claw -- j < last_pos_killed: (last_pos_killed - i)
	 *                           -- j >= last_pos_killed: 0
	 *                     
	 * 1 2 3 4 5 6 7 8 9 10
	 * 1 1 3 0 0 0 2 1 0 3
	 * hand running:
	 * for (length -> 0)
	 *   at pos_10:
	 *     n_killed = 3;
	 *     last_pos_killed = 7;
	 *     j = 7;
	 *     
	 *   at pos 9:
	 *     n_killed = 3
	 *     last_pos_killed = 7
	 *     j = 9;
	 *     
	 *   at pos 8:
	 *     n_killed = 3
	 *     last_pos_killed = 7
	 *     j = 7;
	 *     
	 *   at pos 7:
	 *     n_killed = 3 + 2
	 *     last_pos_killed = 7
	 *     j = 5;
	 *     
	 */
	public static int countAlivePeople(int[] arr) {
		int arrLength = arr.length;
		int killedPeople = 0;
		int lastPosKilled = arrLength - 1;
		int j = 0;
		for (int i = arrLength - 1; i >= 0; i-- ) {
			
		}
		return 0;
	}
	
}
