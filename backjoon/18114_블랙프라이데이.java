//https://www.acmicpc.net/problem/18114
import java.io.*;
import java.util.*;

/**
 * 이분탐색이라는데 그냥 구현으로도 충분히 풀린다.
 * 물건 두개를 구하고, 두 물건의 차이만큼이 판매하는 물건에 있으면 true를 리턴해준다. 
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		boolean[] marked = new boolean[100000001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
			marked[cur] = true;
		}
		boolean answer = marked[C];
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				int sum = arr[i] + arr[j];
				int diff = C - sum;
				if(sum == C || (diff > 0 && diff != arr[i] && diff != arr[j] && marked[diff])) {
					answer = true;
					break;
				}
			}
			if(answer) break;
		}
		if(answer) System.out.println(1);
		else System.out.println(0);
	}
}
