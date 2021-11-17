//https://www.acmicpc.net/problem/9465
import java.io.*;
import java.util.*;

/**
 * 기본적으로 위-아래-위 혹은 아래-위-아래 순으로 번갈아가면서 값이 더해져야한다.
 * 하지만 하나 건너뛰었을 때 값이 더 크다면 그 라인을 그냥 지나갈 수도 있는데,
 * 그를 위해서 직전 값(i-1)과 그 직전의 직전 값(i-2)을 비교해 줘서 더 큰 값을 더해준다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[2][N + 1];

			int[][] dp = new int[2][N + 1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) { 
					int temp = Integer.parseInt(st.nextToken());
					arr[i][j] = temp;
				}
			}
			for (int i = 0; i < 2; i++) {
				dp[i][1] = arr[i][1];
			}
			// 번갈아가면서 넣기
			for (int i = 2; i <= N; i++) {
				dp[0][i] = arr[0][i] + Math.max(dp[1][i - 2], dp[1][i - 1]);
				dp[1][i] = arr[1][i] + Math.max(dp[0][i - 2], dp[0][i - 1]);
			}
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
	}
}
