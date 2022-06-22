//https://www.acmicpc.net/problem/2688
import java.io.*;
import java.util.*;

/**
 * dp 문제!
 * dp[숫자의 길이][끝나는 번호]를 의미한다.
 * dp[1]은 1로 초기화한다.
 * 점화식은 dp[length][number] = dp[length-1][0] + dp[length-1][1] + ... + dp[length-1][number];
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long[][] dp = new long[1001][10];
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= 1000; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = j; k >= 0; k--) {
					dp[i][j] += dp[i - 1][k];
				}
			}
		}
		while (n-- > 0) {
			int cur = Integer.parseInt(br.readLine()); // 자리수
			long sum = 0;
			for (long x : dp[cur])
				sum += x;
			System.out.println(sum);
		}
	}
}
