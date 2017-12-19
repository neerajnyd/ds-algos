package com.ny.ctci.datastructures;

public class Stack<T> {

	private static class StackNode<T>{
		T data;
		StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
		
		private StackNode<T> top;
		
		public T peek() {
			if(top == null) throw new RuntimeException("Stack is Empty");
			return top.data;
		}
		
		public boolean isEmpty(){
			return top==null;
		}
		
		public T pop() {
			if(top == null) throw new RuntimeException("Stack is Empty");
			
			StackNode<T> t = top;
			top = top.next;
			return t.data;
		}
		
		public void push(T item){
			StackNode<T> node = new StackNode<>(item);
			node.next = top;
			top = node;
		}
		
	}
	

}
