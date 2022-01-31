//https://www.acmicpc.net/problem/11441
import java.io.*;
import java.util.*;
/*
 * 계속 누적해서 값을 구해두고 원하는 구간을 잘 정해서 값을 도출하면 된다.
*/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		A[0] = 0;
		for (int i = 1; i <= N; i++) {
			A[i] += Integer.parseInt(st.nextToken()) + A[i-1];
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken());
			int sum = A[j] - A[i];
			System.out.println(sum);
		}
	}
}
