// https://www.acmicpc.net/problem/23288
import java.io.*;
import java.util.*;

/*
 * 완전 탐색과 주사위 구현이 결합된 문제
 * 완전 탐색은 BFS를 이용했고, 
 * 주사위는 1차원 배열에서 주사위의 위치와 인덱스를 맵핑하고 그 안에서의 규칙을 이용해서 구현하였다.
 */
public class Main {
	static int N, M, K, d;
	static int[] dice;
	static int[][] map;
	static int[][] dirs = new int[][] { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } }; // 시계 방향 (3이 동쪽임)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dice = new int[7];
		map = new int[N][M];
		d = 3;
		int x = 0;
		int y = 0;
		for (int i = 0; i <= 6; i++)
			dice[i] = i;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int cur = Integer.parseInt(st.nextToken());
				map[i][j] = cur;
			}
		}
		int answer = 0;

		while (K-- > 0) {
			// 주사위가 이동 방향으로 한칸 이동하기 -> 이동 할 수 없다면 반대로 한 다음 한 칸 굴러간다.
			int nextX = x + dirs[d][0];
			int nextY = y + dirs[d][1];
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
				d = (d + 2) % 4; // 방향 반대로!!!!
				nextX = x + dirs[d][0];
				nextY = y + dirs[d][1];
			}

			// 이동 방향으로 한 칸 이동한다.
			move();
			int A = dice[6];
			int B = map[nextX][nextY];

			// 새로운 이동 방향
			newDir(A, B);

			int C = route(B, new int[] { nextX, nextY });
			answer += (B * C);

			x = nextX;
			y = nextY;
		}
		System.out.println(answer);
	}

	private static int route(int b, int[] start) {
		int length = 1;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] marked = new boolean[N][M];
		queue.add(start);
		marked[start[0]][start[1]] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nextX = cur[0] + dirs[d][0];
				int nextY = cur[1] + dirs[d][1];
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;
				if (marked[nextX][nextY])
					continue;
				if (map[nextX][nextY] != map[cur[0]][cur[1]])
					continue;
				marked[nextX][nextY] = true;
				queue.add(new int[] { nextX, nextY });
				length++;
			}
		}
		return length;
	}

	private static void newDir(int A, int B) {
		if (A > B) {
			d = (d + 1) % 4;
		} else if (A < B) {
			d = (d + 3) % 4;
		}
	}

	private static void move() {
		int temp = 0;
		switch (d) {
		case 0: // 남
			temp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = temp;
			break;
		case 1: // 서
			temp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = temp;
			break;
		case 2: // 북
			temp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = temp;
			break;
		case 3: // 동
			temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = temp;
			break;

		default:
			break;
		}
	}
}
