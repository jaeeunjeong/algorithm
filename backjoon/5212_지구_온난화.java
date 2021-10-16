//https://www.acmicpc.net/problem/5212
import java.io.*;
import java.util.*;

/**
 * 1. 땅만 먼저 골라주어서 주변에 바다가 있는지 카운트하며 값을 구해주었다.
 * 2. 땅중에 가장 작은 값, 가장 큰 값을 구해서 직사각형을 만들어주었다.
 * 3. 땅인 부분만 출력.
 **/
class Main {
	static int R, C;
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String cur = st.nextToken();
			map[i] = cur.toCharArray();

		}
		Queue<Dot> queue = new LinkedList<>();
    
		// 땅만 골라내기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X')
					queue.add(new Dot(i, j));
			}
		}
		int[][] seaSide = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				seaSide[i][j] = 4;
			}
		}
    
		// 땅만 새로운 리스트에 넣어서 표시하기.
		int rMax = Integer.MIN_VALUE;
		int rMin = Integer.MAX_VALUE;
		int cMax = Integer.MIN_VALUE;
		int cMin = Integer.MAX_VALUE;
    
		while (!queue.isEmpty()) {
			Dot dot = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextR = dot.row + dirs[d][0];
				int nextC = dot.col + dirs[d][1];
				if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C) continue;
				// 주변에 땅이라면 현재 값을 감소 - > 인접한 칸의 바다인 면의 수
				if (map[nextR][nextC] == 'X') {
					seaSide[dot.row][dot.col]--;
				}
			}
			// 주변의 땅이 4 - x > 2 라면 땅이다.
			if (seaSide[dot.row][dot.col] < 3) {
				rMin = Math.min(rMin, dot.row);
				cMin = Math.min(cMin, dot.col);
				rMax = Math.max(rMax, dot.row);
				cMax = Math.max(cMax, dot.col);
			}
		}
		for (int i = rMin; i <= rMax; i++) {
			for (int j = cMin; j <= cMax; j++) {
				if (seaSide[i][j] > 2) {
					map[i][j] = '.';
				}
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}

class Dot {
	int row;
	int col;

	Dot(int r, int c) {
		this.row = r;
		this.col = c;
	}
}
