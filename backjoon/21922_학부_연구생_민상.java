
//https://www.acmicpc.net/problem/21922
import java.io.*;
import java.util.*;

/**
 * G5
 * 완전탐색과 약간의 구현!
 * BFS를 이용해서 해도 되지만 DFS로 시도.(DFS가 2배 이상 빠른 것 같다.)
 * 
 * 구슬탈출과 비슷한 유형인데 좀더 쉬운 것 같다.
 * 
 * 에어컨을 기준으로 4방면 다 탐색을 해주었고, 별도의 방문표시는 남겼지만, 그것을 이용해서 분기처리를 하진 않았다.
 * 겹치지만 방향이 달라 재방문할 경우가 생기기 때문이다.
 * 
 * 제일 끝이라면 아예 탐색을 종료하였고, 에어컨이 존재한다면 루프를 나와서 재탐색해주었다.
 * 
 * 다른 풀이들을 보니 BFS/DFS 관계없이 방향 전환만 잘해주면 되는 듯 하다.
 * 
 */
public class Main {
	static int[][] map;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] marked;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		marked = new boolean[N][M];

		List<Dot> aircond = new ArrayList<Dot>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if (cur == 9)
					aircond.add(new Dot(i, j));
				map[i][j] = cur;
			}
		}

		for (Dot a : aircond) {
			marked[a.row][a.col] = true;
			dfs(a, 0);
			dfs(a, 1);
			dfs(a, 2);
			dfs(a, 3);
		}

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (marked[i][j])
					cnt++;
			}
		}

		System.out.println(cnt);
	}

	public static void dfs(Dot cur, int dir) {
		int nextR = cur.row + dirs[dir][0];
		int nextC = cur.col + dirs[dir][1];
		
		while (true) {
			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M)
				return;
			marked[nextR][nextC] = true;
			if (map[nextR][nextC] != 0)
				break;
			nextR += dirs[dir][0];
			nextC += dirs[dir][1];
		}

		if (map[nextR][nextC] == 1) {
			if (dir == 0 || dir == 1)
				dfs(new Dot(nextR, nextC), dir);
		} else if (map[nextR][nextC] == 2) {
			if (dir == 2 || dir == 3)
				dfs(new Dot(nextR, nextC), dir);
		} else if (map[nextR][nextC] == 3) {
			if (dir == 0)
				dir = 3;
			else if (dir == 1)
				dir = 2;
			else if (dir == 2)
				dir = 1;
			else if (dir == 3)
				dir = 0;
			dfs(new Dot(nextR, nextC), dir);
		} else if (map[nextR][nextC] == 4) {
			if (dir == 0)
				dir = 2;
			else if (dir == 1)
				dir = 3;
			else if (dir == 2)
				dir = 0;
			else if (dir == 3)
				dir = 1;
			dfs(new Dot(nextR, nextC), dir);
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
