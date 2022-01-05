//https://www.acmicpc.net/problem/1405 
import java.io.*;
import java.util.*;

/**
 * 문제 이해가 상당히 어려웠는데 찾아보니 중복되지 않게 방문하는 경우를 의미하는 것이었다.
 * 
 * 일반적인 DFS문제로 확률을 구하라는 부분에 대해 좀 막막했는데,
 * 단순하게 방향이 바뀔때마다 바뀐 방향을 곱해주면 된다. 
 * 모든 경우를 다 탐색하면 결과에다가 더하는 것으로 풀이하면 된다.
 * 
 * 시작점이 (15,15)인데, 그 이유는 사방면으로 이동할 수 있기 때문에 가운데로 지정해준 것이다.
 * 
 * 이미 방문했다면 더 이상 방문하지 않도록 한다.
 * 
 */
public class Main {
	static int cnt;
	static double answer;
	static double[] percent;
	static boolean[][] marked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		marked = new boolean[30][30];
		percent = new double[4];
		
		for (int i = 0; i < 4; i++) {
			percent[i] = Integer.parseInt(st.nextToken()) * 0.01;

		}
		
		answer = 0;
		dfs(15, 15,0, 1.0);
		System.out.println(answer);
	}

	public static void dfs(int curR, int curC,int curCnt, double result) {
		if (cnt == curCnt) {
			answer += result;
			return;
		}
		
		marked[curR][curC] = true;
		
		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int d = 0; d < 4; d++) {
			int nextR = curR + dirs[d][0];
			int nextC = curC + dirs[d][1];

			if (marked[nextR][nextC])	continue;
			
			dfs(nextR, nextC, curCnt+1,result * percent[d]);
			marked[nextR][nextC] = false;
		}
	}
}
