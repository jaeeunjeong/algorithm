//https://www.acmicpc.net/problem/13422
import java.io.*;
import java.util.*;

/*
 * 누적합이긴하는데 슬라이딩 윈도우가 합쳐진 문제!
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < M; i++) {
				sum += arr[i];
			}
			int answer = 0;
			if (sum < K)
				answer++;
			if (N != M) {
				for (int i = 1; i < N; i++) {
					sum -= arr[i - 1] - arr[(i + M - 1) % N];
					if (sum >= K)
						continue;
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
