//https://www.acmicpc.net/problem/20165 
import java.io.*;
import java.util.*;

/**
 * Queue를 이용한 구현 문제!
 * 이미 쓰러져 있는 것을 발견하면 그 값은 쓰러뜨릴 수 없어서 queue에 담아주지 않아야 한다.
 * 좌표가 누적되는 것임을 유의해야한다.
 **/
class Main {
	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] marked = new boolean[N][M];
		Map<String, Integer> dirsIdx = new HashMap<>();
		int idx = 0;
		dirsIdx.put("E", idx++);
		dirsIdx.put("W", idx++);
		dirsIdx.put("S", idx++);
		dirsIdx.put("N", idx++);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
			}
		}
		
		int cnt = 0;
		while (R-- > 0) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			int dir = dirsIdx.get(st.nextToken());
			if (!marked[row][col]) {
				Queue<Dot> queue = new LinkedList<>();
				queue.add(new Dot(row, col));
				marked[row][col] = true;
				cnt++;
				while (!queue.isEmpty()) {
					Dot dot = queue.poll();
					int times = map[dot.row][dot.col] - 1;
					int nextR = dot.row;
					int nextC = dot.col;

					while (times-- > 0) {
						nextR += dirs[dir][0];
						nextC += dirs[dir][1];

						if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M)
							continue;
						if (marked[nextR][nextC])
							continue;
						marked[nextR][nextC] = true;
						queue.add(new Dot(nextR, nextC));
						cnt++;
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken()) - 1;
			col = Integer.parseInt(st.nextToken()) - 1;
			marked[row][col] = false;
		}
		System.out.println(cnt);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				String str = "S";
				if (marked[i][j])
					str = "F";
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}

class Dot {
	int row;
	int col;

	Dot(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
