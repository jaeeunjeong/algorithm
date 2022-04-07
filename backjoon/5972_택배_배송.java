//https://www.acmicpc.net/problem/5972
import java.io.*;
import java.util.*;
/**
 * 완전 다익스트라 유형
 * 다익스트라로 풀이하면 됨!
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Node>[] road = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			road[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			road[A].add(new Node(B, C));
			road[B].add(new Node(A, C));
		}
		boolean[] marked = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[1] = 0;
		pq.add(new Node(1, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(marked[now.idx]) continue;
			marked[now.idx] = true;
			for(int i = 0; i < road[now.idx].size(); i++) {
				Node next = road[now.idx].get(i);
				int nextDistance = distance[next.idx];
				int nowDistnace = distance[now.idx] + next.vertax;
				if(nextDistance > nowDistnace) {
					distance[next.idx] = nowDistnace;
					pq.add(new Node(next.idx, nowDistnace));
				}
			}
		}
		System.out.println(distance[N]);
	}

	static class Node implements Comparable<Node> {
		int idx;
		int vertax;

		Node(int idx, int vertax) {
			this.idx = idx;
			this.vertax = vertax;
		}

		@Override
		public int compareTo(Node o) {
			return this.vertax - o.vertax;
		}
	}
}
