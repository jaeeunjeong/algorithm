//https://www.acmicpc.net/problem/1744
import java.io.*;
import java.util.*;

/**
 * 1. 숫자들을 배열에 넣고 정렬해준다.
 * 절댓값이 가장 큰 값들 순서대로 곱해야 값이 커지기 때문
 * 2. idx를 따로 주어 완료된 부분은 더 연산하지 않도록 하였다.
 * 3. 두 값의 부호가 같은 경우에만 연산하도록 하였다.
 * 
 * 조건을 잘 세우는 것이 중요한 문제.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		Arrays.sort(arr);
		int idx = 0;
		for (idx = 0; idx < N - 1; idx += 2) {
			if (arr[idx] < 1 && arr[idx + 1] < 1)
				sum += arr[idx] * arr[idx + 1] - arr[idx] - arr[idx + 1];
			else
				break;
		}
		for (int i = N - 1; i > idx; i -= 2) {
			if (arr[i] > 1 && arr[i - 1] > 1)
				sum += arr[i] * arr[i - 1] - arr[i] - arr[i - 1];
			else
				break;
		}
		System.out.println(sum);
	}
}
