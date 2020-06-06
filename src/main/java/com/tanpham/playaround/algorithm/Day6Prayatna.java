package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main idea: count so do thi lien thong
 */
public class Day6Prayatna {
	
	private static List<List<Integer>> graph;
	private static List<Boolean> visited;
	private static List<Integer> path;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalTestCases = sc.nextInt();
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < totalTestCases; i++) {
			res.add(handleOneTestCase(sc));
		}
		
		res.forEach(i -> {
			System.out.println(i);
		});
		sc.close();
	}

	private static int handleOneTestCase(Scanner sc) {
		int totalPeople = sc.nextInt();
		int totalEdges = sc.nextInt();
		if (totalEdges == 0) {
			return totalPeople;
		}
		
		graph = new ArrayList<>();
		path = new ArrayList<>();
		for (int i = 0; i < totalPeople; i++) {
			graph.add(new ArrayList<>());
			path.add(-1);
		}
		
		for (int i = 0; i < totalEdges; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		
		
		return 0;
	}

}
