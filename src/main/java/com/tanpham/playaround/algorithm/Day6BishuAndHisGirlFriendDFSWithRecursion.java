package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * MINUMUM DISTANCE
 * but DFS not sure that the way is minimum. Why can we still use this approach for this exercise?
 * 
 * Because of the sentence (depicting a tree), so only one way we can travel back. 
 * We can use DFS in this exercise, otherwise, we have to use BFS.
 *
 */
public class Day6BishuAndHisGirlFriendDFSWithRecursion {

	private static List<List<Integer>> graph;
	private static List<Integer> path;
	private static List<Boolean> visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalEdges = sc.nextInt();
		graph = new ArrayList<>();
		for (int i = 0; i < totalEdges; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < totalEdges - 1; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		int totalGirls = sc.nextInt();
		List<Integer> girls = new ArrayList<>();
		for (int i = 0; i < totalGirls; i++) {
			girls.add(sc.nextInt() - 1);
		}
		
		path = new ArrayList<>();
		visited = new ArrayList<>();
		for (int i = 0; i < totalEdges; i++) {
			path.add(-1);
			visited.add(false);
		}
		sc.close();
		
		int s = 0;
		DFSRecursion(s);
		int min = Integer.MAX_VALUE;
		int minId = Integer.MAX_VALUE;
		for (int i = 0; i < totalGirls; i++) {
			Integer girlCountryId = girls.get(i);
			List<Integer> edges = getPath(girlCountryId, 0);
			Integer curMin = edges.size();
			if (curMin < min) {
				min = curMin;
				minId = girlCountryId;
			} else if (curMin.equals(min) && girlCountryId < minId) {
				minId = girlCountryId;
			}
		}
		System.out.println(minId + 1);
	}

	private static List<Integer> getPath(Integer girlCountry, Integer bishuCountry) {
		List<Integer> direction = new ArrayList<>();
		Integer cur = girlCountry;
		while (true) {
			direction.add(cur);
			if (cur == -1) {
				return Collections.emptyList();
			} else if (cur == bishuCountry) {
				return direction;
			}
			cur = path.get(cur);
		}
	}

	private static void DFSRecursion(int s) {
		visited.set(s, true);
		for (int i = 0; i < graph.get(s).size(); i++) {
			int v = graph.get(s).get(i);
			if (!visited.get(v)) {
				path.set(v, s);
				DFSRecursion(v);
			}
		}
	}

}
