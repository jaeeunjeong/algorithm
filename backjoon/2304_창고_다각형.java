//https://www.acmicpc.net/problem/2304
import java.io.*;
import java.util.*;

/**
 * 왼쪽에서 오른쪽 방향으로 보다가 가장 높은 부분을 놓치게 된다.
 * 양방향을 탐색하며 높은 부분을 놓치지 않도록 해야한다.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] map = new int[1001];

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x] = y;
		}
		
		int max = 0;
		int[] left = new int[1001];
		for (int i = 1; i <= 1000; i++) {
			max =  Math.max(map[i], max);
			left[i] =max;
		}
		max = 0;
		int[] right = new int[1001];
		for (int i = 1000; i > 0; i--) {
			max = Math.max(max, map[i]);
			right[i] = max;
		}
		
		int sum = 0;
		for (int i = 0; i < 1001; i++) {
			sum += Math.min(left[i], right[i]);
		}
		System.out.println(sum);
	}
}
