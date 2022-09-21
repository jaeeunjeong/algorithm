/*
 * 간단한 dp문제! 피보나치 수열과 비슷한 문제였다.
*/
class Solution {
	public long solution(int n) {
		long[] dp = new long[n + 2];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
		}

		return dp[n];
	}
}
