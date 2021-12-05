//https://www.acmicpc.net/problem/14620
import java.io.*;
import java.util.*;

/**
 * S2 완전 탐색
 * dfs를 이용하여 백트래킹처럼 가능한 3가지 경우들에 대해 모두 구해주고, 
 * 해당하는 모든 값들을 더해서 그 중 최소 값을 출력하였다.
 */
public class Main {
	static int answer = 0;
	static int N;
	static int[][] map;
	static boolean[][] marked;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		marked = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int cur = Integer.parseInt(st.nextToken());
				map[r][c] = cur;
			}
		}
		answer = Integer.MAX_VALUE;
		for (int r = 1; r < N - 1; r++) {
			for (int c = 1; c < N - 1; c++) {
				dfs(0, r, c);
			}
		}
		System.out.println(answer);
	}

	public static int count() {
		int result = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (marked[r][c])
					result += map[r][c];
			}
		}
		return result;
	}

	public static void dfs(int cnt, int row, int col) {
		if (cnt == 3) {
			answer = Math.min(answer, count());
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!verify(i, j))
					continue;

				marked[i][j] = true;
				int d = 0;
				for (d = 0; d < 4; d++) {
					int nextR = i + dirs[d][0];
					int nextC = j + dirs[d][1];
					marked[nextR][nextC] = true;
				}

				if (d == 4)
					dfs(cnt + 1, i, j);

				for (d = 0; d < 4; d++) {
					int nextR = i + dirs[d][0];
					int nextC = j + dirs[d][1];
					marked[nextR][nextC] = false;
				}
				marked[i][j] = false;
			}
		}

	}

	public static boolean verify(int row, int col) {
		if (marked[row][col])
			return false;
		for (int i = 0; i < 4; i++) {
			int nextR = row + dirs[i][0];
			int nextC = col + dirs[i][1];
			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
				return false;
			if (marked[nextR][nextC])
				return false;
		}
		return true;
	}
}
class Dot {
	int row;
	int col;

	Dot(int x, int y) {
		this.row = x;
		this.col = y;
	}
}
