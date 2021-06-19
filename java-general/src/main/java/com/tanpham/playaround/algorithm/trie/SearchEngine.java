package com.tanpham.playaround.algorithm.trie;

import java.util.Scanner;

public class SearchEngine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int queries = sc.nextInt();
		sc.nextLine();
		
		Trie trie = new Trie();
		for (int i = 0; i < total; i++) {
			String[] line = sc.nextLine().split(" ");
			//System.out.println(Arrays.toString(line));
			trie.addWord(line[0], Integer.parseInt(line[1]));
		}
		//System.out.println(Arrays.toString(arr));
		for (int i = 0; i < queries; i++) {
			String cur = sc.nextLine();
			//System.out.println(cur);
			System.out.println(trie.findString(cur));
		}
		sc.close();
	}
	
	static class Node {
		static final int MAX = 26;
		public Node[] child;
		public int maxWeight;
		public Node() {
			maxWeight = 0;
			child = new Node[MAX];
		}
	}

	static class Trie {
		static final int MAX = 26;
		private Node root;
		public Trie() {
			root = new Node();
		}
		
		public void addWord(String s, int weight) {
			int ch;
			Node temp = root;
			for (int i = 0; i < s.length(); i++) {
				ch = s.charAt(i) - 'a';
				if (temp.child[ch] == null) {
					Node x = new Node();
					temp.child[ch] = x;
				}
				temp = temp.child[ch];
				temp.maxWeight = Math.max(temp.maxWeight, weight);
			}
		}
		
		public int findString(String s) {
			int ch;
			Node temp = root;
			for (int i = 0; i < s.length(); i++) {
				ch = s.charAt(i) - 'a';
				if (temp.child[ch] == null) {
					return -1;
				}
				temp = temp.child[ch];
			}
			return temp.maxWeight;
		}
	}
	
}
