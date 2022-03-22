//https://programmers.co.kr/learn/courses/30/lessons/86971
import java.util.*;
/**
 * DFS! 트리문제 같지만 트리는 아니고 그냥 완전 탐색문제이다.
 * 
 * 간선간의 연결을 해주고, 연결을 끊어가며 제일 차이가 작은 값을 확인해줘야한다.
 * leaf노드까지 확인해야해서 dfs로 확인해야한다.
 * 
 * 탐색지점은 두 경로가 겹치는, 공통 노드가 없을 거라서 방문처리를 기준으로 다 돌려도 되고,
 * 끊어진 지점을 기준으로 확인해도 된다. 트리는 어디든지 루트라는 성질을 이용.
 * 방문 처리를 잘 해줘서 실수를 방지하자.
 */
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
