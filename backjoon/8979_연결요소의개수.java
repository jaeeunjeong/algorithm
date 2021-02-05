//https://www.acmicpc.net/problem/11724

import java.io.*;
import java.util.*;

class Main {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		 map = new int[N+1][N+1];
		 visit = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = 1;
			map[col][row] = 1;		
		}
		int cnt = 0;
		
		for (int j = 1; j <= N; j++) {
			boolean flag = true;
			for (int i = 1; i <= N; i++) {
				if(map[j][i] == 1 && !visit[j][i]) {
					flag = false;
					cnt++;
					bfs(j,i);
				}
				if(visit[j][i]) flag = false;
			}
			//아예 방문을 안 했다면 ++
			if(flag) cnt++;
		}
		System.out.println(cnt);
	}
	

	public static void bfs(int row, int col) {

		Queue<Dot> queue = new LinkedList<Dot>();
		queue.add(new Dot(row, col));
		visit[row][col] = true;
		visit[col][row] = true;
		while(!queue.isEmpty()) {
			Dot d = queue.poll();
			for (int i = d.row; i <=N; i++) {
				if(map[d.col][i] == 1 && !visit[d.col][i]) {
					visit[d.col][i] = true;
					visit[i][d.col] = true;
					queue.add(new Dot(d.col, i));
				}
			}
			for (int i = d.col; i <=N; i++) {
				if(map[d.row][i] == 1 && !visit[d.row][i]) {
					visit[d.row][i] = true;
					visit[i][d.row] = true;
					queue.add(new Dot(d.row, i));
				}
			}
		}
	}
}
class Dot{
	int row;
	int col;
	Dot(int r, int c){
		this.row = r;
		this.col = c;
	}
}
//https://www.acmicpc.net/source/26060330 : 위상 정렬 풀이 방식 대로 풀이! -> 익숙해질 것.
//https://www.acmicpc.net/source/26031489 : 나는 visit을 2차원으로 했는데 1차원도 충분-> 방향이 없기 때문
