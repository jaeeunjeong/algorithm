
//https://www.acmicpc.net/problem/18222 
import java.io.*;
import java.util.*;

/**
 * 문자열이 대칭이고, 2의 n승으로 늘어나는 점을 고려하여,
 * 대칭되는 지점을 찾아서 리턴해준다.
 */
public class Main {
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		Long N = Long.parseLong(st.nextToken());
		arr = new long[64];
		arr[0] = 1;
		for (int i = 1; i < 64; i++) {
			arr[i] = arr[i - 1] * 2;
		}
		System.out.println(dfs(N));
	}

	public static long dfs(long N) {
		if (N == 1)
			return 0;

		long temp = 0;
		for (int i = 0; i < 64; i++) {
			if (N > arr[i]) {
				temp = arr[i];
			} else {
				break;
			}
		}
		return 1 - dfs(N - temp);
	}
}
