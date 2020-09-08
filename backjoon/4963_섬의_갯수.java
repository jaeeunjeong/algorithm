//https://www.acmicpc.net/problem/4963
package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
    public static int ROW, COL;
    
    public static int[][] map;
    public static boolean[][] visited;
    
    public static int []dx = {-1,0,1,-1,1,-1,0,1};//시계방향
    public static int []dy = {-1,-1,-1,0,0,1,1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int answer =0;
        while(true) {
            st = new StringTokenizer(br.readLine());
            
            COL = Integer.parseInt(st.nextToken());
            ROW = Integer.parseInt(st.nextToken());
            
            if(ROW == 0 && COL == 0) {
            	break;
            }
            map = new int[ROW][COL];
            visited = new boolean[ROW][COL];
            // 좌표 입력받기
            for(int i=0; i < ROW; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j < COL; j++) {
                	map[i][j] = Integer.parseInt(st.nextToken());
                	visited[i][j] = false;
                }
            }
            
            int cnt = 0;
            for(int i=0; i < ROW; i++) {
            	for(int j=0; j < COL; j++) {
            		if(map[i][j] ==1 &&visited[i][j] == false) {
            			bfs(i,j);
            			//dfs(i,j);
            			cnt++;
            		}
            	}
            }
            System.out.println(cnt);

        }
    }

    public static void bfs(int x,int y) {
    	Queue<Dot> queue = new LinkedList<Dot>();
    	visited[x][y] = true;
    	queue.add(new Dot(x, y));
    	while (!queue.isEmpty()) {
    		Dot d = queue.poll();
    		for (int i = 0; i < 8; i++) {
    			int nextX = d.x+dx[i];
    			int nextY = d.y+dy[i];
    		
    		if(nextX<0 || nextY<0 || nextX >=ROW || nextY>= COL) continue;
    		if(map[nextX][nextY] == 0 || visited[nextX][nextY] ==true) continue;
    		
        //Queue
    		queue.add(new Dot(nextX,nextY));
    		visited[nextX][nextY] = true;
    		
    		}
    		
		}
    }
    public static void dfs(int x,int y) {
    	visited[x][y] = true;
    	
    	for (int i = 0; i < 8; i++) {
    		int nextX = x+dx[i];
    		int nextY = y+dy[i];
    			
    			if(nextX<0 || nextY<0 || nextX >=ROW || nextY>= COL) continue;
    			if(map[nextX][nextY] == 0 || visited[nextX][nextY] ==true) continue;
    			//recursion
    			dfs(nextX,nextY);
    		}
    		
    }
    
}
class Dot {
	int x;
	int y;
	
	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
