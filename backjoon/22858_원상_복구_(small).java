//https://www.acmicpc.net/problem/22858 
import java.io.*;
import java.util.*;
/*
 * 문제에서 제시한 대로 구현하면 되는 문제
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] rules = new int[N + 1];
		int[] result = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			rules[i] = Integer.parseInt(st.nextToken());
		}
		// 옮기기
		while (K-- > 0) {
			int[] now = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				int nowIdx = rules[i];
				now[nowIdx] = result[i];
			}
			result = now;
		}
		// result는 인덱스의 위치임.
		for (int i = 1; i <= N; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
