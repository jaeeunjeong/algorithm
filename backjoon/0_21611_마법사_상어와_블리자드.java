import java.io.*;
import java.util.*;

public class Main {
	// static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static int[] arrA, arrB, ans;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		arrA = new int[N * N];
		arrB = new int[N * N];
		ans = new int[4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			blizad(d, s);
			// print();
			// printArr();
			compress();
			// printArr();
			while (bomb())
				;
			change();
//			print();
		}
		int answer = ans[1] * 1 + ans[2] * 2 + ans[3] * 3;
		System.out.println(answer);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void printArr() {
		for (int i = 0; i < N * N; i++) {
			System.out.print(arrA[i] + " ");
		}
		System.out.println();
	}

	// 구슬 숫자와 갯수 파악해서 새로운 배열만드는 메서드
	private static void change() {
		arrB = new int[N * N];
		int idx = 0;
		for (int i = 0; i < N * N;) {
			int j = i + 1;
			int cnt = 1;
			if(arrA[i] == 0) break;
			while (j < N * N && arrA[i] == arrA[j++])
				cnt++;
			arrB[idx++] = cnt;
			arrB[idx++] = arrA[i];
			if (idx == N * N -1)
				break;
			i = j -1;
		}
		for (int i = 0; i < N * N; i++) {
			arrA[i] = arrB[i];
		}
		// 다시 달팽이에 넣어주기.
		int[][] dirs = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		int d = 0;
		idx = 0;
		int length = 1;
		int nextR = N / 2;
		int nextC = N / 2;
		while (idx < N * (N - 1)) {
			for (int times = 0; times < 2; times++) {
				for (int i = 0; i < length; i++) {
					nextR += dirs[d][0];
					nextC += dirs[d][1];
					map[nextR][nextC] = arrA[idx++];
				}
				d = (d + 1) % 4;
				for (int i = 0; i < length; i++) {
					nextR += dirs[d][0];
					nextC += dirs[d][1];
					map[nextR][nextC] = arrA[idx++];
				}
				d = (d + 1) % 4;
				length++;
			}
		}
		for (int i = 0; i < length - 1; i++) {
			nextR += dirs[d][0];
			nextC += dirs[d][1];
			map[nextR][nextC] = arrA[idx++];
		}
	}

	// 4개이상 연속하는 것 폭발
	private static boolean bomb() {
		boolean flag = false;
		for (int i = 0; i < N * N;) {
			int j = i + 1;
			if (arrA[i] == 0)
				break;
			while (arrA[i] == arrA[j]) {
				j++;
			}

			if (j - i >= 4) {
				flag = true;
				for (int k = i; k < j; k++) {
					ans[arrA[k]]++;
					arrA[k] = 0;
				}
			}
			i = j;
		}

		if (flag)
			compress();
		return flag;
	}

	// 0을 당기기
	private static void compress() {
		int last = 0;
		for (int i = 0; i < N * N; i++) {
			if (arrA[i] == 0)
				continue;
			arrA[last++] = arrA[i];
		}
		for (int i = last; i < N * N; i++) {
			arrA[i] = 0;
		}
	}

	private static void blizad(int d, int s) {
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int i = 1; i <= s; i++) {
			int nextR = N / 2 + dirs[d][0] * i;
			int nextC = N / 2 + dirs[d][1] * i;
			map[nextR][nextC] = 0;
		}
		// 1차원으로 가져오기.
		int nextR = N / 2;
		int nextC = N / 2;
		int length = 1;
		int idx = 0;
		dirs = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		d = 0;
		while (idx < N * (N - 1)) {
			for (int times = 0; times < 2; times++) {
				for (int i = 0; i < length; i++) {
					nextR += dirs[d][0];
					nextC += dirs[d][1];
					arrA[idx++] = map[nextR][nextC];
				}
				d = (d + 1) % 4;
				for (int i = 0; i < length; i++) {
					nextR += dirs[d][0];
					nextC += dirs[d][1];
					arrA[idx++] = map[nextR][nextC];
				}
				d = (d + 1) % 4;
				length++;
			}
		}
		for (int i = 0; i < length - 1; i++) {
			nextR += dirs[d][0];
			nextC += dirs[d][1];
			arrA[idx++] = map[nextR][nextC];
		}
	}
}
