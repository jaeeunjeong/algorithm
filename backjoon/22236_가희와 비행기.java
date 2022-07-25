//https://www.acmicpc.net/problem/22236 
import java.io.*;
import java.util.*;

/**
 * dp문제
 * dp[이동한 거리][높이]라 생각하고, 
 * 이전 위치에서 현재 위치로 올라올 경우/ 내려올 경우를 더해주면 된다. 
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		long[][] dp = new long[4004][4004];
		int d = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp[0][0] = 1;
		
		for (int x = 1; x < d; x++) {
			for (int h = 1; h <= x; h++) {
				dp[x][h] = (dp[x - 1][h - 1] + dp[x - 1][h + 1]) % m;
			}
		}
		
		dp[d][0] = dp[d - 1][1];
		System.out.println(dp[d][0]);
	}
}
