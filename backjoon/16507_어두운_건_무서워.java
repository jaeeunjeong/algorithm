//https://www.acmicpc.net/problem/16507
import java.io.*;
import java.util.*;

/**
 * 누적합 문제
 * 2차원 배열형태로 처음 누적합을 위해 배열을 만들 때 중복으로 들어갈 겹쳐지는 부분을 빼줘야한다.
 * 합을 구할 때는 반대로 겹쳐지는 값을 다시 더해준다.
 **/
class Main {
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[][] map = new int[R + 1][C + 1];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i + 1][j + 1] = map[i + 1][j] + map[i][j + 1] - map[i][j] + cur;
			}
		}
		while (Q-- > 0) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			sum = map[r2][c2] - map[r1 - 1][c2] - map[r2][c1 - 1] + map[r1 - 1][c1 - 1];
			sum /= (r2 - r1 + 1) * (c2 - c1 + 1);
			System.out.println(sum);
		}
	}
}
