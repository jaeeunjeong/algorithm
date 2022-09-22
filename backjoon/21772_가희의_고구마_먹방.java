//https://www.acmicpc.net/problem/21772 
import java.io.*;
import java.util.*;
/*
 * 유형은 백트래킹으로 되어있는데 dfs로 풀었다.
 * 주의할 점은 방문한 곳을 또 갈 수 있다는 거
 */
class Main {
	static char[][] map;
	static boolean[][] marked;
	static int answer, R, C, T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		marked = new boolean[R][C];
		answer = Integer.MIN_VALUE;

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[] gahee = {};

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'G') {
					gahee = new int[] { i, j };
					map[i][j] = '.';
					break;
				}
			}
		}

		dfs(gahee[0], gahee[1], 0, 0);
		System.out.println(answer);
	}

	private static void dfs(int r, int c, int cnt, int t) {
		if (t == T) {
			answer = Math.max(answer, cnt);
			return;
		}
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 0, 0 } };

		for (int d = 0; d < 5; d++) {
			int nextR = r + dirs[d][0];
			int nextC = c + dirs[d][1];
			if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C)
				continue;
			if (map[nextR][nextC] == '#')
				continue;
			if (map[nextR][nextC] == 'S') {
				map[nextR][nextC] = '.';
				dfs(nextR, nextC, cnt + 1, t + 1);
				map[nextR][nextC] = 'S';
			} else {
				dfs(nextR, nextC, cnt, t + 1);
			}
		}

	}
}
