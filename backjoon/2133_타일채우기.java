// https://www.acmicpc.net/problem/2133
import java.io.*;
import java.util.*;

/**
 * 1. 홀수는 성립하지 않는다.
 * 2. 가장 기본이 되는 형태는 3가지이고 이들의 조합으로 값을 만들 수 있다.
 * 3. 각각의 순서마다 특이한 모양이 2개씩 생긴다.
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] dp = new int[31];
		dp[0] = 1;
		dp[2] = 3;
		if (N % 2 == 1) {
			System.out.println(0);
			return;
		}

		for (int i = 3; i <= N; i++) {
			for (int j = 2; j <= N; j += 2) {
				if (j == 2)
					dp[i] = dp[i - j] * dp[2];
				else if (i >= j)
					dp[i] += dp[i - j] * 2;
			}
		}
		System.out.println(dp[N]);
	}
}
