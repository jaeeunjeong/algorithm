
//https://www.acmicpc.net/problem/14248 
import java.io.*;
import java.util.*;

/**
 * S2 bfs
 * bfs를 이용해서 방문가능한지 안한지 확인 한 후, 방문한 부분을 카운트한다.
 */
public class Main {
	static int n, answer;
	static boolean[] marked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		answer = 0;
		st = new StringTokenizer(br.readLine());
		int[] order = new int[n];
		for (int i = 0; i < n; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = Integer.parseInt(br.readLine());
		marked = new boolean[n];

		bfs(s - 1, order);
		for (boolean flag : marked)
			if (flag)
				answer++;
		
		System.out.println(answer);
	}

	public static void bfs(int cur, int[] order) {
		int[] dirs = { -1, 1 };
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(cur);
		marked[cur] = true;
		
		while (!queue.isEmpty()) {
			cur = queue.poll();
			int step = order[cur];
			for (int d : dirs) {
				int next = cur + step * d;
				if (next < 0 || next >= n)
					continue;
				marked[next] = true;
				queue.add(next);
			}
		}
	}
}
