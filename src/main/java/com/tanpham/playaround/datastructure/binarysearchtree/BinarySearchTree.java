package com.tanpham.playaround.datastructure.binarysearchtree;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>> {
	private static final String ONE_SPACE = " ";
	private static final String REGEX_MULTIPLE_SPACES = " +";
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

		if (root.getData().compareTo(newNode.getData()) > 0) {
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
			return "";
		}
		
		return toStringFollowingPreOrder(root).trim().replaceAll(REGEX_MULTIPLE_SPACES, ONE_SPACE);
	}
	
	private String toStringFollowingPreOrder(Node<T> node) {
		String rootData = node.getData().toString();
		String leftData = null;
		if (node.getLeftChild() != null) {
			leftData = toStringFollowingPreOrder(node.getLeftChild());
		}
		
		String rightData = null;
		if (node.getRightChild() != null) {
			rightData = toStringFollowingPreOrder(node.getRightChild());
		}
		return rootData + ONE_SPACE + (leftData == null ? "" : leftData) + ONE_SPACE + (rightData == null ? "" : rightData);
	}

	public void delete(T value) {
		if (root == null) {
			return;
		}
		Node<T> previous = null;
		Node<T> next = root;
		while (next != null) {
			int compareTo = next.getData().compareTo(value);
			if (compareTo == 0) {
				deleteNode(previous, next);
				break;
			} else if (compareTo > 0) {
				previous = next;
				next = next.getLeftChild();
			} else {
				previous = next;
				next = next.getRightChild();
			}
		}
	}

	private void deleteNode(Node<T> previous, Node<T> next) {
		if (next.getType() == NodeType.LEAVE) {
			// in case root equals the input value
			if (previous == null) {
				root = null;
			} else {
				previous.delete(next);
			}
			return;
		} else if (next.getType() == NodeType.SINGLE_LEFT_CHILD) {
			Node<T> leftChild = next.getLeftChild();
			previous.setLeftChild(leftChild);
			next.setLeftChild(null);
		} else if (next.getType() == NodeType.SINGLE_RIGHT_CHILD) {
			Node<T> rightChild = next.getRightChild();
			previous.setRightChild(rightChild);
			next.setRightChild(null);
		} else {
			Node<T> smallestRightNode = popSmallestNodeOfRightChild(next, next.getRightChild());
			next.setData(smallestRightNode.getData());
		}
	}
	
	public T findSmallestValue() {
		if (root == null) {
			return null;
		}
		
		Node<T> next = root;
		while(next.getLeftChild() != null) {
			next = next.getLeftChild();
		}
		return next.getData();
	}
	
	/**
	 * Because the idea of this method is of finding the smallest node, so the previous node cannot be null
	 */
	private Node<T> popSmallestNodeOfRightChild(Node<T> previousOfCheckingNode, Node<T> node) {
		Objects.requireNonNull(previousOfCheckingNode);
		if (node == null) {
			return null;
		}
		
		Node<T> previous = previousOfCheckingNode;
		Node<T> next = node;
		// in case the input node is the smallest one
		if (next.getLeftChild() == null) {
			previous.setRightChild(next.getRightChild());
			next.setRightChild(null);
			return next;
		}
		
		while (next.getLeftChild() != null) {
			previous = next;
			next = next.getLeftChild();
		}
		// Do the popping node out of the tree
		previous.setLeftChild(null);
		return next;
	}

	public String getValue() {
		if (root == null) {
			return null;
		}
		
		return getValue(root).trim().replaceAll(REGEX_MULTIPLE_SPACES, ONE_SPACE);
	}

	private String getValue(Node<T> node) {
		String treeValue = "";
		if (node.getLeftChild() != null) {
			treeValue += getValue(node.getLeftChild()) + ONE_SPACE;
		}
		
		treeValue += ONE_SPACE + node.getData();
		
		if (node.getRightChild() != null) {
			treeValue += getValue(node.getRightChild()) + ONE_SPACE;
		}
		return treeValue;
	}
	
	public int getHeight() {
		if (root == null) {
			return 0;
		}
		
		return getHeight(root);
	}

	private int getHeight(Node<T> node) {
		int leftHeight = 0;
		if (node.getLeftChild() != null) {
			leftHeight = getHeight(node.getLeftChild());
		}
		
		int rightHeight = 0;
		if (node.getRightChild() != null) {
			rightHeight = getHeight(node.getRightChild());
		}
		
		return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
	}
	
	
}
