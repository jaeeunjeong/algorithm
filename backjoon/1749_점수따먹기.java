//https://www.acmicpc.net/problem/1749 
import java.io.*;
import java.util.*;

/**
 * 누적합 문제.
 * 1 1 1
 * 1 1 1
 * 1 1 1
 * 이라 가정했을 때,
 * (0, 0) - (1, 1)의 크기는 4가 되어야하는데 
 * 바로 위 칸의 합, 바로 왼 칸의 합을 빼고 그 두 칸의 공통 지점을 합해주면 누적된 합을 이용해서 풀이할 수 있다.
 * sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i][j]; 이 연산!
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[][] sum = new long[N+1][M+1];
		long[][] map = new long[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				long cur = Long.parseLong(st.nextToken());
				map[i][j] = cur;
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i][j];
			}
		}
		
		long answer = Long.MIN_VALUE;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				for (int i = r; i < N+1; i++) {
					for (int j = c; j < M+1; j++) {
						long result = sum[i][j] - sum[r-1][j] - sum[i][c-1] + sum[r-1][c-1];
						answer = Math.max(answer, result);
					}
				}
			}
		}
		System.out.println(answer);
	}
}
