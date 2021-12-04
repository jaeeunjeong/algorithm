//https://www.acmicpc.net/problem/1743
import java.io.*;
import java.util.*;
/**
 * BFS를 이용해서 음식물 크기를 구해주었다.
 */
public class Main {

	static int N, M, K;
	static int[][] food;
	static boolean[][] visited;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 

		food = new int[N + 1][M + 1]; 
		visited = new boolean[N + 1][M + 1];
		for (int i = 0; i < K; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			food[x][y] = 1;
			visited[x][y] = false;
		}

		int max = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (food[i][j] == 1) {
					max = Math.max(max, bfs(i, j));
				}
			}
		}

		System.out.println(max);
	}

	public static int bfs(int x, int y) {
		Queue<Dot> queue = new LinkedList<Dot>();

		queue.add(new Dot(x, y));
		visited[x][y] = true;
		int result = 1;
		while (!queue.isEmpty()) {
			Dot d = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = d.x + dirs[i][0];
				int nextY = d.y + dirs[i][1];

				if (nextX < 0 || nextY < 0 || nextX > N || nextY > M)
					continue;

				if (visited[nextX][nextY] == true)
					continue;

				if (food[nextX][nextY] == 1) {
					queue.add(new Dot(nextX, nextY));
					visited[nextX][nextY] = true;
					result++;
				}
			}
		}
		return result;
	}
}

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
