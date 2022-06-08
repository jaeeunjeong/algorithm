// https://www.acmicpc.net/problem/12865
import java.io.*;
import java.util.*;

/*
 * 냅색 문제
 * 2차원 dp문제인데, dp[][] = dp[1번째부터 n번째까지 확인했다는 의미][무게]
 * 해당 배열에서 들어갈 수 있는 경우는, 
 * 	배낭에 물건을 담을 때, 물건을 담지 않을 때이다.
 * 물건을 담을 수 있다면, 물건을 담았을 때 큰 경우와 물건을 담지 않았을 때 큰 경우를 확인해줘야한다.
 * 따라서, 아래와 같은 점화식이 나올 수 있다. 
 * dp[i][j] = max(dp[i - 1][j], dp[i-1][j - w[i]] + v[i])
 * dp[i-1][j - w[i]]는 i번째의 무게를 빼면, 무게가 바뀌게 된다. 현재 물건을 넣기 위한 공간을 마련하는 것!
 * 그 무게에 물건을 넣었을 때의 가치를 더해준다.
 * 물건을 넣은 경우, 물건을 안 넣은 경우를 비교해서 큰 값을 저장해준다.
 * 일단 2차원은 이렇게 이해하였다...
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][K+1];
		int[] W = new int[N+1];
		int[] V = new int[K+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			W[i] = w;
			V[i] = v;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j - W[i] >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
