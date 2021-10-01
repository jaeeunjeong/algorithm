//https://www.acmicpc.net/problem/1992
import java.io.*;
import java.util.*;

class Main {
	static StringBuffer sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		sb = new StringBuffer();
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		dfs(map, 0, 0, N);
		System.out.println(sb.toString());

	}

	public static void dfs(char[][] map, int x, int y, int size) {
		if (size == 1) {
			sb.append(map[x][y]);
			return;
		}
		boolean isZero = true, isOne = true;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] == '0')
					isOne = false;
				if (map[i][j] == '1')
					isZero = false;
			}
		}
		if (isOne) {
			sb.append("1");
			return;
		}
		if (isZero) {
			sb.append("0");
			return;
		}
		sb.append("(");
		size /= 2;
		dfs(map, x, y, size);
		dfs(map, x, y + size, size);
		dfs(map, x + size, y, size);
		dfs(map, x + size, y + size, size);
		sb.append(")");

	}
}
