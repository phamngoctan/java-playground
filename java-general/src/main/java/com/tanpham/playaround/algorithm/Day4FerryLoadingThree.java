package com.tanpham.playaround.algorithm;

public class Day4FerryLoadingThree {

	/*
	 * In one test case:
	 * qLeft, qRight;
	 * read n, t, m
	 * 
	 * class Car:
	 *   id (sequence in input)
	 *   arrive_time
	 * 
	 * Put the Car object to the correct qLeft or qRight with ID (1 -> m)
	 * Queue<Car> qLeft;
	 * Queue<Car> qRight;
	 * 
	 * Simulate the ferry:
	 * cur_side = "left";
	 * cur_time = 0;
	 * is_waiting = !qLeft.empty() + !qRight.empty();
	 *   it can be 0, 1, 2
	 * 
	 * while (is_waiting != 0)
	 *   if (is_waiting == 1)
	 *     if (!qLeft.empty()) 
	 *       next_time = qLeft[0].arrive_time;
	 *     else
	 *       next_time = qRight[0].arrive_time;
	 *   else 
	 *     next_time = min(qLeft[0].arrive_time, qRight[0].arrive_time);
	 *     
	 *   if (cur_time < next_time)
	 *     cur_time = next_time
	 *     
	 *   if (cur_side == "left")
	 *     carried = 0;
	 *     while (!qLeft.empty())
	 *       if (qLeft.arrive_time <= cur_time && carried < n)
	 *         result[qLeft[0].id] = cur_time + t;
	 *         qLeft.pop();
	 *         carried++;
	 *       else
	 *         break;
	 *   else 
	 *     // qLeft -> qRight
	 *     
	 *   cur_time = cur
	 *   ...
	 *   
	 *   printing:
	 *   for i in range (m)
	 *     print(result[i]);
	 *         
	 *         
	 * For making it easier, change the qLeft, qRight to a q[[][]]
	 * cur_side = 0; changing it by cur_side = 1 - cur_side
	 * 
	 * q[[cur_side][0]]
	 */
	
}
