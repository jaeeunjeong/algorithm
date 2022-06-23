
//https://www.acmicpc.net/problem/14921 
import java.io.*;
import java.util.*;

/**
 * 투 포인터 문제
 * 1. 정렬을 한다.
 * 2. 모든 값을 비교하는데 두 값의 합이 음수면 양수(0애 가까워지도록)가 되게끔 인덱스 값을 증가한다.(left++)
 * 	두 값의 합이 양수라면 음수(0에 가까워지도록)가 되도록 인덱스 값을 감소시킨다.
 * 3. 0에 가까운 값을 구한다.
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int left = 0;
		int right = n - 1;
		long answer = Integer.MAX_VALUE;
		while (left < right) {

			long mid = arr[left] + arr[right];
			long absAnswer = Math.abs(answer);
			if (Math.abs(mid) < absAnswer) {
				answer = mid;
			}
			if (mid < 0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(answer);
	}
}
