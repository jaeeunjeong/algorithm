//https://www.acmicpc.net/problem/11967
import java.io.*;
import java.util.*;

class Main {

	static int N, light;
	static ArrayList<Dot> room[][];
	static boolean[][] visit, turnOn, move;
	static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1][N+1];
		turnOn = new boolean[N+1][N+1];
		move = new boolean[N+1][N+1];

		room = new ArrayList[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				room[i][j] = new ArrayList<Dot>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			room[x][y].add(new Dot(a, b));
			
		}

		bfs();

		System.out.println(light);

	}
	
	public static void bfs() {
		Queue<Dot> queue = new LinkedList<Dot>();
		queue.add(new Dot(1, 1));
		turnOn[1][1] = true;
		visit[1][1] = true;
		light = 1;
		
		while(!queue.isEmpty()) {
			
			Dot dot = queue.poll();
			
			//일단 스위치 켜기
			for (int j = 0; j < room[dot.row][dot.col].size(); j++) {
				Dot temp = room[dot.row][dot.col].get(j);
				if(turnOn[temp.row][temp.col]) continue;

				turnOn[temp.row][temp.col] = true;//불이 켜짐.
				light++;
			}

			//켜진 방 돌아다니기.
			for (int i = 0; i < dir.length; i++) {
				int nextR = dot.row + dir[i][0];
				int nextC = dot.col + dir[i][1];
				
				if(nextR < 0 || nextC < 0 || nextR >N || nextC >N) continue;
				
				move[nextR][nextC] = true;//움직 일 수 있다.
			}

			//모든 방을 다시 탐색한다..
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(turnOn[i][j] && move[i][j] && !visit[i][j]) {
						visit[i][j] = true;
						queue.add(new Dot(i, j));
					}
				}
			}
		}
	}
	
}

class Dot{
	int row;
	int col;
	Dot(int r, int c){
		row = r;
		col = c;
	}
}
