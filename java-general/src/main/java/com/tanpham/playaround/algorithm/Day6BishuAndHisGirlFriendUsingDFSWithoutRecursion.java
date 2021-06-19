package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day6BishuAndHisGirlFriendUsingDFSWithoutRecursion {
	private static List<List<Integer>> graph;
	private static List<Integer> path;
	private static List<Boolean> visited;
	private static int V;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		graph = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < V - 1; i++) {
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
		sc.close();
		
		int s = 0;
		DFS(s);
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

	private static void DFS(int s) {
		path = new ArrayList<>();
		visited = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			path.add(-1);
			visited.add(false);
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		visited.set(s, true);
		while (!stack.isEmpty()) {
			Integer cur = stack.pop();
			List<Integer> relatedVertex = graph.get(cur);
			for (int i = 0; i < relatedVertex.size(); i++) {
				Integer curVertex = relatedVertex.get(i);
				if (!visited.get(curVertex)) {
					visited.set(curVertex, true);
					path.set(curVertex, cur);
					stack.push(curVertex);
				}
			}
		}
	}

}
