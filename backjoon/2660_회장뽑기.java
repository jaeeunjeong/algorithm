//https://www.acmicpc.net/problem/2660 
import java.io.*;
import java.util.*;

/**
 * bfs로 풀어봤는데... 좀 이상하고 값도 작아서 이중 for문 으로 플로이드-와샬로 풀었다.
 */
class Main {
	static List<Integer>[] map;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new List[N + 1];

		for (int i = 1; i <= N; i++)
			map[i] = new ArrayList<>();
		int[][] distance = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				distance[i][j] = 100;
				if (i == j)
					distance[i][j] = 0;
			}
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1)
				break;

			map[a].add(b);
			map[b].add(a);
			distance[a][b] = distance[b][a] = 1;
		}

		for (int t = 1; t <= N; t++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					distance[s][e] = Math.min(distance[s][e], distance[s][t] + distance[t][e]);
				}
			}
		}

		int answer = Integer.MAX_VALUE;
		int[] result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j <= N; j++) {
				if (distance[i][j] < 100)
					max = Math.max(distance[i][j], max);
			}
			result[i] = max;
			answer = Math.min(max, answer);
		}

		List<Integer> candidate = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (result[i] == answer)
				candidate.add(i);
		}

		System.out.println(answer + " " + candidate.size());
		for (int candi : candidate)
			System.out.print(candi + " ");
	}
}
