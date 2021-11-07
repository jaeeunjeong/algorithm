//https://www.acmicpc.net/problem/16948
import java.io.*;
import java.util.*;
/**
 * 새로운 이동 방향에 맞게 구현하면서 거리를 구해주면 된다. 
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		int[][] dirs = { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };

		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(r1, c1));
		int[][] distance = new int[N][N];
		distance[r1][c1] = 1;
		while (!queue.isEmpty()) {
			Dot cur = queue.poll();

			for (int i = 0; i < dirs.length; i++) {
				int nextR = cur.row + dirs[i][0];
				int nextC = cur.col + dirs[i][1];

				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
					continue;
				if (distance[nextR][nextC] > 0)
					continue;
				if (cur.row == r2 && cur.col == c2)
					break;
				queue.add(new Dot(nextR, nextC));
				distance[nextR][nextC] = distance[cur.row][cur.col] + 1;
			}
		}

		int answer = distance[r2][c2] - 1;
		System.out.println(answer);

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
