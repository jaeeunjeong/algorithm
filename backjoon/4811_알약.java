//https://www.acmicpc.net/problem/4811
import java.io.*;
import java.util.*;

/**
 * DP 문제.
 * 두가지 문자로 만들 수 있는 문자열을 찾는 문제인데, 문자 사이에 순서가 있다.
 * 저 배열에서 각각이 의미하는 값은 w나 h의 숫자이다.
 * 2차원 배열을 이용하여 [w][h]라 생각한다면, w는 무조건 h보다 커야한다. // 1. 
 * 해당 배열의 값은 직전 값들에 w나 h를 더한 것이로 이해할 수 있기에,
 * W 3개와 H 1개로 이뤄진 것들의 숫자를 구한다고 한다면
 * dp[3][1] = (dp[3][0] + 'H')  +  (dp[2][1] + 'W') 라는 것이다.//2.
 */
public class Main {
	static int N, K, answer;
	static int[] curArr, countArr, number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long[][] dp = new long[31][31];

		for (int h = 0; h <= 30; h++) {
			for (int w = 0; w <= 30; w++) {
				if(h > w) continue; // 1.
				if(h == 0) dp[w][h] = 1;
				else dp[w][h] = dp[w-1][h] + dp[w][h-1];//2.
			}
		}
		int n = 0;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			System.out.println(dp[n][n]);
		}
    }
}
