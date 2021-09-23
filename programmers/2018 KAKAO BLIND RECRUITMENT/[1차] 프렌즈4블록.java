//https://programmers.co.kr/learn/courses/30/lessons/17679
import java.util.*;

class Solution {
	static int N, M;
	static char[][] map;
	static boolean[][] marked;
	static boolean flag;

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		N = board.length;
		M = board[0].length();
		map = new char[N][M];
		marked = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = board[i].toCharArray();
		}
		flag = true;
		while (flag) {
			// 찾기
			find();
			// 지우기
			remove();
			// 내리기
			nextRound();
		}
		return count();
	}

	public static void nextRound() {
		for (int c = 0; c < M; c++) {
			Queue<Character> queue = new LinkedList();
			for (int r = N - 1; r > -1; r--) {
				if (map[r][c] != '0')
					queue.add(map[r][c]);
				map[r][c] = '0';
			}

			int r = N - 1;
			while (!queue.isEmpty()) {
				char cur = queue.poll();
				map[r--][c] = cur;
			}
		}
	}

	public static void remove() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (marked[i][j]) 	map[i][j] = '0';
			}
		}
	}

	public static void find() {

		marked = new boolean[N][M];
		flag = false;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				char r1c1 = map[i][j];
				char r1c2 = map[i][j + 1];
				char r2c1 = map[i + 1][j];
				char r2c2 = map[i + 1][j + 1];
				
				if (r1c1 == '0' || r1c2 == '0' || r2c1 == '0' || r2c2 == '0')	continue;
				if (r1c1 != (r1c2))	continue;
				if (r1c1 != (r2c2))	continue;
				if (r1c1 != (r2c1))	continue;

				marked[i][j] = true;
				marked[i + 1][j] = true;
				marked[i][j + 1] = true;
				marked[i + 1][j + 1] = true;
				flag = true;
			}
		}
	}

	public static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0')
					cnt++;
			}
		}
		return cnt;
	}

}
