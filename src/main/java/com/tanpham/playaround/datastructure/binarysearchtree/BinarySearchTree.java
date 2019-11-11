package com.tanpham.playaround.datastructure.binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> {
	private Node<T> root;

	public Node<T> getRoot() {
		return root;
	}

	public void insert(T value) {
		if (value == null) {
			throw new RuntimeException("Please input non-null value");
		}
		Node<T> newNode = new Node<>(value);
		if (root == null) {
			root = newNode;
		} else {
			insert(root, newNode);
		}
	}
	
	private void insert(Node<T> root, Node<T> newNode) {
		if (root == null) {
			root = newNode;
			return;
		}

		if (root.getData().compareTo(newNode.getData()) == 1) {
			if (root.getLeftChild() == null) {
				root.setLeftChild(newNode);
			} else {
				insert(root.getLeftChild(), newNode);
			}
		} else {
			if (root.getRightChild() == null) {
				root.setRightChild(newNode);
			} else {
				insert(root.getRightChild(), newNode);
			}
		}
	}

	public String toStringFollowingPreOrder() {
		if (root == null) {
			return null;
		}
		
		return toStringFollowingPreOrder(root).trim().replaceAll(" +", " ");
	}
	
	private String toStringFollowingPreOrder(Node<T> node) {
//		System.out.println(node.getData());
		String rootData = node.getData().toString();
		String leftData = null;
		if (node.getLeftChild() != null) {
			leftData = toStringFollowingPreOrder(node.getLeftChild());
		}
		
		String rightData = null;
		if (node.getRightChild() != null) {
			rightData = toStringFollowingPreOrder(node.getRightChild());
		}
		return rootData + " " + (leftData == null ? "" : leftData) + " " + (rightData == null ? "" : rightData);
	}
}
