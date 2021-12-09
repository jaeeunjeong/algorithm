//https://www.acmicpc.net/problem/15658 
import java.io.*;
import java.util.*;

/**
 * S2 dfs
 * dfs를 이용해서 필요한 카운트에 포함하지 않으면 더 이상 진행하지 않는 방식으로 구현!
 */
public class Main {
	static int[] arr;
	static int[] cnt;
	static int n, min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		arr = new int[n];
		cnt = new int[4];
        
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
        
		dfs(1, arr[0], cnt[0], cnt[1], cnt[2], cnt[3]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int idx, int cur, int sum, int minus, int multi, int div) {
		if (idx == n) {
			min = Math.min(cur, min);
			max = Math.max(cur, max);
			return;
		}

		if (sum > 0)
			dfs(idx + 1, cur + arr[idx], sum - 1, minus, multi, div);
		if (minus > 0)
			dfs(idx + 1, cur - arr[idx], sum, minus - 1, multi, div);
		if (multi > 0)
			dfs(idx + 1, cur * arr[idx], sum, minus, multi - 1, div);
		if (div > 0)
			dfs(idx + 1, cur / arr[idx], sum, minus, multi, div - 1);
	}
}
