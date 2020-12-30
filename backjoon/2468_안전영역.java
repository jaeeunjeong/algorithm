//https://www.acmicpc.net/problem/2468
import java.io.*;
import java.util.*;

public class Main {
	
	static int N,  answer;
	static boolean[][] visit;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	map = new int[N][N];
    	answer =0;
    	
    	//init.
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int target = Integer.parseInt(st.nextToken());
				map[i][j] = target;
				max = Math.max(max, target);
				min = Math.min(min, target);
			}
		}
    	
    	//물에 안 잠기는 지점이 상하좌우 인접해 있으면 안전 지역.
    	//모든 경우의 수를 확인하여 구역이 최대인 곳의 갯수 파악.
    	//hight를 출력하면 최다 구간일 때의 높이를 알 수 있다.
    	for (int hight = 1; hight < max; hight++) {
    		int cnt = 0;
    		visit = new boolean[N][N];
			
	    	for (int i = 0; i < N; i++) {
	    		for (int j = 0; j < N; j++) {
	    			if(map[i][j] > hight && !visit[i][j]) {
	    				cnt++;
	    				bfs(i, j, hight);
	    			}
	    		}
	    	}
	    	answer = Math.max(answer, cnt);
    	}
    	System.out.println(answer);
    }
	public static void bfs(int row, int col, int hight) {
		Queue<Dot> queue = new LinkedList<Dot>();
		queue.add(new Dot(row, col));
		visit[row][col] = true; //메모리 문제 떄문에 꼭 먼저해줘야함.
		
		while(!queue.isEmpty()) {
			Dot d =  queue.poll();
			for (int i = 0; i < dc.length; i++) {
				int nextR = d.row +dr[i];
				int nextC = d.col +dc[i];

				//예외처리
				if(nextR< 0 || nextC<0 || nextR >=N || nextC >=N)	continue;
				if(visit[nextR][nextC] || map[nextR][nextC] <= hight) continue;
				
				queue.add(new Dot(nextR, nextC));
				visit[nextR][nextC] = true;
				
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
