//https://www.acmicpc.net/problem/10815
import java.io.*;
import java.util.*;

/**
 * 이분탐색문제인데 set을 이용해서 풀이
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			set.add(temp);
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (set.contains(temp))
				sb.append("1 ");
			else
				sb.append("0 ");
		}

		System.out.println(sb.toString());
	}
}
