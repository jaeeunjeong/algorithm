//https://programmers.co.kr/learn/courses/30/lessons/86971
import java.util.*;

class Solution {
	static boolean[][] map;
	static boolean[] marked;
	static ArrayList<Integer> distance;

	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		map = new boolean[n + 1][n + 1];
		marked = new boolean[n + 1];
		
		for (int i = 0; i < wires.length; i++) {
			int row = wires[i][0];
			int col = wires[i][1];
			map[row][col] = true;
			map[col][row] = true;
		}
		
		for (int i = 0; i < wires.length; i++) {
			int row = wires[i][0];
			int col = wires[i][1];
			map[row][col] = false;
			map[col][row] = false;

			marked = new boolean[n + 1];
			distance = new ArrayList<>();
			for (int j = 1; j <= n; j++) {
				if (marked[j]) continue;
				marked[j] = true;
				distance.add(dfs(n, j));
			}
			answer = Math.min(Math.abs(distance.get(0) - distance.get(1)), answer);

			map[row][col] = true;
			map[col][row] = true;
		}
		return answer;
	}

	public static int dfs(int n, int cur) {
		int cnt = 1;
		for (int i = 1; i <= n; i++) {
			if (!map[cur][i] || marked[i])	continue;
			marked[i] = true;
			cnt += dfs(n, i);
		}
		return cnt;
	}
}
