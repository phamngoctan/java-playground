package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day4ProcessingQueries {
	
	public static List<Integer> getServerProcessedTime(List<List<Integer>> requests, int totalAllowedQueue) {
		Queue<List<Integer>> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		int previousMoment = 0;
		for (List<Integer> request : requests) {
			if (queue.size() == totalAllowedQueue) {
				result.add(-1);
				continue;
			}
			queue.add(request);
			
			if (queue.isEmpty()) {
				result.add(request.get(0) + request.get(1));
			} else {
				
			}
			
			List<Integer> fromQueue = queue.poll();
			result.add(fromQueue.get(0) + fromQueue.get(1));
		}
		return result;
	}

}
