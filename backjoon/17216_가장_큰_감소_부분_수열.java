//https://www.acmicpc.net/problem/17216
import java.io.*;
import java.util.*;

/**
 * 앞뒤 값을 비교해주고
 * 문제의 요구 사향과 달리 값이 크다면 큰 값을 만들어준다.
 * (현재 값이  당시 제일 큰 값보다 크다면 result에 넣어주고 아니라면 값을 더해서 제일 큰 값 만들어주기)
 * 메모이제이션 문제.
 * 요리조리 분기처리해서 풀어보려했는데 틀려서 메모이제이션으로 풀이.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] result = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
			result[i] = cur;
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					result[i] = Math.max(result[i], result[j] + arr[i]);
				}
			}
		}

		int answer = Integer.MIN_VALUE;

		for (int x : result) 
			answer = Math.max(answer, x);
			
		System.out.println(answer);
	}
}
