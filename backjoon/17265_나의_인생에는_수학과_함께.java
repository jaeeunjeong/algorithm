//https://www.acmicpc.net/problem/17265 
import java.io.*;
import java.util.*;

/*
 * DFS를 이용해서 모든 경로를 파악하며 수식을 만들고 수식을 가공해서 답을 구한다.
 */
class Main {
	static int min, max, N;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		dfs(0, 0, String.valueOf(map[0][0]));
		System.out.println(max + " " + min);
	}

	private static void dfs(int i, int j, String expression) {
		if (i == N - 1 && j == N - 1) {
			int cur = expression.charAt(0) - '0';
			for (int k = 1; k < expression.length();) {
				char now = expression.charAt(k++);
				int num = expression.charAt(k++) - '0';
				if (now == '+') {
					cur += num;
				} else if (now == '*') {
					cur *= num;
				} else if (now == '-') {
					cur -= num;
				}
			}
			min = Math.min(min, cur);
			max = Math.max(cur, max);
			return;
		}

		if (i < N - 1)
			dfs(i + 1, j, expression + map[i + 1][j]);
		if (j < N - 1)
			dfs(i, j + 1, expression + map[i][j + 1]);
	}

}
