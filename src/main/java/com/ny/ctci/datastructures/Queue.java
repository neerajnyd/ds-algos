package com.ny.ctci.datastructures;

public class Queue<T> {
	
	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item) {
		QueueNode<T> node = new QueueNode<>(item);
		
		if (last != null) {
			node.next = last;
		}
		last = node;
		if (first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if (first == null) throw new RuntimeException("Queue is Empty");
		
		QueueNode<T> temp = first;
		first = temp.next;
		if (first == null) {
			last = null;
		}
		return temp.data;
	}
	
	public T peek() {
		if (first == null) throw new RuntimeException("Queue is Empty");
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	
}
