// https://www.acmicpc.net/problem/1916
import java.io.*;
import java.util.*;

/*
 * 다익스트라 문제!
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시의 갯수
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 버스의 갯수
		List<Node>[] list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		pq.add(new Node(start, 0));
		distance[start] = 0;
		boolean[] marked = new boolean[N + 1];
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int idx = node.vertax;

			if (marked[idx])
				continue;
			marked[node.vertax] = true;
			for (Node next : list[idx]) {
				if (distance[next.vertax] >= distance[idx] + next.weight) {
					distance[next.vertax] = distance[idx] + next.weight;
					pq.add(new Node(next.vertax, distance[next.vertax]));
				}
			}
		}
		System.out.println(distance[end]);
	}

	static class Node implements Comparable<Node> {
		int vertax;
		int weight;

		Node(int v, int w) {
			vertax = v;
			weight = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}
