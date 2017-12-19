package com.ny.datastructure;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Node<T> root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public BinarySearchTree(Node<T> root) {
		this.root = root;
	}
	
	public void insert(T val) {
		root = insert(this.root, val);
	}
	
	private Node<T> insert(Node<T> root, T val) {
		
		if (root == null) {
			root = new Node<>(val);
			return root;
		}
		
		if (root.data.compareTo(val) > 0) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		
		return root;
	}
	
	public void delete(T val){
		root = delete(root, val);
	}
	
	private Node<T> delete(Node<T> root, T val) {
		
		if(root == null) return root;
		
		if(root.data.compareTo(val) > 0){
			root.left = delete(root.left, val);
		}else if(root.data.compareTo(val) < 0){
			root.right = delete(root.right, val);
		}
		//delete the node
		else{
			//node with only one or no child
			if(root.left == null){
				return root.right;
			}else if(root.right == null){
				return root.left;
			}
			
			// node with two children: Get the inorder successor, i.e., the smallest in the right subtree
			root.data = minValue(root.right);
			
			root.right = delete(root.right, root.data);
		}
		return root;
		
	}
	
	private T minValue(Node<T> root) {
		T min = root.data;
		while(root.left != null){
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(Node<T> root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}
	
	public static class Node<T extends Comparable<T>> {
		public T data;
		public Node<T> left;
		public Node<T> right;
		
		public Node(T data) {
			this.data = data;
		}
	}
}
