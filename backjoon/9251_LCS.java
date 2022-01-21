//https://www.acmicpc.net/problem/9251
import java.io.*;
import java.util.*;
/**
 * 1. DP 문제
 * 2. 전체를 다 탐색해야한다. n^2 -> 모든 상황을 알아야하니까.
 * 3. 같은 경우 현재 상황에서 최대의 수에 +1 해준다.
 * -> 현재 상황의 최대의 수는 바로 직전의 완료된 상황들을 통해서 알 수 있다. i-j상황이라면 (i-1, j-1)인 값을 말한다.
 * 4. 값이 다르다면 현재 진행중인 상황의 값을 그대로 가져간다.
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		int lengthA = A.length;
		int lengthB = B.length;
		int[][] dp = new int[lengthA+1][lengthB+1];
		for (int i = 1; i <= lengthA; i++) {
			char a = A[i-1]; //0번 인덱스부터 시작이기에 부득이하게 -1함.
			for (int j = 1; j <= lengthB; j++) {
				char b = B[j-1];
				if(a == b) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(dp[lengthA][lengthB]);
	}
}
