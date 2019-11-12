package com.tanpham.playaround.datastructure.binarysearchtree;

public class Node<T> {
	private T data;
	private Node<T> leftChild;
	private Node<T> rightChild;
	
	public Node() {
		// Empty constructor
	}

	public Node(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node<T> leftChild) {
		this.leftChild = leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node<T> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((leftChild == null) ? 0 : leftChild.hashCode());
		result = prime * result + ((rightChild == null) ? 0 : rightChild.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (leftChild == null) {
			if (other.leftChild != null)
				return false;
		} else if (!leftChild.equals(other.leftChild))
			return false;
		if (rightChild == null) {
			if (other.rightChild != null)
				return false;
		} else if (!rightChild.equals(other.rightChild))
			return false;
		return true;
	}

	public NodeType getType() {
		if (leftChild == null) {
			if (rightChild != null) {
				return NodeType.SINGLE_RIGHT_CHILD;
			}
			return NodeType.LEAVE;
		} else {
			if (rightChild != null) {
				return NodeType.BOTH_CHILDREN;
			}
			return NodeType.SINGLE_LEFT_CHILD;
		}
	}
	
	public void delete(Node<T> childToBeDeleted) {
		if (childToBeDeleted.equals(leftChild)) {
			leftChild = null;
		} else if (childToBeDeleted.equals(rightChild)) {
			rightChild = null;
		}
	}
	
}
