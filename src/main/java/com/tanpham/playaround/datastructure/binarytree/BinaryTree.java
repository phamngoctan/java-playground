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

	// Breadth-first search
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

	// 3 Deep-first search approaches
	/**
	 * left/self/right
	 */
	public String getTreeByInOrder() {
		return getTreeInOrder(root).trim().replaceAll(" +", " ");
	}
	
	private String getTreeInOrder(TreeNode<T> node) {
		// Stop point
		if (node == null) {
			return "";
		}
		
		String result = "";
		if (node.getLeftChild() != null) {
			result = result + " " + getTreeInOrder(node.getLeftChild());
		}
		result = result + " " + node.getValue().toString();
		if (node.getRightChild() != null) {
			result = result + " " + getTreeInOrder(node.getRightChild());
		}
		
		return result;
	}

	
	/**
	 * self/left/right
	 */
	public String getTreeByPreOrder() {
		return getTreeByPreOrder(root).trim().replaceAll(" +", " ");
	}
	
	private String getTreeByPreOrder(TreeNode<T> node) {
		// Stop point
		if (node == null) {
			return "";
		}
		
		String result = "";
		result = result + " " + node.getValue().toString();
		
		if (node.getLeftChild() != null) {
			result = result + " " + getTreeByPreOrder(node.getLeftChild());
		}
		
		if (node.getRightChild() != null) {
			result = result + " " + getTreeByPreOrder(node.getRightChild());
		}
		
		return result;
	}

	/**
	 * left/right/self
	 */
	public String getTreeByPostOrder() {
		return getTreeByPostOrder(root).trim().replaceAll(" +", " ");
	}
	
	private String getTreeByPostOrder(TreeNode<T> node) {
		// Stop point
		if (node == null) {
			return "";
		}
		
		String result = "";
		
		if (node.getLeftChild() != null) {
			result = result + " " + getTreeByPostOrder(node.getLeftChild());
		}
		
		if (node.getRightChild() != null) {
			result = result + " " + getTreeByPostOrder(node.getRightChild());
		}
		
		result = result + " " + node.getValue().toString();
		
		return result;
	}
	
}
