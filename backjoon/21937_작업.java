//https://www.acmicpc.net/problem/21937 
import java.io.*;
import java.util.*;
import java.util.LinkedList;

/**
 * dfs를 이용해서 풀이.
 * 중간에 메모리 초과가 떴는데 인접행렬 말고 인접 리스트를 이용해서 풀이하였더니 통과!
 * 방문한 부분에 대해 분기처리를 해줘서 간 곳에 또 가지 않도록 한다.
 * 그 방법에는 boolean 타입의 배열 또는 set을 이용해서 풀이하면된다. 
 */
public class Main {
	static List<Integer>[] list;
	static boolean[] marked;
	static int N, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		cnt = 0;
		marked = new boolean[N];
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[B].add(A);
		}
		int cur = Integer.parseInt(br.readLine());
		dfs(cur);
		System.out.println(cnt);
	}

	public static void dfs(int n) {
		for(int cur : list[n]) {
			if (!marked[cur]) {
				dfs(cur);
				marked[cur] = true;
				cnt++;
			}
		}
	}
}
