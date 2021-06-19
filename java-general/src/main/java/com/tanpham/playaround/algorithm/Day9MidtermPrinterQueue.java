package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Day9MidtermPrinterQueue {
	
	static class Node {
		public int priority;
		public int position;
		public Node(int priority, int pos) {
			this.priority = priority;
			this.position = pos;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalTestCases = sc.nextInt();
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < totalTestCases; i++) {
			res.add(handleATestCase(sc));
		}
		
		res.forEach(System.out::println);
	}

	private static Integer handleATestCase(Scanner sc) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		Queue<Node> q = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			int u = sc.nextInt();
			q.add(new Node(u, i));
			pq.add(u);
		}
		int totalTime = 0;
		while (!pq.isEmpty()) {
			Integer curMax = pq.poll();
			Node cur = q.poll();
			while (cur.priority != curMax) {
				q.add(cur);
				cur = q.poll();
			}
			 
			if (curMax == cur.priority) {
				totalTime++;
				if (cur.position == m) {
					break;
				}
			}
		}
		return totalTime;
	}

}
