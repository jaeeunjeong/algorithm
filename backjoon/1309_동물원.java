// https://www.acmicpc.net/problem/1309 
import java.io.*;
import java.util.*;

/**
 * n=1 일 때를 생각하면 	없는 경우/ 왼쪽에 있는 경우/ 오른쪽에 있는 경우 세가지로 생각할 수 있다.
 * n=2 일 떄를 생각해보면 	위에 없는 경우 아무데나 들어가도 되고
 * 					왼쪽에 있는 경우에는 호랑이가 있거나 오른쪽에 있어야하고,
 * 					오른쪽에 있는 경우에는 호랑이가 없거나 오른쪽에 있어야한다. 
 * 
 * 이렇게 세가지로 나뉘어서 경우를 구해주면 풀이 끝!!
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N + 1][3];
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
		}
		int answer = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
		System.out.println(answer);
	}
}
