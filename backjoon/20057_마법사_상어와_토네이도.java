import java.io.*;
import java.util.*;

/*
 */
public class Main {
	static int[][] map;
	static int N, answer;
	public static int[][] dr = { { -1, 1, -2, 2, -1, 1, -1, 1, 0, 0 }, { -1, -1, 0, 0, 0, 0, 1, 1, 2, 1 },
			{ -1, 1, -2, 2, -1, 1, -1, 1, 0, 0 }, { 1, 1, 0, 0, 0, 0, -1, -1, -2, -1 } }; // 서, 남, 동, 북 방향
	public static int[][] dc = { { 1, 1, 0, 0, 0, 0, -1, -1, -2, -1 }, { -1, 1, -2, 2, -1, 1, -1, 1, 0, 0 },
			{ -1, -1, 0, 0, 0, 0, 1, 1, 2, 1 }, { -1, 1, -2, 2, -1, 1, -1, 1, 0, 0 } };
	public static int[] per = { 1, 1, 2, 2, 7, 7, 10, 10, 5 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
			}
		}
		answer = 0;
		// 달팽이 회전하기
		turn();
		// 점수 매기기
		System.out.println(answer);
	}

	// 달팽이 확인해보기
	private static void turn() {

		int size = 1;
		int turn = 0;
		int nextR = N / 2;
		int nextC = N / 2;
		int dir = 0;

		int[][] dirs = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		while (turn < N * N - N) {

			for (int i = 0; i < size; i++) {
				turn++;
				nextR += dirs[dir][0];
				nextC += dirs[dir][1];
				wind(nextR, nextC, dir);
			}

			dir++;
			dir %= 4;
			for (int i = 0; i < size; i++) {
				turn++;
				nextR += dirs[dir][0];
				nextC += dirs[dir][1];
				wind(nextR, nextC, dir);
			}
			dir++;
			dir %= 4;
			size++;
		}

		for (int i = 0; i < size - 1; i++) {
			nextR += dirs[dir][0];
			nextC += dirs[dir][1];
			wind(nextR, nextC, dir);
		}
	}

	private static void wind(int r, int c, int dir) {
		int a = map[r][c];
		for (int i = 0; i <= 8; i++) {
			int nextR = r + dr[dir][i];
			int nextC = c + dc[dir][i];
			int sand = (map[r][c] * per[i]) / 100;
			a -= sand;
			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
				answer += sand;
			else
				map[nextR][nextC] += sand;
		}

		int nextR = r + dr[dir][9];
		int nextC = c + dc[dir][9];
		if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
			answer += a;
		else
			map[nextR][nextC] += a;
		map[r][c] = 0;
	}

}
