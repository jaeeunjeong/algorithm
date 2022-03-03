//https://www.acmicpc.net/problem/2206
import java.io.*;
import java.util.*;

/**
 * BFS + 3차원 배열
 * 이 문제는 한번 벽 부수는 것이 가능하다는 것때문에 백트레킹처럼 DFS를 사용하려고 했었는데, 
 * 방문의 처리가 안 되고, 최단 거리라는 부분때문에 꼭 BFS를 이용해서 풀이해야한다.
 * 또한 벽을 부쉈는지 아닌지 확인하는 것 때문에 방문체크 역시 3차원 배열을 이용해서 
 * 한 부분은 꼭 벽을 부쉈는지 아닌지 확인을 해줘야한다.
 * 나의 경우 boolean[row][col][벽을 부쉈는지 아닌지 확인]을 이용하였다.
 * 구조체 역시 거리와 현재 벽 부순 상태를 파악하는 것도 넣어서 풀어줘야한다.
 */
class Main {
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int N, M, answer;
	static char[][] map;
	static boolean[][][] marked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		marked = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(0, 0, 1, 0));
		marked[0][0][0] = true;
		while (!queue.isEmpty()) {
			Dot cur = queue.poll();
			if (cur.row == N - 1 && cur.col == M - 1)
				return cur.distance;
			for (int d = 0; d < 4; d++) {
				int nextR = cur.row + dirs[d][0];
				int nextC = cur.col + dirs[d][1];
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M)
					continue;
				if (map[nextR][nextC] == '0') {
					if (!marked[nextR][nextC][cur.wall]) {
						marked[nextR][nextC][cur.wall] = true;
						queue.add(new Dot(nextR, nextC, cur.distance + 1, cur.wall));
					}
				} else {
					if (!marked[nextR][nextC][1] && cur.wall == 0) {
						marked[nextR][nextC][1] = true;
						queue.add(new Dot(nextR, nextC, cur.distance + 1, 1));
					}
				}
			}
		}
		return -1;
	}
}

class Dot {
	int row;
	int col;
	int distance;
	int wall;

	Dot(int row, int col, int distance, int wall) {
		this.row = row;
		this.col = col;
		this.distance = distance;
		this.wall = wall;
	}
}
