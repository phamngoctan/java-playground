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

	public void toStringFollowingInsertionOrder() {
		// TODO Auto-generated method stub
		
	}
}
