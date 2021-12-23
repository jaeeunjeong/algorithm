//https://www.acmicpc.net/problem/17836 
import java.io.*;
import java.util.*;
import java.util.LinkedList;

/**
 * 경우는 두가지이다.
 * 그람이 없어도 최단 거리 도착.
 * 그람이 있어야 최단 거리 도착.
 * 
 * 따라서 그람이 있는 경우와 없는 경우를 파악해서 bfs로 풀이해주면 된다.
 * 
 * 최단 거리를 구해야하고, 도착하지 못하는 경우도 있어서 꼼꼼하게 확인해줘야한다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] times = new int[N][M];
		boolean[][] marked = new boolean[N][M];
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
		Dot sword = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					sword = new Dot(i, j);
			}
		}

		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(0, 0)); // 1,1인데 편의상 0,0으로 진행.
		marked[0][0] = true;
		map[0][0] = 0;

		while (!queue.isEmpty()) {
			Dot cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextR = cur.row + dirs[d][0];
				int nextC = cur.col + dirs[d][1];
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M)
					continue;
				if (marked[nextR][nextC])
					continue;
				if (map[nextR][nextC] == 1)
					continue;
				queue.add(new Dot(nextR, nextC));
				marked[nextR][nextC] = true;
				times[nextR][nextC] = (times[cur.row][cur.col] + 1);
			}
		}
		marked = new boolean[N][M];
		int[][] swordTimes = new int[N][M];
		queue.add(sword);
		swordTimes[sword.row][sword.col] = times[sword.row][sword.col];
		while (times[sword.row][sword.col] > 0 && !queue.isEmpty()) {
			Dot cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextR = cur.row + dirs[d][0];
				int nextC = cur.col + dirs[d][1];
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M)
					continue;
				if (marked[nextR][nextC])
					continue;
				queue.add(new Dot(nextR, nextC));
				marked[nextR][nextC] = true;
				swordTimes[nextR][nextC] = (swordTimes[cur.row][cur.col] + 1);
			}
		}
		int answer = 0;
		if (swordTimes[N - 1][M - 1] != 0 && times[N - 1][M - 1] != 0)
			answer = Math.min(swordTimes[N - 1][M - 1], times[N - 1][M - 1]);
		if (swordTimes[N - 1][M - 1] != 0 && times[N - 1][M - 1] == 0)
			answer = swordTimes[N - 1][M - 1];
		if (swordTimes[N - 1][M - 1] == 0 && times[N - 1][M - 1] != 0)
			answer = times[N - 1][M - 1];
		if (answer == 0 || answer > T)
			System.out.println("Fail");
		else
			System.out.println(answer);
	}
}

class Dot {
	int row;
	int col;

	Dot(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
