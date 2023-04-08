// 뭐가 틀렸는지 모르겠음 ㅠ
import java.io.*;
import java.util.*;

public class Main {
	static int n, m, h, k, dir, score, trackerIdx;
	static int[][] map;
	static boolean[][] treeMap;
	static int[] dice;
	static int[] cur;
	static int[][] turnRight = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] turnleft = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] trackerDirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Runner tracker; // 술래
	static List<Runner> aliveRunner; // 살아있는 러너
	static List<int[]> returnCase;
	static List<Runner>[][] curMap;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		returnCase = new ArrayList<>();
		curMap = new ArrayList[n][n];

		moveCase();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				curMap[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;

			Runner cur = new Runner(x, y, d);
			curMap[x][y].add(cur);
		}
		
		tracker = new Runner(n / 2, n / 2, -1);
		trackerIdx = 1;
		treeMap = new boolean[n][n];
		
    for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			treeMap[x][y] = true;
		}

		int answer = 0;
		int round = 0;
		while (k > round++) {
			checkRunner();
			moveRunner(); // 도망자 움직임 끝!
			moveTracker(); // 술래 움직이기
			int catchCnt = catchRunner(); // 술래ㅏ 잡기
			answer += round * catchCnt;
			trackerIdx++;
			if (trackerIdx == (n * n+1))
				trackerIdx = 0;
		}

		System.out.println(answer);
	}

	private static void checkRunner() {
		aliveRunner = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (Runner cur : curMap[i][j]) {
					aliveRunner.add(cur);
				}
				curMap[i][j].clear();
			}
		}
	}

	private static int catchRunner() {

		// 시야 3이내 술래 잡기.
		int score = 0;
		// System.out.println(tracker.r + ":" + tracker.c);
		for (int distance = 0; distance < 3; distance++) {
			int nextR = tracker.r + trackerDirs[tracker.d][0] * distance;
			int nextC = tracker.c + trackerDirs[tracker.d][1] * distance;
			// System.out.println((nextR + 1) + ";" + (nextC + 1));
			if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= n)
				return score;
			if (treeMap[nextR][nextC])
				continue;
			if (curMap[nextR][nextC].size() == 0)
				continue;

			// 잡앗다
			score += curMap[nextR][nextC].size();
			curMap[nextR][nextC].clear();

		}
		return score;
	}

	private static void moveTracker() {
		int[] cur = returnCase.get(trackerIdx);
		tracker = new Runner(cur[0], cur[1], cur[2]);
	}

	// 턴 수 다 만듦.
	private static void moveCase() {
		int length = 1;
		int dir = 0;
		int[] cur = new int[] { n / 2, n / 2, dir };
		returnCase.add(cur);
		// System.out.println(map[cur[0]][cur[1]]);

		int nextR = cur[0];
		int nextC = cur[1];
		while (length < n) {

			// length 만큼 r, c, 증가 시키기
			for (int i = 0; i < length; i++) {
				nextR += turnRight[dir][0];
				nextC += turnRight[dir][1];

				if (i == length - 1) {
					dir++;
					dir %= 4;
				}

				int[] temp = new int[] { nextR, nextC, dir };
				// System.out.println(map[nextR][nextC]);
				returnCase.add(temp);
			}

			for (int i = 0; i < length; i++) {
				nextR += turnRight[dir][0];
				nextC += turnRight[dir][1];

				if (i == length - 1) {
					dir++;
					dir %= 4;
				}

				int[] temp = new int[] { nextR, nextC, dir };
				// System.out.println(map[nextR][nextC]);
				returnCase.add(temp);
			}

			length++;

		}
		for (int i = 0; i < n - 1; i++) {
			nextR += turnRight[dir][0];
			nextC += turnRight[dir][1];

			if (i == n - 1) {
				dir++;
				dir %= 4;
			}

			int[] temp = new int[] { nextR, nextC, dir };
			// System.out.println(map[nextR][nextC]);
			returnCase.add(temp);
		}

		// 역방향
		cur = new int[] { 0, 0 };
		nextR = 0;
		nextC = 0;
		// System.out.println(map[nextR][nextC]);
		dir = 0;
		int[] temp = new int[] { nextR, nextC, dir };
		// System.out.println(map[nextR][nextC]);
		returnCase.add(temp);
		// length 만큼 r, c, 증가 시키기
		for (int i = 0; i < length - 1; i++) {
			nextR += turnleft[dir][0];
			nextC += turnleft[dir][1];
			if (i == length - 1) {
				dir++;
				dir %= 4;
			}
			temp = new int[] { nextR, nextC, dir };
			// System.out.println(map[nextR][nextC]);
			returnCase.add(temp);
		}

		while (length-- > 0) {

			// length 만큼 r, c, 증가 시키기
			for (int i = 0; i < length; i++) {
				nextR += turnleft[dir][0];
				nextC += turnleft[dir][1];
				if (i == length - 1) {
					dir++;
					dir %= 4;
				}
				temp = new int[] { nextR, nextC, dir };
				// System.out.println(map[nextR][nextC]);
				returnCase.add(temp);
			}

			for (int i = 0; i < length; i++) {
				nextR += turnleft[dir][0];
				nextC += turnleft[dir][1];
				if (i == length - 1) {
					dir++;
					dir %= 4;
				}
				temp = new int[] { nextR, nextC, dir };
				// System.out.println(map[nextR][nextC]);
				returnCase.add(temp);
			}

		}

		// return returnCase;
	}

	private static void moveRunner() {
		// 도망자랑 술래 거리가 3이내인지 확인하기
		List<Runner> targetRunner = isPossibleRun();

		// 3이하인 도망자들 움직이기
		for (Runner run : targetRunner) {

			// System.out.print(run.r + 1 + ":" + (run.c + 1) + "->");
			int nextD = run.d;
			int nextR = run.r + dirs[nextD][0];
			int nextC = run.c + dirs[nextD][1];
			// 격자를 벗어나는 경우
			if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= n) {
				// 방향을 반대로하기
				nextD = (nextD + 2) % 4;

				// System.out.println(nextR + 1 + ":" + (nextC + 1));
				// 술래 있는지 확인하고 한칸 앞으로 이동
				nextR = run.r + dirs[nextD][0];
				nextC = run.c + dirs[nextD][1];
				// System.out.println(nextR + 1 + "::" + (nextC + 1));

			}

			//
			if (nextR == tracker.r && nextC == tracker.c) {
				curMap[run.r][run.c].add(new Runner(run.r, run.c, nextD));
			} else {
				curMap[nextR][nextC].add(new Runner(nextR, nextC, nextD));
			}
		}
	}

	private static List<Runner> isPossibleRun() {
		List<Runner> target = new ArrayList<Runner>();

		// aliveRunner : 현재 지도에 있는 러너
		for (Runner runner : aliveRunner) { // 간단하게 해주기 위해서 넣긴해보자.
			if (calDis(runner))
				target.add(runner); // 잡힐수도 있는 녀석들이 잇음.
			else
				curMap[runner.r][runner.c].add(runner); // aliveRunner.add(runner);
		}

		return target;
	}

	private static boolean calDis(Runner r) {
		return Math.abs(r.r - tracker.r) + Math.abs(r.c - tracker.c) <= 3;
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(curMap[i][j].size() + " ");
			}
			System.out.println();
		}
	}

	static class Runner {
		int r;
		int c;
		int d; // 좌우 0 (0, 2), 상하 1(1, 3) 유형

		public Runner(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}
