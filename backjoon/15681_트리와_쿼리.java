
//https://www.acmicpc.net/problem/15681 
import java.io.*;
import java.util.*;

/**
 * 트리 구조를 순회하며 자식 노드가 몇 개 있는지 기록한다.
 */
class Main {
	static List<List<Integer>> tree;
	static int[] child;
	static boolean[] marked;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}

		child = new int[N+1];
		marked = new boolean[N+1];
		child[R] = search(R);
		
		for (int i = 0; i < Q; i++) {
			int cur = Integer.parseInt(br.readLine());
			System.out.println(child[cur]);
		}
	}
	public static int search(int root) {
		if(child[root] != 0) return child[root];
		
		marked[root] = true;
		int result = 1;
		
		for (int i = 0; i < tree.get(root).size(); i++) {
			int cur = tree.get(root).get(i);
			if(marked[cur]) continue;
			result += search(cur);
		}
		
		child[root] = result;
		
		return child[root];
	}
}
