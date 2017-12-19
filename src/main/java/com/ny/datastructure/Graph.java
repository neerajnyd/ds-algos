package com.ny.datastructure;

public class Graph<T> {
	
	public Graph(Node<T>[] nodes) {
		this.nodes = nodes;
	}
	
	private Node<T>[] nodes;
	
	public static class Node<T>{
		public T data;
		public Node<T>[] children;
		public boolean visited;
		
		public Node(T data) {
			this.data = data;
			this.visited = false;
		}
	}
	
	public Node<T> depthFirstSearch(Node<T> root, T key){
		if(root.data.equals(key)){
			return root;
		}
		
		root.visited = true;
		for(Node<T> child : root.children){
			if(!child.visited){
				return depthFirstSearch(child, key);
			}
		}
		
		return root;
	}
	
	public Node<T> breadthFirstSearch(Node<T> root, T key){
		if(root.data.equals(key)){
			return root;
		}
		
		root.visited = true;
		for(Node<T> child : root.children){
			if(!child.visited){
				return depthFirstSearch(child, key);
			}
		}
		
		return root;
	}
	
}
