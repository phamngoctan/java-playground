package com.tanpham.playaround.datastructure.binarytree;

public class TreeNode<T> {

	private TreeNode<T> parent;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	private T value;
	
	public TreeNode() {
		// Empty constructor
	}
	
	public TreeNode(T value) {
		this.value = value;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public TreeNode<T> addLeftChild(T value) {
		this.leftChild = new TreeNode<>();
		leftChild.setValue(value);
		leftChild.parent = this;

		return this.leftChild;
	}
	
	public TreeNode<T> addRightChild(T value) {
		this.rightChild = new TreeNode<>();
		rightChild.setValue(value);
		rightChild.parent = this;
		
		return this.rightChild;
	}
	
	public TreeNode<T> goBackOneLevel() {
		return this.parent;
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}

}
