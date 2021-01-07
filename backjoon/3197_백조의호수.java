//https://www.acmicpc.net/problem/3197
import java.io.*;
import java.util.*;

class Main {

	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R =  Integer.parseInt(st.nextToken());
		C =  Integer.parseInt(st.nextToken());

		
		map = new char[R][C];
				
		Dot[] swans = new Dot[2];
		int s = 0;
		Queue<Dot> queue = new LinkedList<Dot>();
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = line.charAt(j);
				
				if(c == 'L') {
					//백조 두마리르 만나게 하자~
					swans[s++] = new Dot(i, j);
					c = '.';
				}else if(c == '.') queue.add(new Dot(i, j));
				map[i][j] = c;
			}
		}
		int cnt = 0;
		//Queue<Dot> queue = searchWater();
		while(!meetSwans(swans)) {
			queue = meltIce(queue);
			cnt++;
		}
		
		System.out.println(cnt);
	}
	//수정 1. 1회로 끝나버려서 생각해보니 물에 근접한 것을 알아야했음. -> 시간초과
	
	public static Queue<Dot> searchWater(){
		Queue<Dot> queue = new LinkedList<Dot>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '.') queue.add(new Dot(i, j));
			}
		}
		return queue;
	}
	
	//수정 2. 시간 초과 나와서 완전 탐색을 다 하는 것이 아니라, 불이 된 빙판만 Queue에 넣어서 리턴해 주고 리턴 값을 바탕으로 물로 만들기로 함 -> 또 시간 초과
	public static Queue<Dot> meltIce(Queue<Dot> queue) {
		visit = new boolean[R][C];
		queue.add(new Dot(0,0));
		Queue<Dot> tommorowQueue = new LinkedList<Dot>();
		while(!queue.isEmpty()) {
			
			Dot d = queue.poll();
			visit[d.row][d.col] = true;
			
			for (int i = 0; i < 4; i++) {
				int nextX = d.row + dir[i][0];
				int nextY = d.col + dir[i][1];
				
				if(nextX <0 || nextY < 0 || nextX >=R || nextY >=C) continue;
				//방문하지 않고 물인 경우 제외
				if(visit[nextX][nextY]|| map[nextX][nextY] == '.') continue;
				
				visit[nextX][nextY] = true;
				map[nextX][nextY] = '.';
				tommorowQueue.add(new Dot(nextX, nextY));
			}
			
		}
		
		return tommorowQueue;
	}
	
	//굳이 둘이 같이 이동하지 않아됨! 만나기만 하면 되는 것.
	public static boolean meetSwans(Dot[] swans) {
		Queue<Dot> queue = new LinkedList<Dot>();
		visit = new boolean[R][C];
		queue.add(new Dot(swans[0].row, swans[0].col));

		while(!queue.isEmpty()) {
			
			Dot swan = queue.poll();
			visit[swan.row][swan.col] = true;
			if(swan.row == swans[1].row && swan.col == swans[1].col) {
				
				return true;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = swan.row + dir[i][0];
				int nextY = swan.col + dir[i][1];
				
				if(nextX <0 || nextY < 0 || nextX >=R || nextY >=C) continue;
				//방문했고 빙판이면 다시 못 감.
				if(visit[nextX][nextY] || map[nextX][nextY] == 'X') {
					continue;
				}
				
				visit[nextX][nextY] = true;
				queue.add(new Dot(nextX, nextY));
			}
			
		}
		
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
