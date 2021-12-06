//https://www.acmicpc.net/problem/21938 
import java.awt.Point;
import java.io.*;
import java.util.*;

/**
 * S2 BFS + 
 * 1. 평균을 구해준다.
 * 2. 평균과 경계값과의 관계를 파악하여 다시  map을 갱신한다.
 * 3. bfs를 이용하여 물체의 범위 및 결과를 파악한다.
 */
public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] marked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		marked = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				int R = Integer.parseInt(st.nextToken());
				int G = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				int avg = R + G + B;
				avg /= 3;
				map[i][j] = avg;
			}
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] >= T)
					map[i][j] = 255;
				else
					map[i][j] = 0;
			}
		}
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 255 && !marked[i][j]) {
					answer++;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(answer);
	}

	public static void bfs(int row, int col) {
		Point point = new Point(row, col);
		Queue<Point> queue = new LinkedList<>();
		queue.add(point);
		marked[row][col] = true;
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nextR = cur.x + dirs[d][0];
				int nextC = cur.y + dirs[d][1];
				
				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) continue;
				if (marked[nextR][nextC]) continue;
				if (map[nextR][nextC] != 255) continue;
				
				queue.add(new Point(nextR, nextC));
				marked[nextR][nextC] = true;
			}
		}
	}
}
