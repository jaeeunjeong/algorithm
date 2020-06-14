import java.util.*;
import java.io.*;

class Stack<T>{
	class Node<T>{
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}
	private Node<T> top;
	
	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		T item = top.data;
		top =  top.next;
		return item;
	}
	public void push(T item){
		Node<T> t = new Node<T>(item);
		t.next = top;
		top = t;

	}
	public T peak(){
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data; 
	}
	public boolean isEmpty(){
		return top == null;	 
	}
}	
