//https://www.acmicpc.net/problem/18428 
import java.io.*;
import java.util.*;

/**
 * 선생님이 최대 8명, 장애물이 최대 3개, 움직일 수 있는 공간 최대 36개임을 감안할 떄,
 * 백트래킹 이용해서 완전 탐색으로 충분히 시간내에 풀이 할 수 있다.
 * 
 * 선생님과 장애물을 배정할 수 있는 공간을 리스트로 모아둔다.
 * 이후 장애물을 3개씩 적절하게 배치할 수 있도록 백트래킹을 이용한다 -> 3중 for문도 가능할 것 같다.
 * 장애물을 배치하고, 또 지워주는 과정을 통해 반복해서 경우의 수를 구해준다.
 * 장매물이 배치된 곳을 토대로 선생님들이 감시할 수 있는 모든 경우를 확인하면서 감시로부터 피할 수 있는지 아닌지 확인한다. 
 */
public class Main {
	static int N;
	static boolean answer;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static char[][] map;
	static List<int[]> teachers, X;
	static boolean[] marked;
	static int[] o = new int[3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		teachers = new ArrayList<>();
		X = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().toCharArray()[0];
				if (map[i][j] == 'T')
					teachers.add(new int[] { i, j });
				if (map[i][j] == 'X')
					X.add(new int[] { i, j });
			}
		}
		marked = new boolean[X.size()];
		objects(0);
		if (answer)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static void objects(int idx) {
		if (answer)
			return;
		if (idx == 3) {
			for (int curIdx : o) {
				int[] cur = X.get(curIdx);
				map[cur[0]][cur[1]] = 'O';
			}
			boolean isHide = true;
			;
			// 선생님 파악하기.
			for (int[] teacher : teachers) {
				for (int d = 0; d < 4; d++) {
					int nextR = teacher[0];
					int nextC = teacher[1];

					while (true) {
						if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
							break;
						if (map[nextR][nextC] == 'O')
							break;
						if (map[nextR][nextC] == 'S') {
							isHide = false;
							break;
						}
						nextR += dirs[d][0];
						nextC += dirs[d][1];
					}
				}
			}

			for (int curIdx : o) {
				int[] cur = X.get(curIdx);
				map[cur[0]][cur[1]] = 'X';
			}

			if (isHide)
				answer = true;
			return;
		}
		for (int i = 0; i < X.size(); i++) {
			if (marked[i])
				continue;
			marked[i] = true;
			o[idx] = i;
			objects(idx + 1);
			marked[i] = false;
		}
	}
}
