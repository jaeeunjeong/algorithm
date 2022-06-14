// https://www.acmicpc.net/problem/14728
import java.io.*;
import java.util.*;

/*
 * 냅색문제의 응용!
 * 이 문제는 dp배열을 어떤 식으로 만들지도 중요한 것 같은데,
 * 핵심 dp배열을 단원과 공부 시간으로 정해서 가능한 전체 경우를 확인해가면서 풀이하였다.
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 단원의 갯수
		int t = Integer.parseInt(st.nextToken()); // 시험까지 공부할 수 있는 총 시간
		int[][] subject = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			subject[i][0] = K;
			subject[i][1] = S;
		}

		int[][] dp = new int[N + 1][t + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= t; j++) {
				if (subject[i][0] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - subject[i][0]] + subject[i][1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N][t]);
	}
}
