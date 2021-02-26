//https://www.acmicpc.net/problem/2636
package com.example.demo;
import java.io.*;
import java.util.*;

class Main {
	
	static int[][] map;//, visit ;
	static int[][] dist;//, visit ;
	static int[] time;//, visit ;
	static boolean[][] visit;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
	static int N, M, cnt,cheese;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		cheese = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) cheese++; // 반복문을 끝까지 돌리기 위한 flag 용도.
			}
		}
		int times = 0;
		int last = 0;
		while(cheese >0) {
			// 바로 직전을 카운트 하기위해 기록용. 
			//bfs를 돌기전에 기록하면 이전 것을 알 수 있다. 
			//bfs를 돌고나면 새로운 값으로 변경 됨.
			last = cheese;
			bfs();
			times++;
		}
		System.out.println(times);
		System.out.println(last);
	}
	/*
 * 1. 0 주변 만 녹을 수 있음 -> 0을 찾아서 queue에 넣는다.
 * 2. 1을 만나면 1은 녹아서 0으로 바꾸자.
 * 3. bfs로 해도 된다
 */
	public static void bfs() {
		Queue<Dot> queue = new LinkedList<Dot>();
		queue.add(new Dot(0,0));
		visit = new boolean[N][M];
		
		while(!queue.isEmpty()) {
			Dot d = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextR = d.row + dir[i][0];
				int nextC = d.col + dir[i][1];
				
				if(nextR<0 || nextC < 0 || nextR >= N || nextC >=M) continue;
				if(visit[nextR][nextC]) continue;

				visit[nextR][nextC] = true;
				//내가 생각하기 어려워했던 부분. 1은 불가능 하고 0만 탐색 가능하니까 0을 탐색하고, 1을 0으로 바꿔준다.
				if(map[nextR][nextC] == 0) queue.add(new Dot(nextR, nextC));
				if(map[nextR][nextC] == 1) {
					map[nextR][nextC] = 0;
					cheese--;
				}
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
