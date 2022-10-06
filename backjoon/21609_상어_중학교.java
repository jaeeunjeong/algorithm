// https://www.acmicpc.net/problem/21609
import java.io.*;
import java.util.*;

public class Main {
	static int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[] target;
	static int size, rainbowCnt, N, M, answer, max, NUMBER;
	static boolean[][] marked;
	static int[][] map;
	static PriorityQueue<Block> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		map = new int[N][N];
		NUMBER = M + 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			init();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == NUMBER)
						continue;
					resetZero();
					if (map[i][j] > 0 && !marked[i][j]) {
						marked[i][j] = true;
						findBlock(i, j, map[i][j]);
					}
				}
			}
			if (max == 1)
				break;
			answer += (max * max);
			Block targetB = pq.poll();
			target = new int[] { targetB.row, targetB.col };
			remove();
			gravity();
			turnLeft();
			gravity();
		}
		System.out.println(answer);
	}

	private static void turnLeft() {
		int[][] temp = new int[N][N];
		// 반시계 회전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[N - j - 1][i] = map[i][j];
			}
		}

		// 옮겨주기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}

	private static void gravity() {
		for (int c = 0; c < N; c++) {
			int idx = N - 1;
			for (int r = N - 1; r >= 0; r--) {
				if (map[r][c] == NUMBER) {
					continue;
				}
				if (map[r][c] == -1) {
					idx = r - 1;
					continue;
				}
				if (idx == r) {
					idx--;
					continue;
				}
				map[idx--][c] = map[r][c];
				map[r][c] = NUMBER;
			}
		}
	}

	private static void remove() {
		Queue<int[]> queue = new LinkedList<>();
		marked = new boolean[N][N];
		queue.add(target);
		marked[target[0]][target[1]] = true;
		int cur = map[target[0]][target[1]];
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextR = now[0] + dirs[d][0];
				int nextC = now[1] + dirs[d][1];
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
					continue;
				if (marked[nextR][nextC])
					continue;
				if (map[nextR][nextC] != 0 && cur != map[nextR][nextC])
					continue; // 색이 같은데 무지개 블록은 상관 없음.
				if (map[nextR][nextC] < 0)
					continue;
				map[nextR][nextC] = NUMBER;
				marked[nextR][nextC] = true;
				queue.add(new int[] { nextR, nextC });
			}
		}
		map[target[0]][target[1]] = NUMBER;
	}

	private static void findBlock(int r, int c, int value) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });
		int cnt = 1;
		int rainbow = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextR = cur[0] + dirs[d][0];
				int nextC = cur[1] + dirs[d][1];
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
					continue;
				if (marked[nextR][nextC])
					continue;
				if (map[nextR][nextC] != 0 && value != map[nextR][nextC])
					continue; // 색이 같은데 무지개 블록은 상관 없음.
				if (map[nextR][nextC] < 0)
					continue;
				if (map[nextR][nextC] == 0)
					rainbow++;
				marked[nextR][nextC] = true;
				queue.add(new int[] { nextR, nextC });
				cnt++;
			}
		}
		if (max <= cnt) {
			pq.add(new Block(r, c, cnt, rainbow));
			max = cnt;
		}
	}

	private static void init() {
		target = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
		size = Integer.MIN_VALUE;
		rainbowCnt = 0;
		marked = new boolean[N][N];
		max = 1;
		pq = new PriorityQueue<>();
	}

	private static void resetZero() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					marked[i][j] = false;
			}
		}
	}
}

class Block implements Comparable<Block> {
	int row;
	int col;
	int size;
	int rainbow;

	Block(int row, int col, int size, int rainbow) {
		this.row = row;
		this.col = col;
		this.size = size;
		this.rainbow = rainbow;
	}

	@Override
	public int compareTo(Block o) {
		if (this.size == o.size) {
			if (this.rainbow == o.rainbow) {
				if (this.row == o.row)
					return -this.col + o.col;
				return -this.row + o.row;
			}
			return -this.rainbow + o.rainbow;
		}
		return -this.size + o.size;
	}
}
