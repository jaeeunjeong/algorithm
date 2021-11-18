//https://www.acmicpc.net/problem/11497
import java.io.*;
import java.util.*;

/**
 * 정렬해서 한단계 걸러서 큰 값을 찾아주면 된다...
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int result = Integer.MIN_VALUE;
			Arrays.sort(arr);
			for (int i = 0; i < N - 2; i++) {
				result = Math.max(result, Math.abs(arr[i] - arr[i + 2]));
			}
			System.out.println(result);
		}
	}
}
