//https://www.acmicpc.net/problem/17829 
import java.io.*;
import java.util.*;

/**
 * 분할정복으로 풀어도 되고 단순 구현으로 풀어도 되는 문제.
 * 단순 구현으로 풀면 계속해서 배열을 새로 만들고 정렬을 통해 배열을 새로 만들어주면 된다
 * 분할정복으로 풀면 구간에 대해 생각을 잘 해줘야한다. 
 * 4구간으로 나눠서 풀어보려고 했는데 뜻대로 되지 않았다...
 * 분할 정복으로 풀어보긴 했는데 배열을 새로 만들어준거라 별 차이는 없어보임.
 */
class Main {
	static int[][] map;
	static int answer, N;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursive(map, N);
		System.out.println(answer);
//		solve();
//		System.out.println(map[0][0]);
	}

	public static void recursive(int[][] arr, int length) {
		if (length == 1) {
			answer = arr[0][0];
			return;
		}
		int[][] result = new int[length / 2][length / 2];
		int[] sort = new int[4];
		for (int i = 0; i < length; i += 2) {
			for (int j = 0; j < length; j += 2) {
				int idx = 0;
				sort[idx++] = arr[i][j];
				sort[idx++] = arr[i + 1][j];
				sort[idx++] = arr[i][j + 1];
				sort[idx++] = arr[i + 1][j + 1];

				Arrays.sort(sort);
				result[i / 2][j / 2] = sort[2];
			}
		}
		recursive(result, length/2);
	}

	public static void solve() {
		while (true) {
			int[][] temp = new int[N / 2][N / 2];
			int[] sort = new int[4];
			for (int i = 0; i < N; i += 2) {
				for (int j = 0; j < N; j += 2) {
					int idx = 0;
					sort[idx++] = map[i][j];
					sort[idx++] = map[i + 1][j];
					sort[idx++] = map[i][j + 1];
					sort[idx++] = map[i + 1][j + 1];

					Arrays.sort(sort);
					temp[i / 2][j / 2] = sort[2];
				}
			}
			N /= 2;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[i][j];
				}
			}
			if (N == 1)
				break;
		}
	}
}
