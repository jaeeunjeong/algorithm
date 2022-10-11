import java.io.*;
import java.util.*;

public class Main {
	static int[][] basket;
	static boolean[][] cloudMap, removeCloud;
	static int N;
	static int[][] dirs = new int[][] { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, //
			{ 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
	static int[][] cloud = new int[][] { { 0, 1 }, { 0, 2 }, { -1, 0 }, { -1, 2 } };
	static int[][] distanceOne = new int[][] { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		basket = new int[N][N]; // 나는 index-0임!!!
		cloudMap = new boolean[N][N];
		cloudMap[N - 1][0] = true;
		cloudMap[N - 1][1] = true;
		cloudMap[N - 2][0] = true;
		cloudMap[N - 2][1] = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				basket[i][j] = cur;
			}
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			move(d, s);
			addWater();
			copyMagic();

			makeCloud();
		}
		int answer = water();
		System.out.println(answer);
	}

	private static void printBoolean(boolean[][] marked) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int temp = 0;
				if (marked[i][j])
					temp = 1;
				System.out.print(temp + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(basket[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int water() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += basket[i][j];
			}
		}
		return sum;
	}

	private static void makeCloud() {
		cloudMap = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (basket[i][j] >= 2 && !removeCloud[i][j]) {
					cloudMap[i][j] = true;
					basket[i][j] -= 2;
				}
			}
		}
	}

	private static void copyMagic() {
		int[][] addMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloudMap[i][j]) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nextR = i + distanceOne[d][0];
						int nextC = j + distanceOne[d][1];

						if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
							continue;
						if (basket[nextR][nextC] > 0)
							cnt++;
					}
					addMap[i][j] += cnt;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				basket[i][j] += addMap[i][j];
			}
		}
	}

	private static void addWater() {
	}

	private static void move(int d, int s) {
		boolean[][] temp = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!cloudMap[i][j])
					continue;
				int nextR = (50 * N + i + dirs[d][0] * s) % N;
				int nextC = (50 * N + j + dirs[d][1] * s) % N;
				temp[nextR][nextC] = true;
			}
		}

		cloudMap = new boolean[N][N];
		removeCloud = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cloudMap[i][j] = temp[i][j];
				removeCloud[i][j] = cloudMap[i][j];
				if (cloudMap[i][j])
					basket[i][j] += 1; // addwater;
			}
		}
	}
}
