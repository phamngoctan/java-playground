package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Day5BreadthFirstSearchShortestReach {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfQueries = sc.nextInt();
		List<String> queriesDistances = new ArrayList<>();
		for (int i = 0; i < numberOfQueries; i++) {
			int totalNodes = sc.nextInt();
			int totalEdges = sc.nextInt();
			List<List<Integer>> edges = new ArrayList<>();
			for (int j = 0; j < totalEdges; j++) {
				edges.add(Arrays.asList(sc.nextInt(), sc.nextInt()));
			}
			List<Integer> distances = getDistance(totalNodes, edges, sc.nextInt());
			queriesDistances.add(distances.stream().map(item -> item.toString()).collect(Collectors.joining(" ")));
		}
		
		for (int i = 0; i < queriesDistances.size(); i++) {
			System.out.println(queriesDistances.get(i));
		}
		sc.close();
	}
	
	public static List<Integer> getDistance(int totalNodes, List<List<Integer>> edges, int fromNode) {
		List<Set<Integer>> graph = fromEdgesToGraph(totalNodes, edges);
		List<Integer> path = getPath(totalNodes, graph, fromNode);
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= totalNodes; i++) {
			if (i == fromNode) {
				continue;
			}
			List<Integer> shortestPathTo = printPath(path, fromNode, i);
			if (shortestPathTo.isEmpty()) {
				result.add(-1);
			} else {
				result.add((shortestPathTo.size() - 1) * 6);
			}
		}
		return result;
	}

	public static List<Integer> getPath(int totalNodes, List<Set<Integer>> graph, int fromNode) {
		//System.out.println(graph);
		// prepare for single graph
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> path = new ArrayList<>();
		List<Boolean> visited = new ArrayList<>();
		for (int i = 0; i <= totalNodes; i++) {
			visited.add(false);
			path.add(-1);
		}
		visited.set(fromNode, true);
		queue.add(fromNode);
		
		while (!queue.isEmpty()) {
			int u = queue.poll();
			graph.get(u).stream().forEach(v -> {
				if (!visited.get(v)) {
					visited.set(v, true);
					queue.add(v);
					path.set(v, u);
				}
			});
		}
		
		//System.out.println(path);
		
		return path;
	}

	protected static List<Set<Integer>> fromEdgesToGraph(int totalNodes, List<List<Integer>> edges) {
		List<Set<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= totalNodes; i++) {
			graph.add(new LinkedHashSet<>());
		}
		
		for (List<Integer> pairEdges : edges) {
			graph.get(pairEdges.get(0)).add(pairEdges.get(1));
			graph.get(pairEdges.get(1)).add(pairEdges.get(0));
		}
		return graph;
	}
	
	public static List<Integer> printPath(List<Integer> path, int fromNode, int toNode) {
		if (fromNode == toNode) {
			return Collections.emptyList();
		}
		
		if (path.get(toNode) == -1) {
			//System.out.println(String.format("No path from %s to %s", fromNode, toNode));
			return Collections.emptyList();
		}
		
		List<Integer> direction = new ArrayList<>();
		int m = 0;
		while (true) {
			direction.add(m++, toNode);
			// switch the toNode to the target one until reach the fromNode
			toNode = path.get(toNode);
			if (fromNode == toNode) {
				direction.add(m++, toNode);
				Collections.reverse(direction);
				return direction;
			} else if (toNode == -1) {
				return Collections.emptyList();
			}
		}
	}
	
}
