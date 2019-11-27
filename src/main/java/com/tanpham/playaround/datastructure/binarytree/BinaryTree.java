package com.tanpham.playaround.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

	private TreeNode<T> root;
	
	public BinaryTree() {
		// empty constructor
	}
	
	public BinaryTree(T rootValue) {
		root = new TreeNode<>();
		root.setValue(rootValue);
	}
	
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public String getTreeByLevelOrderTravelling() {
		if (root == null) {
			return null;
		}
		
		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		String result = "";
		while (!queue.isEmpty()) {
			TreeNode<T> currentNode = queue.poll();
			result = result + " " + currentNode.getValue().toString();
			if (currentNode.getLeftChild() != null) {
				queue.add(currentNode.getLeftChild());
			}
			if (currentNode.getRightChild() != null) {
				queue.add(currentNode.getRightChild());
			}
		}
		
		return result.trim().replaceAll(" +", " ");
	}
}
