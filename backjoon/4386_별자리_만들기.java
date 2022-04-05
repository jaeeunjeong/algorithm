//https://www.acmicpc.net/problem/4386
import java.io.*;
import java.util.*;
/**
 * MST/ 크루스칼 알고리즘 / 유니온 파인드
 * 각 값들은 트리 구조로 되지 않아서 일단 1차원 배열로 좌표를 저장해준다.
 * 모든 값들을 연결해주면서 트리 구조로 만들어준다.
 * 
 * 크루스칼알고리즘/유니온파인드를 이용해서 가장 최소 값부터 가장 가까운 조상을 찾고 그 조상이 더 이상 조상이 없을 때까지 파악해준다.
 */
class Main {
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		double answer = 0;
		int N = Integer.parseInt(st.nextToken());
		Star[] stars = new Star[N];
		double x = 0;
		double y = 0;
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Double.parseDouble(st.nextToken());
			y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(i, x, y);
			parents[i] = i;
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// 별 사이의 길이 구하기.
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double row = Math.pow(stars[i].row - stars[j].row, 2);
				double col = Math.pow(stars[i].col - stars[j].col, 2);
				double distance = Math.sqrt(row + col);
				pq.add(new Edge(i, j, distance));
			}
		}
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(find(now.i)!= find(now.j)) {
				union(now.i, now.j);
				answer += now.distance;
			}
		}
		System.out.println(String.format("%.2f", answer));
	}

	static void union(int n1, int n2) {
		int parent1 = find(n1);
		int parent2 = find(n2);
		if (parent1 > parent2)
			parents[parent1] = parent2;
		else
			parents[parent2] = parent1;
	}

	static int find(int n) {
		if (parents[n] == n)
			return n;
		return parents[n] = find(parents[n]);
	}

	static class Edge implements Comparable<Edge> {
		int i;
		int j;
		double distance;

		Edge(int i, int j, double distance) {
			this.i = i;
			this.j = j;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.distance, o.distance);
		}
	}

	static class Star {
		int idx;
		double row;
		double col;

		Star(int idx, double row, double col) {
			this.idx = idx;
			this.row = row;
			this.col = col;
		}
	}
}
