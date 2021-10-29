//https://www.acmicpc.net/problem/9095
import java.io.*;
import java.util.*;

/**
 * 1,2,3 으로 모든 값들이 계산된다는 점을 이용하여 원하는 값들의 -1, -2, -3 한 값으로 부터 합을 누적하여 풀이
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		while (t-- > 0) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N+3];
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			int curNumber = 3;
			while (curNumber++ < N) {
				arr[curNumber] = arr[curNumber - 1];
				arr[curNumber] += arr[curNumber - 2];
				arr[curNumber] += arr[curNumber - 3];
			}
			System.out.println(arr[N]);
		}
	}
}
