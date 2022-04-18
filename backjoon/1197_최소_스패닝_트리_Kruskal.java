//https://www.acmicpc.net/problem/1197 
import java.io.*;
import java.util.*;

/**
 * Kruskal을 이용한 MST 풀이.
 * 간선의 가중치가 가장 작은 것부터 Union-Find 를 이용해서 푼다.
 */
public class Main {
	static int[] root;
	static List<Node> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		root = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			root[i] = i;
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long C = Integer.parseInt(st.nextToken());
			list.add(new Node(A, B, C));
		}
		Collections.sort(list);
		long answer = 0;
		for (int i = 0; i < E; i++) {
			int start = list.get(i).start;
			int end = list.get(i).end;
			int result = find(start, end);
			if (result == 1)
				continue;
			makeUnion(start, end);
			answer += list.get(i).value;
		}

		System.out.println(answer);
	}

	static int parent(int idx) {
		if (root[idx] == idx)
			return idx;
		return root[idx] = parent(root[idx]);
	}

	static void makeUnion(int a, int b) {
		a = parent(a);
		b = parent(b);
		if (a < b)	root[b] = a;
		else	root[a] = b;
	}

	public static int find(int a, int b) {
		a = parent(a);
		b = parent(b);
		if (a == b)	return 1;
		else	return 0;
	}

	static class Node implements Comparable<Node> {
		int start;
		int end;
		long value;

		Node(int start, int end, long value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.value, o.value);
		}
	}
}
