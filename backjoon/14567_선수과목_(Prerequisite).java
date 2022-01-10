//https://www.acmicpc.net/problem/14567 
import java.io.*;
import java.util.*;

/**
 * 트리 구조 만들어서 DFS 만들었다가 시간 초과(중복해서 파악하기 때문임.)
 * 위상 정렬로 풀이하였더니 통과함.
 * 
 * 트리 구조 관련 위상 정렬 DFS를 공부하기에 좋은 문제!
 */
public class Main {
	static List<Integer>[] list;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] degree = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			degree[B]++;
		}
		int[] subject = new int[N + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (degree[i] != 0)
				continue;
			queue.add(i);
			subject[i] = 1;
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				degree[next]--;
				if (degree[next] == 0) {
					queue.add(next);
					subject[next] = subject[cur] + 1;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(subject[i] + " ");
		}
	}

	public static void dfs(int cur, int step) {
		result = Math.max(step, result);
		for (int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i);
			dfs(next, step + 1);
		}
	}
}
