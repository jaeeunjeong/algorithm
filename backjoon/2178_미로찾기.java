//https://www.acmicpc.net/problem/2178
import java.io.*;
import java.util.*;

class Main {
	
	static int [][]arr;
	static boolean [][]visit;
	static int rows[] = {1, -1, 0, 0};
	static int cols[] = {0, 0, -1, 1};
	
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//가로
        int M = Integer.parseInt(st.nextToken());//세로

        arr = new int[N][M];
        visit = new boolean[N][M];
        
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String line = st.nextToken();
			for (int j = 0; j < M; j++) {
				int temp = line.charAt(j) -'0';
				
				arr[i][j] = temp;
			}
        }
        
        bfs(N, M);
        System.out.println(arr[N-1][M-1]);

    }

    public static void bfs(int N, int M) {
    	
    	Queue<Dot> queue = new LinkedList<Dot>();
    	queue.add(new Dot(0,0));
    	
    	visit[0][0] = true;
    	
    	while(!queue.isEmpty()) {
    		Dot dot = queue.poll();
    		
    		for (int i = 0; i < 4; i++) {
				
    			int tempR = dot.row + rows[i];
    			int tempC = dot.col + cols[i];
    			
    			if(tempR < 0 || tempC < 0 || tempR >= N || tempC >=M) continue;
    			
    			if(visit[tempR][tempC] || arr[tempR][tempC] == 0) continue;
    			
    			queue.add(new Dot(tempR, tempC));
    			visit[tempR][tempC] = true;
    			
    			//각 좌표를 지날 때 마다 몇 번 만에 그 길을 찾았는지 기록하는 배열이 필요.
    			arr[tempR][tempC] = arr[dot.row][dot.col]+1;
			}
    	}
    	
    }
    
}

class Dot{
	int row;
	int col;
	
	Dot(int  r, int c){
		this.row = r;
		this.col = c;
	}
}
