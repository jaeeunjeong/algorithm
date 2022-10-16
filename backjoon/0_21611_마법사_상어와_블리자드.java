import java.io.*;
import java.util.*;

class Main {
	static int[][] map;
	static int[] arr, answer;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		answer = new int[4];
		arr = new int[N * N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			step1(d, s); // 해당 방향으로 파괴하기
			// print();
			// 빈칸으로 당겨서 큐로 만들어서 4개 이상은 없애기.
			makeQueue();
			while (step2());
			// print();
			// 구슬 새로 만들기
			int[] result = step3();
			// print();
			// 다시 2차원으로 만들기.
			makeMap(result);
		}
		int answer = cal();
		System.out.println(answer);
	}

	private static int cal() {
		return answer[1] * 1 + answer[2] * 2 + answer[3] * 3;
	}

	private static void makeMap(int[] arr) {

		int nextR = N / 2;
		int nextC = N / 2;

		int length = 1;
		int d = 0;
		int[][] dirs = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		int idx = 0;
		while (length < N) {

			for (int i = 0; i < length; i++) {
				nextR += dirs[d][0];
				nextC += dirs[d][1];
				map[nextR][nextC] = arr[idx++];
			}
			d = (d + 1) % 4;
			for (int i = 0; i < length; i++) {
				nextR += dirs[d][0];
				nextC += dirs[d][1];
				map[nextR][nextC] = arr[idx++];
			}
			d = (d + 1) % 4;
			length++;
		}

		// 마지막은 따로 넣어주기.
		for (int i = 0; i < length - 1; i++) {
			nextR += dirs[d][0];
			nextC += dirs[d][1];
			map[nextR][nextC] = arr[idx++];
		}
	}

	private static int[] step3() {
		int[] result = new int[N * N * N];
		int idx = 0;
		for (int i = 0; i < N * N; i++) {
			int j = 0;
			int cnt = 0;
			if (arr[i] == 0)
				break;
			for (j = i; j < N * N; j++) {
				if (arr[i] == arr[j])
					cnt++;
				else
					break;
			}

			result[idx++] = cnt;
			result[idx++] = arr[i];
			i = j - 1;

		}
		return result;
	}
	private static void compress() {
		int last = 0;
		for (int i = 0; i < N * N; i++) {
			if (arr[i] == 0)
				continue;
			arr[last++] = arr[i];
		}
		for (int i = last; i < N * N; i++) {
			arr[i] = 0;
		}
	}
	// 4개이상 연속하는 것 폭발
	private static boolean step2() {
		boolean flag = false;
		for (int i = 0; i < N * N;) {
			int j = i + 1;
			if (arr[i] == 0)
				break;
			while (arr[i] == arr[j]) {
				j++;
			}

			if (j - i >= 4) {
				flag = true;
				for (int k = i; k < j; k++) {
					answer[arr[k]]++;
					arr[k] = 0;
				}
			}
			i = j;
		}

		if (flag)
			compress();
		return flag;
	}

	private static int getStartIdx() { 
		for (int i = 0; i < N * N; i++) {
			if (arr[i] == 0)
				continue;
			int cnt = 0;
			for (int j = i + 1; j < N * N; j++) {
				if (arr[i] == arr[j])
					cnt++;
				else
					break;
				if (cnt >= 3) {
					return i;
				}
			}
		}
		return -1;
	}

	// 달팽이 돌기.
	private static void makeQueue() {

		int nextR = N / 2;
		int nextC = N / 2;

		int length = 1;
		int d = 0;
		int idx = 0;
		int[][] dirs = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		while (length < N) {
			for (int i = 0; i < length; i++) {
				nextR += dirs[d][0];
				nextC += dirs[d][1];
				if (map[nextR][nextC] == 0)
					continue;
				arr[idx++] = map[nextR][nextC];
			}
			d = (d + 1) % 4;
			for (int i = 0; i < length; i++) {
				nextR += dirs[d][0];
				nextC += dirs[d][1];
				if (map[nextR][nextC] == 0)
					continue;
				arr[idx++] = map[nextR][nextC];
			}
			d = (d + 1) % 4;
			length++;
		}

		// 마지막은 따로 넣어주기.
		for (int i = 0; i < length - 1; i++) {
			nextR += dirs[d][0];
			nextC += dirs[d][1];
			arr[idx++] = map[nextR][nextC];
		}
	}

	private static void step1(int d, int s) {
		int[][] dirs = new int[][] { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		for (int i = 1; i <= s; i++) {
			int nextR = N / 2 + dirs[d][0] * i;
			int nextC = N / 2 + dirs[d][1] * i;
			map[nextR][nextC] = 0;
		}
	}
}
