//https://www.acmicpc.net/problem/2118
import java.io.*;
import java.util.*;

/**
 * 먼저 두 지점을 정한다.
 * 두 지점의 거리는 두 가지로 표현 될 수 있다.
 * 시계 방향/ 시계 반대 방향이라고 두 지점의 거리는 나뉠 수 있는데 둘 중 작은 값이 그 지점간의 거리가 된다.
 * 두 지점의 거리를 먼저 구하고 전체 거리에서 두 지점 사이의 거리 빼면 지점 사이의 거리 두 개를 구할 수 있다.
 * 이런 방식으로 두 지점간의 거리를 전부 탐색하여 작은 값 중 제일 큰 값을 구해주면 된다. 
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
			sum += cur;
		}

		int left = 0;
		int right = 0;

		int answer = 0;
		int cur = arr[left];
		while (left <= right && right < N) {
			int min = Math.min(cur, sum - cur);
			answer = Math.max(min, answer);

			if (cur == min) {
				right++;
				cur += arr[right];
			} else {
				cur -= arr[left];
				left++;
			}
		}
		System.out.println(answer);
	}
}
