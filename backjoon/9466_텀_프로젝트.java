//https://www.acmicpc.net/problem/9466 
import java.io.*;
import java.util.*;

/**
 * DFS를 이용해서 사이클인지 아닌지 확인하는게 포인트!
 * boolean타입 배열을 2개 줘서 해결해도 시간초과가 났는데 적절하게 쓰는게 중요한... 문제ㅠㅠ
 * 나의 경우 방문체크 배열을 계속해서 초기화하고 적절하게 사용하지 못해 시간초과가 나서 
 * 통과한 것을 참고하였다.
 */
public class Main {
	static int[] arr;
	static boolean[] visit, marked;
	static boolean result;
static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr = new int[n + 1];
			answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i] = temp;
			}
			marked = new boolean[n + 1];
			visit = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				dfs(i);
			}
			System.out.println(n - answer);
		}
	}

	private static void dfs(int cur) {
		if(visit[cur]) return;
		visit[cur] = true;
		int next = arr[cur];
		if(!visit[next]) {
			dfs(next);
		}
		else {
			if(!marked[next]) {
				answer++;
				for(int i = next; i != cur; i = arr[i]) {
					answer++;
				}
			}
		}
		marked[cur] = true;
	}
}
