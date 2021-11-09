//https://www.acmicpc.net/problem/18404
import java.io.*;
import java.util.*;

/**
 * 요구 사항대로 구현하면 된다.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] distance = new int[N][N];
		int[][] dirs = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };

		LinkedList<Dot> result = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken()) - 1;
		int col = Integer.parseInt(st.nextToken()) - 1;
		distance[row][col] = 0;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int rowTemp = Integer.parseInt(st.nextToken()) - 1;
			int colTemp = Integer.parseInt(st.nextToken()) - 1;
			result.add(new Dot(rowTemp, colTemp));
		}

		boolean[][] marked = new boolean[N][N];
		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(row, col));
		marked[row][col] = true;
		while (!queue.isEmpty()) {
			Dot cur = queue.poll();

			for (int d = 0; d < dirs.length; d++) {
				int nextR = cur.row + dirs[d][0];
				int nextC = cur.col + dirs[d][1];
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
					continue;
				if (marked[nextR][nextC])
					continue;
				distance[nextR][nextC] = distance[cur.row][cur.col] + 1;
				queue.add(new Dot(nextR, nextC));
				marked[nextR][nextC] = true;
			}
		}
		for (Dot d : result)
			System.out.print(distance[d.row][d.col] + " ");
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
