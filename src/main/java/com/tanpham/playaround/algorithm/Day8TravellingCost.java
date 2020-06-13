package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day8TravellingCost {
	
	static class Node implements Comparable<Node> {

		public Integer id;
		public Integer dist;
		
		public Node(int id, int dist) {
			this.id = id;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return dist.compareTo(o.dist);
		}
		
	}


	private static List<List<Node>> graph;
	private static int[] dist;
	private static int[] path;
	
	public static void main(String[] args ) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		graph = new ArrayList<>();
		for (int i = 0; i < 501; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			graph.get(a).add(new Node(b, w));
			graph.get(b).add(new Node(a, w));
		}
		
		int starting = sc.nextInt();
		int totalQueryCost = sc.nextInt();
		int[] queryCost = new int[totalQueryCost];
		for (int i = 0; i < totalQueryCost; i++) {
			queryCost[i] = sc.nextInt();
		}
		sc.close();
		
		dijkstra(starting);
		//System.out.println(Arrays.toString(path));
		//System.out.println(Arrays.toString(dist));
		for (int i = 0; i < queryCost.length; i++) {
			int from = queryCost[i];
			travelToRoot(from, starting);
		}
	}

	private static void travelToRoot(int from, int to) {
		if (from == to) {
			System.out.println(0);
			return;
		} else if (path[from] != -1) {
			System.out.println(dist[from]);
		} else {
			System.out.println("NO PATH");
		}
	}

	private static void dijkstra(int starting) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int n = graph.size();
		dist = new int[n];
		path = new int[n];
		
		for (int i = 0; i < 501; i++) {
			dist[i] = Integer.MAX_VALUE;
			path[i] = -1;
		}
		
		Node startingNode = new Node(starting, 0);
		pq.add(startingNode);
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			int w = top.dist;
			for (int i = 0; i < graph.get(u).size(); i++) {
				Node neighbor = graph.get(u).get(i);
				if (neighbor.dist + w < dist[neighbor.id]) {
					dist[neighbor.id] = neighbor.dist + w;
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
					path[neighbor.id] = u;
				}
			}
		}
	}
	
}

