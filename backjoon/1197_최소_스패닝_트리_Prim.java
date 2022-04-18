//https://www.acmicpc.net/problem/1197 
import java.io.*;
import java.util.*;

/**
 * 프림을 이용한 MST
 * 우선순위큐와 큐를 이용한다.
 * 우선순위 큐를 이용해서 최소 거리를 구하고 큐에는 방문할 순서를 관리해준다.
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<Node>[] list = new List[V + 1];
		boolean[] marked = new boolean[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long C = Integer.parseInt(st.nextToken());
			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C));
		}
		
		long answer = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int curIdx = queue.poll();
			marked[curIdx] = true;
			for (int i = 0; i < list[curIdx].size(); i++) {
				Node cur = list[curIdx].get(i);
				int nextIdx = cur.idx;
				if(marked[nextIdx]) continue;
				pq.add(cur);
			}
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				if(!marked[cur.idx]) {
					marked[cur.idx] = true;
					queue.add(cur.idx);
					answer += cur.value;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

	static class Node implements Comparable<Node> {
		int idx;
		long value;

		Node(int idx, long value) {
			this.idx = idx;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.value, o.value);
		}
	}
}
