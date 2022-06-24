
//https://www.acmicpc.net/problem/3067 
import java.io.*;
import java.util.*;

/**
 * 배낭문제...
 * 1차원으로 풀어봄
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int now = Integer.parseInt(st.nextToken());
				arr[i] = now;
			}
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int[] dp = new int[M + 1];

			for (int i = 1; i <= N; i++) {
				// if 문
				for (int j = 1; j <= M; j++) {
					if (j - arr[i] > 0) {
						dp[j] = dp[j] + dp[j - arr[i]];
					} else if (j - arr[i] == 0) {
						dp[j]++;
					}
				}
			}
			System.out.println(dp[M]);
		}
	}
}
