//https://www.acmicpc.net/problem/3055
import java.io.*;
import java.util.*;

class Main {
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] times;
	static char[][] map;
	static Queue<Dot> water;
	static int R, C, answer;
	static boolean[][] marked;
	static int x = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		water = new LinkedList<>();
		answer = Integer.MAX_VALUE;
		map = new char[R][C];
		times = new int[R][C];
		marked = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Dot hedgehog = null;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					hedgehog = new Dot(i, j);
					map[i][j] = '.';
				}
				if (map[i][j] == '*')
					water.add(new Dot(i, j));
			}
		}
		move(hedgehog);
		if (answer == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(answer + 1);
		}
	}

	public static void move(Dot hedgehog) {
		Queue<Dot> queue = new LinkedList<>();
		Queue<Dot> temp = new LinkedList<>();
		queue.add(hedgehog);
		marked[hedgehog.r][hedgehog.c] = true;
    boolean[][] waterMarked = new boolean[R][C];
		while (!queue.isEmpty()) {
			while (!water.isEmpty()) {
				Dot spot = water.poll();
				for (int d = 0; d < 4; d++) {
					int nextR = spot.r + dirs[d][0];
					int nextC = spot.c + dirs[d][1];

					if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C)
						continue;
					if (map[nextR][nextC] == 'D' || map[nextR][nextC] == 'X')
						continue;
					if (marked[nextR][nextC] || waterMarked[nextR][nextC])
						continue;
					map[nextR][nextC] = '*';
					waterMarked[nextR][nextC] = true;
					temp.add(new Dot(nextR, nextC));
				}
			}
			while (!temp.isEmpty()) {
				water.add(temp.poll());
			}
			while (!queue.isEmpty()) {
				Dot cur = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nextR = cur.r + dirs[d][0];
					int nextC = cur.c + dirs[d][1];

					if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C)
						continue;
					if (map[nextR][nextC] == '*' || map[nextR][nextC] == 'X')
						continue;
					if (marked[nextR][nextC])
						continue;
					if (map[nextR][nextC] == 'D') {
						answer = times[cur.r][cur.c];
						return;
					}
					marked[nextR][nextC] = true;
					if(times[nextR][nextC]!= 0 && times[cur.r][cur.c]+1 > times[nextR][nextC]) continue;
					times[nextR][nextC] = times[cur.r][cur.c] + 1;
					temp.add(new Dot(nextR, nextC));
				}
			}
			while (!temp.isEmpty()) {
				queue.add(temp.poll());
			}
		}
	}
}

class Dot {
	int r;
	int c;

	Dot(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
