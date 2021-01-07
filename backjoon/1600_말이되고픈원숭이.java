//https://www.acmicpc.net/problem/1600
import java.io.*;
import java.util.*;

class Main {

	static int W,H,K;
	static int[][] map;
	static boolean[][][] visit;
	static int[][] dirMonkey = {{0,1}, {0, -1}, {1,0},{-1,0}};
	static int[][] dirHorse= {{-2,-1},{-1,-2},{1,-2},{2, -1},{-2, 1},{-1,2},{1,2},{2,1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W =  Integer.parseInt(st.nextToken());
		H =  Integer.parseInt(st.nextToken());

		map = new int[H][W];
		//Point2. 3차원인 이유는? 점프 횟수 다 쓰고 도착해야하기 때문에 꼭 최단 거리가 아닐 수도 있다. 중요중요!!!!
		visit = new boolean[K+1][H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
    
	}
	
	public static void bfs() {
		Queue<Position> queue = new LinkedList<Position>();
		queue.add(new Position(0, 0, 0, 0));
		
		while(!queue.isEmpty()) {
			Position position = queue.poll();
			
			if(position.row == H-1 && position.col == W-1) {
				System.out.println(position.monkey);
				return;
			}
			
			//원숭이
			for (int i = 0; i < 4; i++) {
				int nextX = position.row + dirMonkey[i][0];
				int nextY = position.col + dirMonkey[i][1];
				
				if(nextX< 0 || nextY < 0 || nextX >=H || nextY>=W) continue;
				
				if(visit[position.horse][nextX][nextY] || map[nextX][nextY] ==1) continue;
				
				visit[position.horse][nextX][nextY] = true;
				queue.add(new Position(nextX, nextY, position.monkey+1, position.horse));
			}
			
			//말 Point1. for문을 돌리되 배열/구조체로 구별!
			if(K >position.horse) {
				for (int i = 0; i < 8; i++) {
					int nextX = position.row +dirHorse[i][0];
					int nextY = position.col + dirHorse[i][1];
					
					if(nextX< 0 || nextY < 0 || nextX >=H || nextY>=W) continue;
					//Point 2.
					if(visit[position.horse+1][nextX][nextY] || map[nextX][nextY] == 1) continue;
					
					visit[position.horse+1][nextX][nextY] = true;
					queue.add(new Position(nextX, nextY, position.monkey+1, position.horse+1));
				}
			}
		}
		
		System.out.println(-1);
	}
	
}

class Position{
	int row;
	int col;
	int monkey;
	int horse;
	public Position(int r, int c, int monkey, int horse) {
		row = r;
		col = c;
		this.monkey = monkey;
		this.horse = horse;
	}
}
