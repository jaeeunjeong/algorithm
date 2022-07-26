// https://www.acmicpc.net/problem/16162
import java.io.*;
import java.util.*;

/**
 * 등차 수열 식을 세우고 등차수열에 맞는 값을 찾으면 되는 문제!
 * 
 * 풀이는 쉬운데 말이 좀 헷갈렸다 ㅠㅠ
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
		}

		for (int i = 0; i < N; i++) {
			int cur = arr[i];
			if (cur == A + (D * cnt))
				cnt++;
		}

		System.out.println(cnt);
	}
}
