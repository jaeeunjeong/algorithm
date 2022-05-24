// https://www.acmicpc.net/problem/14925
import java.io.*;
import java.util.*;

/*
 * 메모이제이션 기법을 이용한 DP!
 * 양 끝쪽까지 싹싹 확인해줘야하기에 배열 칸을 넉넉하게 잡는다.
 * 정사각형이기 때문에 들판인 경우 현재까지 기록된 행/열 값의 최소 값을 잡는다.
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i-1][j-1] == 0) {
					dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
					dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
					dp[i][j]++;
					answer = Math.max(dp[i][j], answer);

				}
			}
		}
		System.out.println(answer);

	}
}
