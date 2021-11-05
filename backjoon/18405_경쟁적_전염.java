//https://www.acmicpc.net/problem/18405
import java.io.*;
import java.util.*;
/**
 * 이 문제의 포인트는
 * 1. 바이러스가 1개이상의 위치에 존재하고 1초에 한칸만 움직인다.
 * 2. 바이러스는 값을 가지고 있으며 번호가 낮은 종류의 바이러스만 들어간다.
 * 이 두개인 것 같다.
 * 
 * BFS는 아니고 단순 4방면 탐색인데, 이미 바이러스가 존재하면 들어갈 수 없기에 확인해줘야한다.(marked[][])
 * 이미 퍼진 바이러스는 추가로 퍼질 필요가 없기에 새로 생긴 애들만 queue나 list등에 넣어준다. 이때 중복으로 들어갈 수 있으니 유의.
 * 
 * 나의 경우 퍼질 수 있는 바이러스를 queue에 담고 해당하는 애들을 먼저 표시를 해줌으로써, 값이 바뀌는 경우를 방지하였다.
 * 또한 한 시점에 한 위치에 여러개 바이러스가 들어갈 수 있을 떄 정렬을 사용하는 것 대신, 작은 값을 넣어주는 식으로 처리하였다.
 * 최초에 들어가는 값은 result Queue에 넣어주어 다음 탐색시 사용할 수 있도록 하였다.
**/
class Main {
	static int[][] map;
	static boolean[][] marked;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Queue<Dot> queue = new LinkedList<Dot>();

		map = new int[N][N];
		marked = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0)
					queue.add(new Dot(i, j));
				else
					map[i][j] = Integer.MAX_VALUE;
			}
		}
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		int Y = Integer.parseInt(st.nextToken()) - 1;
		while (S-- > 0) {
			queue = bfs(queue);
		}

		int answer = map[X][Y];
		if (answer == Integer.MAX_VALUE)
			answer = 0;
		System.out.println(answer);
	}

	public static Queue<Dot> bfs(Queue<Dot> queue) {
		Queue<Dot> result = new LinkedList();
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (Dot d : queue)
			marked[d.row][d.col] = true;

		while (!queue.isEmpty()) {
			Dot cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextR = cur.row + dirs[i][0];
				int nextC = cur.col + dirs[i][1];

				if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
					continue;
				if (marked[nextR][nextC])
					continue;
				if (map[nextR][nextC] == Integer.MAX_VALUE)
					result.add(new Dot(nextR, nextC));

				map[nextR][nextC] = Math.min(map[nextR][nextC], map[cur.row][cur.col]);

			}
		}
		return result;
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
