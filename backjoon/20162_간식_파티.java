
//https://www.acmicpc.net/problem/20162 
import java.io.*;
import java.util.*;

/**
 * 전체 for문(1)을 돌린다.
 * 그 안에 for문(2)를 만드는데, for문(1)보다 인덱스 값이 작은 것 까지 돌린다.
 * 값들을 비교해나가면서 이전 값이 현재 값보다 작다면 값을 더해주고 더해진 값중 최고 값과 비교해나가며 갱신한다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int cur;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			cur = Integer.parseInt(br.readLine());
			arr[i] = cur;
		}
		int[] dp = new int[N];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			dp[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j]+arr[i]);
			}
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
