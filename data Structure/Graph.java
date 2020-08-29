import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.*;

class Graph{
	class Node{
		int data;
		boolean marked;
		LinkedList<Node> adjacent;
		Node(int data){
			this.data = data;
			this.marked = false;
			this.adjacent = new LinkedList<Node>();
		}
	}

Node[] nodes;

Graph(int size){
	nodes = new Node[size];
	for (int i = 0; i < size; i++) {
		nodes[i] = new Node(i);
		
	}
}

void addEdge(int i1, int i2) {
	Node n1 = nodes[i1];
	Node n2 = nodes[i2];
	if(!n1.adjacent.contains(n2)) {
		n1.adjacent.add(n2);
	}
	if(!n2.adjacent.contains(n1)) {
		n2.adjacent.add(n1);
	}
}

void initMarks() {
	for( Node n : nodes) {
		n.marked = false;
	}
}

boolean search(int il, int i2) {
	return search(nodes[il], nodes[i2]);
}

//dfs?
boolean search(Node start, Node end) {
	initMarks();
	LinkedList<Node> q = new LinkedList<Node>();
	
	q.add(start);
	
	while(!q.isEmpty()) {
		Node root = q.removeFirst();
		if(root == end) {
			return true;
		}
		for(Node n : root.adjacent) {
			if(n.marked == false) {
				n.marked = true;
				q.add(n);
			}
		}
		return false;
	}
	return false;
}

boolean isCircle(int il) {
	return isCircle(nodes[il]);
}

boolean isCircle(Node start) {
	initMarks();
	Set<Node> s = new HashSet<Node>();
	for(Node n : start.adjacent) {
		if(n.marked == false) {
			n.marked = true;
			if(s.contains(n)) {
				return true;
			}else {
				s.add(n);
			}
		}
	}
	return false;
}

}
