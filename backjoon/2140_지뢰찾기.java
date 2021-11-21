
//https://www.acmicpc.net/problem/2140
import java.io.*;
import java.util.*;

/**
 * 폭탄이 있을 법한 자리를 탐색한다. 
 * 8방향을 확인해서 폭탄이 들어갈 수 없다면, 그 곳은 리턴처리. 
 * 리턴처리가 안 되었다면 폭탄이 들어갈 수 있는 경우이기에 answer를 증가시켜준다. 
 * 이후 처리를 위해 폭탄이 들어갈 수 있다면 주변 예상 지뢰수(map의 항목들의 수)를 감소시켜준다.
 **/
class Main {
	static char[][] map;
	static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				int cur = map[i][j] - '0';
				if (cur == 0)
					continue;
				
				bomb(i, j);
			}
		}
		System.out.println(answer);
	}

	public static void bomb(int row, int col) {
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
		
		for (int i = 0; i < 8; i++) {
			int nextR = row + dirs[i][0];
			int nextC = col + dirs[i][1];

			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
				continue;
			
			if (map[nextR][nextC] == '0')
				return;
		}
		
		answer++;
		
		for (int i = 0; i < 8; i++) {
			int nextR = row + dirs[i][0];
			int nextC = col + dirs[i][1];

			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
				continue;
			
			if (map[nextR][nextC] >= '0' && map[nextR][nextC] <= '9')
				map[nextR][nextC]--;
		}
	}
}
