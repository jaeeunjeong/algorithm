//https://www.acmicpc.net/problem/3709
import java.io.*;
import java.util.*;

/**
 * DFS를 이용한 시뮬레이션!
 * 거울을 표시해주고 만났을 때마다 방향을 전환해주면 된다.
 * 첫 시작 생각하는게 왜인지 너무 어려웠지만 단순하게 row가 0이면  아래, n+1이면 위
 * col이 0이면 오른쪽 n+1이면 왼쪽 방향으로 가게 해서 풀이하면 된다.
 * 
 * BFS를 이용한다면 방향까지 있는 3차원 방문 확인 배열을 이용해서 풀이해주면 될 것 같다.
 * 
 * 주의할 점은 주어진 값이 배열의 범위를 벗어나기 때문에 초기 값을 잘 넣어줘야한다.
**/
class Main {
	static boolean[][] map;
	static int n;
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			map = new boolean[n + 1][n + 1];
			while (r-- > 0) {
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());

				map[row][col] = true;
			}
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int d = setDir(row, col);
			
			dfs(row, col, d, 0);
		}
	}

	public static int setDir(int row, int col) {
		if (row == n + 1)
			return 3;
		if (row == 0)
			return 1;
		if (col == 0)
			return 0;
		return 2;
	}

	public static void dfs(int row, int col, int d, int cnt) {
		if (cnt > n * n) {
			System.out.println(0 + " " + 0);
			return;
		}

		int nextR = row + dirs[d][0];
		int nextC = col + dirs[d][1];

		if (nextR <= 0 || nextC <= 0 || nextR > n || nextC > n) {
			System.out.println(nextR + " " + nextC);
			return;
		}
		if (map[nextR][nextC]) {
			d = (d + 1) % 4;
			dfs(nextR, nextC, d, cnt + 1);
		} else
			dfs(nextR, nextC, d, cnt);
	}
}
