//https://www.acmicpc.net/problem/5014
import java.io.*;
import java.util.*;

public class Main {
	
	static int F, S, G, U, D;
	//static int[][] map;
//	static int max = 1000001;
	static int max;
	static int[] visit;// = new int[max];
	//static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	static int[] elevator;
	
	public static void main(String[] args) throws IOException {
	    //문제에서 최단 경로를 요구하기 떄문에 BFS
	   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); //전체 층
		S = Integer.parseInt(st.nextToken()); //현재
		G = Integer.parseInt(st.nextToken()); //목적
		U = Integer.parseInt(st.nextToken()); //UP
		D = Integer.parseInt(st.nextToken()); //DOWN
		
		max = F+1;
		visit = new int[max];
		
		if(S == G) { // 예외 처리 1.
			System.out.println(0);
		}else {
			bfs();
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// 현재 층을 입력하고 방문을 표시.
		queue.add(S);
		visit[S] = 1;
		
		while(!queue.isEmpty()) {
			int state = queue.poll();
		
			elevator = new int[]{state + U, state -D};
			
			//int upFloor = state + U;
			//int downFloor = state -D;
			//int floor = Math.abs(G-upFloor) > Math.abs(G-downFloor) ? downFloor:upFloor;

			for (int i = 0; i < elevator.length; i++) {
				int floor = elevator[i];
				if(floor == G) {
					System.out.println(visit[state]);
					return;
				}
				//배열의 범위 조심하기 -> runtime Error!
				if(floor >0 && floor <max && visit[floor] == 0) {
					queue.add(floor);
					visit[floor] = visit[state]+1;
				}
			}
		}
		System.out.println("use the stairs");
	}
}
