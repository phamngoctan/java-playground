package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * NOTE: without reversing the graph, the timeout will happen.
 * 
 * Some test cases I used
 * 
 * 
 * 

4
2
1
8
1 2 1
1 3 1
2 1 1
2 4 1
3 1 1
3 4 1
4 2 1
4 3 1


2
1
3
2
2 1 5
2 1 3


2
1
999999999
2
1 2 1000000000
2 1 1000000000

 */
public class Day8MiceAndMaze {
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
	private static int[] path;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int exitPoint = sc.nextInt() - 1;
		int time = sc.nextInt();
		
		graph = new ArrayList<>();
		graph = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		
		int E = sc.nextInt();
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
//			graph.get(u - 1).add(new Node(v - 1, w));
			// REVERSE GRAPH
			graph.get(v - 1).add(new Node(u - 1, w));
		}
		sc.close();
		
		int count = 0;
		//System.out.println(Arrays.toString(path));
		//System.out.println(Arrays.toString(dist));
//		for (int i = 0; i < V; i++) {
//			if (i == exitPoint) {
//				count++;
//			} else {
//				dijkstra(i);
//				if (dist[exitPoint] <= time) {
//					count++;
//				}
//			}
//		}
		dijkstra(exitPoint);
		for (int i = 0; i < V; i++) {
			if (i == exitPoint) {
				count++;
			} else if (dist[i] <= time) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static void dijkstra(int exitPoint) {
		int V = graph.size();
		path = new int[V];
		dist = new long[V];
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
			path[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(exitPoint, 0));
		while (!pq.isEmpty()) {
			Node top = pq.poll();
			int u = top.id;
			long w = top.dist;
			for (int i = 0; i < graph.get(u).size(); i++) {
				Node neighbor = graph.get(u).get(i);
				if (neighbor.dist + w < dist[neighbor.id]) {
					dist[neighbor.id] = neighbor.dist + w;
					path[neighbor.id] = u;
					pq.add(new Node(neighbor.id, dist[neighbor.id]));
				}
			}
		}
	}
}
