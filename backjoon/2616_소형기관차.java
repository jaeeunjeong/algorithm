//https://www.acmicpc.net/problem/2616
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] trains = new int[N];
		int[] sum = new int[N + 1];
		int[][] dp = new int[4][N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			trains[i] = cur;
			sum[i + 1] = sum[i] + cur;
		}
		
		st = new StringTokenizer(br.readLine());
		int maxCnt = Integer.parseInt(st.nextToken());
		
		int answer = Integer.MIN_VALUE;
		for (int i = 1; i < 4; i++) {
			for (int j = 1; j < N + 1; j++) {
				dp[i][j] = 0;
				if (j >= maxCnt) {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - maxCnt] + (sum[j] - sum[j - maxCnt]));
				}
				answer = Math.max(dp[i][j], answer);
			}
		}
		System.out.println(answer);
	}
}
