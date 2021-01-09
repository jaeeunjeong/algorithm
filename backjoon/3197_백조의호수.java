//https://www.acmicpc.net/problem/3197
import java.io.*;
import java.util.*;

class Main {

	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	static Queue<Dot> nextSwan = new LinkedList<Dot>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R =  Integer.parseInt(st.nextToken());
		C =  Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		Dot swan;
		Queue<Dot> lakeQueue = new LinkedList<Dot>();
		Queue<Dot> swanQueue = new LinkedList<Dot>();

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = line.charAt(j);
				if(c == 'L') {
					swan = new Dot(i, j);
					lakeQueue.add(swan);
					swanQueue.add(swan);
				}else if(c == '.') lakeQueue.add(new Dot(i, j));
				map[i][j] = c;
			}
		}
		swanQueue.poll();
		int day = 0;
		swan = swanQueue.peek();
		visit[swan.row][swan.col] = true;
		nextSwan = swanQueue;
		while(!meetSwans(nextSwan)) {
			lakeQueue = meltIce(lakeQueue);
			day++;
		}
		
		System.out.println(day);

	}
	
	
	public static Queue<Dot> meltIce(Queue<Dot> queue) {
		Queue<Dot> tommorowIce = new LinkedList<Dot>();
		while(!queue.isEmpty()) {

			Dot d = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = d.row + dir[i][0];
				int nextY = d.col + dir[i][1];
				
				if(nextX <0 || nextY <0 || nextX >=R || nextY>=C) continue;
				
				//내일 녹을 아이들만 넣어주기. 선택과 집중...?
				if(map[nextX][nextY] == 'X') {
					tommorowIce.add(new Dot(nextX, nextY));
					map[nextX][nextY] = '.';
				}
				
			}
		}
		return tommorowIce;
	}
	
	public static boolean meetSwans(Queue<Dot> swanQueue) {
		Queue<Dot> swanTemp = new LinkedList<Dot>();
			while(!swanQueue.isEmpty()) {
				Dot swan = swanQueue.poll();
				
				for (int i = 0; i < 4; i++) {
					int nextX = swan.row + dir[i][0];
					int nextY = swan.col + dir[i][1];
					
					if(nextX <0 || nextY < 0 || nextX >= R || nextY >=C) continue;
					if(visit[nextX][nextY]) continue;
					
					if(map[nextX][nextY] == '.') swanQueue.add(new Dot(nextX, nextY));
					else if(map[nextX][nextY] == 'X') swanTemp.add(new Dot(nextX, nextY));
					else if(map[nextX][nextY] == 'L') return true;
					
					visit[nextX][nextY] = true;
				}
			}

			nextSwan = swanTemp;
			return false;
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
