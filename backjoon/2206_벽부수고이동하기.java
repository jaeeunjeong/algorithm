//https://www.acmicpc.net/problem/2206
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, answer;
//	static boolean[][] visit;
	static int[][] map,visit;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	map = new int[N][M];
    	visit = new int[N][M];
    	
    	//init.
    	for (int i = 0; i < N; i++) {
    		String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				int target = temp.charAt(j) - '0';
				map[i][j] = target;
				visit[i][j] = Integer.MAX_VALUE;//무한대로 초기화. 이유는? -> 구해야하는 값이 최솟값이기에.
			}
		}
    	
    	answer = 0;//값이 안 될 값이면 됨.
    	bfs(0,0); //시작점 지정.
    	if(answer == 0) answer = -1;
    	System.out.println(answer);
    	
    }

	public static void bfs(int row, int col) {
		Queue<Dot> queue = new LinkedList<Dot>();
		queue.add(new Dot(row, col, 1, 0));
		visit[row][col] = 0;//처음 공사 횟수.
		
		while(!queue.isEmpty()) {
			Dot d = queue.poll();
			
			//도착 지점을 만나면 종료
			if(d.row == N-1 && d.col == M-1) {
				//최종 리턴 값은 최단 거리.
				answer = d.dis;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextR = d.row + dr[i];
				int nextC = d.col + dc[i];
				
				if(nextR < 0 || nextC < 0 || nextR >=N || nextC >=M) continue;
				
				if(visit[nextR][nextC] <=d.times) continue;
				
				if(map[nextR][nextC] == 0 ) {//벽이 아닌 경우
					visit[nextR][nextC] = d.times;
					queue.add(new Dot(nextR, nextC, d.dis+1, d.times));
				}else {
					if(d.times == 0) {//벽인 경우 만약 부셔진다면 어떻게 될지 가정하고 값 추가.
						visit[nextR][nextC] = d.times +1;
						queue.add(new Dot(nextR, nextC, d.dis+1, d.times+1));
					}
				}
			}
		}
		
	}
}
class Dot{
	int row;
	int col;
	int dis; // 이동 거리
	int times; // 공사 횟수
	
	Dot(int r, int c, int d, int t){
		row = r;
		col = c;
		dis = d;
		times = t;
	}
}
