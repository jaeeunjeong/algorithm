//https://www.acmicpc.net/problem/2156
import java.io.*;
import java.util.*;

/**
 * 이전에 풀었던 계단 오르기와 같은 문제.
 * 배열의 0, 1, 2 인덱스를 먼저 값을 지정해주는데,
 *  0은 그대로 1은 0+1;
 *  2는 최대 값을 두칸 이전것과 현재 것의 앞(건너 뛴 경우), 바로 앞것과 현재 것의 앞(건너 뛰지 않은 경우), 현재 값 건너 뛰기 
 *  이렇게 세 단계 중 최대 값을 확인해 주면 된다.
 **/
class Main {
	static boolean[][] map;
	static int n;
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if (N == 1) {
			System.out.println(arr[0]);
			return;
		}
		if (N == 2) {
			System.out.println(arr[0] + arr[1]);
			return;
		}

		// 0은 순서대로 가는 중
		// 1은 하나 건너뛰눈 것.
		int[] result = new int[N];
		result[0] = arr[0];
		result[1] = arr[0] + arr[1];
		result[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
		result[2] = Math.max(result[1], result[2]);

		for (int i = 3; i < N; i++) {
			result[i] = Math.max(result[i - 2], result[i - 3] + arr[i - 1]) + arr[i];
			result[i] = Math.max(result[i - 1], result[i]);
		}
		int answer = result[N - 1];
		System.out.println(answer);
	}
}
