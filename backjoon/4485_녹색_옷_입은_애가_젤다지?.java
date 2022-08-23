
//https://www.acmicpc.net/problem/4485 
import java.io.*;
import java.util.*;

/**
 * 다익스트라 문제!
 * 유형만 알면 그대로 풀면 된다. 주의할 것은 출력 방식임...
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int idx = 1;
		while (true) {
			if (N == 0)
				break;
			int[][] map = new int[N][N];
			int[][] distance = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			int answer = score(map, distance);
			System.out.println("Problem " + idx + ": " + answer);
			N = Integer.parseInt(br.readLine());
			idx++;
		}
	}

	private static int score(int[][] map, int[][] distance) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		distance[0][0] = map[0][0];
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextR = cur[0] + dirs[d][0];
				int nextC = cur[1] + dirs[d][1];

				if (nextR < 0 || nextC < 0 || nextR >= map.length || nextC >= map.length)
					continue;
				int nextValue = distance[cur[0]][cur[1]] + map[nextR][nextC];
				int curValue = distance[nextR][nextC];
				if (nextValue >= curValue)
					continue;
				distance[nextR][nextC] = nextValue;
				queue.add(new int[] { nextR, nextC });
			}
		}
		return distance[map.length - 1][map.length - 1];
	}
}
