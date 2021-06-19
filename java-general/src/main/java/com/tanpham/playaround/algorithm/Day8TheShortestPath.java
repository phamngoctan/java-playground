package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day8TheShortestPath {

	static class Node implements Comparable<Node> {

		public Integer id;
		public Long dist;
		
		public Node(int id, long dist) {
			this.id = id;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return dist.compareTo(o.dist);
		}
		@Override
		public String toString() {
			return "Node [id=" + id + ", dist=" + dist + "]";
		}
	}
	
	private static List<List<Node>> graph;
	private static long[] dist;
	private static List<Integer> path;
	private static Map<String, Integer> nameByVertex;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalTestCases = sc.nextInt();
		List<Long> res = new ArrayList<>();
		for (int i = 0; i < totalTestCases; i++) {
			res.addAll(handleATestCase(sc));
			sc.nextLine();
		}
		sc.close();
		
		res.forEach(i -> {
			System.out.println(i);
		});
	}

	private static List<Long> handleATestCase(Scanner sc) {
		int V = sc.nextInt();
		
		graph = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		nameByVertex = new HashMap<>();
		
		for (int i = 1; i <= V; i++) {
			inputAVertex(sc, i);
		}
		
		List<Long> res = new ArrayList<>();
		int totalCheckPoints = sc.nextInt();
		for (int i = 0; i < totalCheckPoints; i++) {
			String city1 = sc.next();
			String city2 = sc.next();
			
			Integer city1Id = nameByVertex.get(city1);
			Integer city2Id = nameByVertex.get(city2);
			dijkstra(city1Id);
			if (path.get(city2Id) != -1) {
				res.add(dist[city2Id]);
			} else {
				throw new RuntimeException("cannot find the path from " + city1 + " to " + city2);
			}
		}
		return res;
	}

	private static void inputAVertex(Scanner sc, int curVertex) {
		String name = sc.next();
		nameByVertex.put(name, curVertex - 1);
		
		int E = sc.nextInt();
		for (int i = 0; i < E; i++) {
			int v = sc.nextInt();
			int w = sc.nextInt();
			graph.get(curVertex - 1).add(new Node(v - 1, w));
		}
	}
	
	private static void dijkstra(int startingPoint) {
		int V = graph.size();
		path = new ArrayList<>();
		dist = new long[V];
		for (int i = 0; i < V; i++) {
			path.add(-1);
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(startingPoint, 0));
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			long w = top.dist;
			for (int i = 0; i < graph.get(u).size(); i++) {
				Node neighbor = graph.get(u).get(i);
				if (neighbor.dist + w < dist[neighbor.id]) {
					dist[neighbor.id] = neighbor.dist + w;
					path.set(neighbor.id, u);
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
				}
			}
		}
	}
}
