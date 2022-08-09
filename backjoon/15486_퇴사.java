
//https://www.acmicpc.net/problem/15486 
import java.io.*;
import java.util.*;

/**
 * 앞에서부터 채워간다고 생각하면 되는데!(Bottom-up 방식!)
 * for문에서 i가 날짜고 nextDay가 끝나는 날짜로, 끝나는 날짜에 최대 이익을 담아서 풀이하면 된다!
 * 
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][2];
		int[] dp = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N + 1; i++) {
			max = Math.max(max, dp[i]);

			int nextDay = i + arr[i][0];
			if (nextDay < N + 1) {
				dp[nextDay] = Math.max(dp[nextDay], arr[i][1] + max);
			}
		}
		System.out.println(dp[N]);
	}
}
