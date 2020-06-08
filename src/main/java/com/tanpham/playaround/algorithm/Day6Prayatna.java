package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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
		List<Long> res = new ArrayList<>();
		for (int i = 0; i < totalTestCases; i++) {
			res.add(handleOneTestCase_calculatePeopleNeededToMeetInPerson(sc));
		}
		
		res.forEach(i -> {
			System.out.println(i);
		});
		sc.close();
	}

	private static long handleOneTestCase_calculatePeopleNeededToMeetInPerson(Scanner sc) {
		int totalVertexes = sc.nextInt();
		int totalEdges = sc.nextInt();
		if (totalEdges == 0) {
			return totalVertexes;
		}
		
		graph = new ArrayList<>();
		path = new ArrayList<>();
		visited = new ArrayList<>();
		for (int i = 0; i < totalVertexes; i++) {
			visited.add(false);
			path.add(-1);
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < totalEdges; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for (int i = 0; i < totalVertexes; i++) {
			if (path.get(i) == -1) {
				DFS(i);
			}
		}
		
		//System.out.println(path);
		
		return path.stream().filter(i -> i == -1).count();
	}

	private static void DFS(int startingPoint) {
		visited.set(startingPoint, true);
		Stack<Integer> s = new Stack<>();
		s.push(startingPoint);
		
		while (!s.isEmpty()) {
			Integer cur = s.pop();
			List<Integer> relatedVertexes = graph.get(cur);
			for (int i = 0; i < relatedVertexes.size(); i++) {
				Integer curVertex = relatedVertexes.get(i);
				if (!visited.get(curVertex)) {
					path.set(curVertex, cur);
					visited.set(curVertex, true);
					s.push(curVertex);
				}
			}
		}
	}

}
