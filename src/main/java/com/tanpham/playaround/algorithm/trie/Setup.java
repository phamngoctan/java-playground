package com.tanpham.playaround.algorithm.trie;

public class Setup {
	
	static class Node {
		static final int MAX = 26;
		public Node[] child;
		public int countWord;
		public Node() {
			countWord = 0;
			child = new Node[MAX];
		}
	}

	static class Trie {
		static final int MAX = 26;
		private Node root;
		public Trie() {
			root = new Node();
		}
		
		public void addWord(String s) {
			int ch;
			Node temp = root;
			for (int i = 0; i < s.length(); i++) {
				ch = s.charAt(i) - 'a';
				if (temp.child[ch] == null) {
					Node x = new Node();
					temp.child[ch] = x;
				}
				temp = temp.child[ch];
			}
			temp.countWord++;
		}
		
		public boolean findWord(String s) {
			int ch;
			Node temp = root;
			for (int i = 0; i < s.length(); i++) {
				ch = s.charAt(i) - 'a';
				if (temp.child[ch] == null) {
					return false;
				}
				temp = temp.child[ch];
			}
			return temp.countWord > 0;
		}
		
		private boolean isWord(Node node) {
			return node.countWord != 0;
		}
		
		private boolean isEmpty(Node node) {
			for (int i = 0; i < MAX; i++) {
				if (node.child[i] != null) {
					return false;
				}
			}
			return true;
		}
		
		public boolean removeWord(String s) {
			return removeWord(root, s, 0, s.length());
		}

		private boolean removeWord(Node inputRoot, String s, int level, int length) {
			if (inputRoot == null) {
				return false;
			}
			
			if (level == length) {
				if (inputRoot.countWord > 0) {
					root.countWord--;
					return true;
				}
				return false; // in case the last char does not match the 
			}
			
			int ch = s.charAt(level) - 'a';
			boolean flag = removeWord(root.child[ch], s, level + 1, length);
			if (flag && !isWord(root.child[ch]) && isEmpty(root.child[ch])) {
				root.child[ch] = null;
			}
			return flag;
		}
		
		public void printWord(Node root) {
			printWord(root, "");
		}

		private void printWord(Node inputRoot, String s) {
			if (isWord(root)) {
				System.out.println(s);
			}
			for (int i = 0; i < MAX; i++) {
				if (root.child[i] != null) {
					printWord(inputRoot, s + (char)('a' + i));
				}
			}
		}
	}
	
}

