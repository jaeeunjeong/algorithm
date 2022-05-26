
//https://www.acmicpc.net/problem/17352 
import java.io.*;
import java.util.*;

/*
 * 인접리스트 + BFS 를 이용해서 풀었는데 사실은 유니온파인드 문제!
 */
class Main {
	static int[] parent;

	public static void main_UNIONFIND(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < N - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		// 연결 안 된거 연결하기
		for (int i = 2; i <= N; i++) {
			if (find(1) == find(i))
				continue;
			union(1, i);
			System.out.println(1 + " " + i);
		}
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	public static void main_BFS(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new ArrayList[N + 1];
		boolean[] marked = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1); // 아무거나 넣기...
		marked[1] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				if (marked[next])
					continue;
				marked[next] = true;
				queue.add(next);
			}
		}

		int a = 1;
		int b = 0;
		for (int i = 1; i <= N; i++) {
			if (!marked[i]) {
				b = i;
				break;
			}
		}

		System.out.println(a + " " + b);
	}
}
