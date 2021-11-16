//https://www.acmicpc.net/problem/2230
import java.io.*;
import java.util.*;

/**
 * 투포인터!
 * 포인터를 두개를 잡고 원하는 차이가 나올때까지 전체를 탐색. 
 * 이분탐색과 투포인터의 차이를 분명하게 이해하지 못했는데,
 * 이 문제 풀이를 통해 이해된 것 같다.
 * 
 * 왼쪽 인덱스 값을 늘려주는 경우는 두 수의 인덱스 값이 같은 경우에만 늘려준다.
 * 그 외의 오른쪽 인덱스 값을 늘려주는 경우는 원하는 값이 안나와서 원하는 값을 찾기 위해 값을 키워주는 경우이다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long cur = Long.parseLong(st.nextToken());
			arr[i] = cur;
		}
		long answer = Integer.MAX_VALUE;
		Arrays.sort(arr);
		int left = 0;
		int right = 0;

		while (left <= right && right < N) {
			long start = arr[left];
			long end = arr[right];
			if (end - start >= M) {
				answer = Math.min(answer, end - start);
				if (left == right) {
					right++;
				}else left++;
			} else {
				right++;
			}
		}
		System.out.println(answer);
	}
}
