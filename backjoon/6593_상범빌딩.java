//https://www.acmicpc.net/problem/6593
import java.io.*;
import java.util.*;

public class Main {
	
	static int L, R, C;
	static int[][][] map;
	static int[][][] visit;
	static int[][] dir = {{-1, 0, 0},{1, 0, 0},{0, -1, 0},{0, 1, 0}, {0,0,1}, {0,0,-1}};
	static Queue<Dot> queue;
	
	public static void main(String[] args) throws IOException {
	    //문제에서 최단 경로를 요구하기 떄문에 BFS
	   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken()); //상범 빌딩의 층수
			R = Integer.parseInt(st.nextToken()); //한층의 행
			C = Integer.parseInt(st.nextToken()); //한층의 열
			
			if( L == 0 && R == 0 && C == 0) break;
			
			map = new int[L][R][C];
			visit = new int[L][R][C];

			queue = new LinkedList<Dot>();
			
			for (int i = 0; i < L; i++) {
				for (int j = 0; j <R; j++) {
					String line = br.readLine();
					for (int k = 0; k < C; k++) {
						char c = line.charAt(k);
						
						if(c ==  'S') {
							//queue에 넣기
							c = '.';
							queue.add(new Dot(i, j, k));
							visit[i][j][k] = 1;
						}
						
						map[i][j][k] = c;
					}
				}
				br.readLine();
			}
			bfs();
		}
	}
	
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			for (int i = 0; i < dir.length; i++) {
				int nextX = dot.x + dir[i][0];
				int nextY = dot.y + dir[i][1];
				int nextZ = dot.z + dir[i][2];
				
				if(nextX < 0 || nextY < 0 || nextZ < 0 | nextX >=L || nextY>=R || nextZ >=C) continue;
				
				if(visit[nextX][nextY][nextZ] >0 || map[nextX][nextY][nextZ] == '#') continue;
				
				if(map[nextX][nextY][nextZ] == 'E') {
					int time = visit[dot.x][dot.y][dot.z];
					System.out.print("Escaped in "+time+" minute(s).\n");
					return;
				}
				visit[nextX][nextY][nextZ] = visit[dot.x][dot.y][dot.z]+1;
				queue.add(new Dot(nextX, nextY, nextZ));
			}
		}
		
		System.out.println("Trapped!");//꼭 이 위치!!! 다른 위치에 출력하면 안됨 ㅠㅠ
	}
}

class Dot{
	int x;
	int y;
	int z;
	
	Dot(int x, int y,  int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
