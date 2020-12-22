//https://www.acmicpc.net/problem/7576
import java.io.*;
import java.util.*;

class Main {
	
	static int [][]arr;
	static boolean [][]visit;
	static int rows[] = {1, -1, 0, 0};
	static int cols[] = {0, 0, -1, 1};
	static int max,N,M,tomato;
	
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];
        max = Integer.MIN_VALUE;
        
        tomato = N*M; //익혀야 할 토마토의 수를 세는 변수.
        
        //초기화 과정.
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
          for (int j = 0; j < M; j++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i][j] = temp; 
            if(temp == -1 || temp == 1) {//익힐 필요가 없는 토마토는 제거함.
              tomato--;
            }	
          }
       }
        
        int answer = 0;
        if(tomato==0) {//할 것이 없는 경우.
        	answer = 0;
        }else {
        	Queue<Dot> queue = new LinkedList<Dot>();
	        for (int i = 0; i < N; i++) {
	        	for (int j = 0; j < M; j++) {
	        		if(arr[i][j] == 1 && !visit[i][j]) {
	        		    queue.add(new Dot(i,j));
	        		}
	        	}
	        }
	        
	        bfs(queue);

	        if(tomato>0) { //tomato가 남아있는 경우.
	        	answer = -1;
	        }else {
	        	answer = max-1;
	        }
	        
        }
        System.out.println(answer);
    }

    public static void bfs(Queue<Dot> queue) {
    	while(!queue.isEmpty()) {

    		Dot dot = queue.poll();
    		for (int i = 0; i < 4; i++) {
    			int tempR = dot.row + rows[i];
    			int tempC = dot.col + cols[i];
    			
    			if(tempR < 0 || tempC < 0 || tempR >= N || tempC >= M) continue;
    			
    			if(visit[tempR][tempC] || arr[tempR][tempC] == -1|| arr[tempR][tempC] ==1) continue;
    			
    			visit[tempR][tempC] = true;
    			queue.add(new Dot(tempR, tempC));
    			arr[tempR][tempC] = arr[dot.row][dot.col]+1;
    			max = Math.max(arr[tempR][tempC] , max);
    			tomato--;
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
