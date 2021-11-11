//https://www.acmicpc.net/problem/16926
import java.io.*;
import java.util.*;

/**
 * 원래 배열 돌릴 때 반시계 방향으로 돌리게 되면 일단 for문 4개 만들어서 돌리는데
 * 다른 곳 참고해서 while문으로 돌렸다.
 * 직사각형은 둘 중 작은 값을 기록해서 범위를 정해주는 것이 포인트.
 * 이 문제는 시작 점이 (i, i)로 생각할 수 있어서 수월했던 듯.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int group = Math.min(M, N);
		while (R-- > 0) {
			for (int i = 0; i < group / 2; i++) {
				int row = i;
				int col = i;

				int temp = map[row][col];

				int d = 0;
				while (d < 4) {
					int nextR = row + dirs[d][0];
					int nextC = col + dirs[d][1];
					if (nextR < i || nextC < i || nextR >= N - i || nextC >= M - i) {
						d++;
					} else {
						map[row][col] = map[nextR][nextC];
						row = nextR;
						col = nextC;
					}
				}
				map[i + 1][i] = temp;

			}
		}
		for (int r = 0; r < N; r++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[r][j] + " ");
			}
			System.out.println();
		}

	}
}
