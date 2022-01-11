//https://www.acmicpc.net/problem/1991 
import java.io.*;
import java.util.*;

/**
 * 트리 구조를 만들고 DFS를 이용해서 순회하면 된다.
 * 출력해야 할 순서에 맞게 재귀함수를 호출하여 수행한다.
 */
public class Main {
	static List<Node>[] list;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = st.nextToken().charAt(0) - 'A';
			int b = st.nextToken().charAt(0) - 'A';
			int c =  st.nextToken().charAt(0) - 'A';

			list[a].add(new Node(b, c));
		}
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
	}
	public static void preOrder(int cur) {
		for(Node node : list[cur]) {
			int left = node.left;
			int right = node.right;
			
			System.out.print((char) (cur+'A'));
			if(left >= 0) preOrder(left);
			if(right >= 0) preOrder(right);
		}
	}
	public static void inOrder(int cur) {
		for(Node node : list[cur]) {
			int left = node.left;
			int right = node.right;
			
			if(left >= 0) inOrder(left);
			System.out.print((char) (cur+'A'));
			if(right >= 0) inOrder(right);
		}
	}
	public static void postOrder(int cur) {
		for(Node node : list[cur]) {
			int left = node.left;
			int right = node.right;
			
			if(left >= 0) postOrder(left);
			if(right >= 0) postOrder(right);
			System.out.print((char) (cur+'A'));
		}
	}
}
class Node{
	int left;
	int right;
	Node(int left, int right){
		this.left = left;
		this.right = right;
	}
}
