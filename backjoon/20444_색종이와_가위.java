//https://www.acmicpc.net/problem/20444
import java.io.*;
import java.util.*;

/**
 * 수학이 섞인 문제라 풀이 과정만 찾아보고 풀이
 * 공식만 전개할 수 있다면 이분탐색으로 풀수 있다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		long left = 0;
		long right = (N / 2) + 1;
		boolean flag = false;
		while (left <= right) {
			long mid = (left + right) / 2;
			long result = (mid + 1) * (N - mid + 1);
			if (result == M) {
				flag = true;
				break;
			} else if (result > M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		String answer = "NO";
		if (flag)
			answer = "YES";
		System.out.println(answer);

	}
}
