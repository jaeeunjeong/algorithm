//https://www.acmicpc.net/problem/20056
import java.io.*;
import java.util.*;

/**
 * 모듈러연산에 유의해서 구현하라는 대로 풀면 되는 문제
 */
public class Main {
	static int N, M, K;
	static int[][] dirs = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static List<FireBall>[][] map;
	static boolean[][] marked;
	static List<FireBall> balls;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		balls = new ArrayList<FireBall>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			FireBall ball = new FireBall(r, c, m, s, d);
			balls.add(ball);
		}
		while (K-- > 0) {
			step1();
			step2();
		}
		int answer = 0;
		for (FireBall ball : balls)
			answer += ball.m;
		System.out.println(answer);
	}
	private static void step2() {
		balls = new ArrayList<FireBall>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				List<FireBall> now = map[i][j];
				if (now.size() == 1) {
					balls.add(now.get(0));
					continue;
				}
				if (now.size() == 0)
					continue;
				int totalM = 0;
				int totalS = 0;
				int totalD = 0;
				boolean[] oddOrEven = new boolean[2];
				for (FireBall ball : now) {
					totalM += ball.m;
					totalS += ball.s;
					totalD = (ball.d %2);
					oddOrEven[totalD] = true;
				}
				totalM /= 5;
				totalS /= now.size();
				if (totalM == 0)
					continue;
				if (oddOrEven[0] && oddOrEven[1]) {
					balls.add(new FireBall(i, j, totalM, totalS, 1));
					balls.add(new FireBall(i, j, totalM, totalS, 3));
					balls.add(new FireBall(i, j, totalM, totalS, 5));
					balls.add(new FireBall(i, j, totalM, totalS, 7));
				} else {
					balls.add(new FireBall(i, j, totalM, totalS, 0));
					balls.add(new FireBall(i, j, totalM, totalS, 2));
					balls.add(new FireBall(i, j, totalM, totalS, 4));
					balls.add(new FireBall(i, j, totalM, totalS, 6));
				}
			}
		}
	}

	private static void step1() {
		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for (FireBall ball : balls) {
			int d = ball.d;
			int s = ball.s % N;
			int nextR = ball.r;
			int nextC = ball.c;
			ball.r = ((nextR + dirs[d][0] * s) + 2 * N) % N;
			ball.c = ((nextC + dirs[d][1] * s) + 2 * N) % N;
			map[ball.r][ball.c].add(ball);
		}
	}

	static class FireBall {
		int r;
		int c;
		int m;
		int s;
		int d;

		FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
}
