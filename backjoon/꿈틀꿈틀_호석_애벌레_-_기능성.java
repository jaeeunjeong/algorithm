//https://www.acmicpc.net/problem/20167 
import java.io.*;
import java.util.*;
/**
 * 값을 더해주고 빼주면서 모든 값을 확인해주면 된다.
 */
public class Main {
	static int N, K, answer;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		move(0, 0, 0);
		System.out.println(answer);
	}

	public static void move(int idx, int sum, int cur) {
		if (idx == N) {
			answer = Math.max(answer, cur);
			return;
		}
		move(idx + 1, 0, cur);
		if (sum + arr[idx] >= K)
			move(idx + 1, 0, cur + sum + arr[idx] - K);
		else
			move(idx + 1, sum + arr[idx], cur);
	}

}
