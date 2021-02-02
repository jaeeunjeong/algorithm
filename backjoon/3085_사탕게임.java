//https://www.acmicpc.net/problem/3085
import java.io.*;
import java.util.*;

class Main {
	static int N, max;
	static char[][] arr, tempArr;
	static int[][] move = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		max = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				arr[i][j] = c; 
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				/*for (int dir = 0; dir < 4; dir++) {
					changeArr(new Dot(i,j), dir);
				}*/
				char temp = arr[i][j];
				
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = temp;
				check();
				temp = arr[i][j+1];
				arr[i][j+1] = arr[i][j];
				arr[i][j] = temp;
				
				temp = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = temp;
				check();
				temp = arr[j+1][i];
				arr[j+1][i] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		System.out.println(max);
	}
	
	
	public static void check() {
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if(arr[i][j]== arr[i][j-1]) cnt++;
				else {
					max = Math.max(max,cnt);
					cnt =1;
				}
			}
			max = Math.max(max,cnt);
		}
		
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if(arr[j][i]== arr[j-1][i]) cnt++;
				else {
					max = Math.max(max,cnt);
					cnt =1;
				}
			}
			max = Math.max(max,cnt);
		}
	}
	
	
// 새로운 배열을 만들어서 탐색하기.
	public static void changeArr(Dot curD, int dir) {
		tempArr = new char[N][N];
		for (int j = 0; j < N; j++) {
			tempArr[j] = Arrays.copyOf(arr[j], N);
		}
		
		int nextR = curD.row + move[dir][0];
		int nextC = curD.col + move[dir][1];
		if(nextR <0 || nextC < 0 || nextR >= N || nextC >= N) return;
		
		char curValue = arr[curD.row][curD.col];
		char targetValue = arr[nextR][nextC];
		
		tempArr[curD.row][curD.col] = targetValue;
		tempArr[nextR][nextC] = curValue;
		
		visit = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					for (int start = 0; start < 4; start++) {
						int temp = bfs(i, j,start);
						max = Math.max(temp, max);
					}
				}
			}
		}
	}
	
	public static int bfs(int row, int col, int start) {
		
		int result = 0;
		Queue<Dot> queue = new LinkedList<Dot>();
		
		char target = tempArr[row][col];
		queue.add(new Dot(row, col));
		visit[row][row] = true;
		result++;

		while(!queue.isEmpty()) {
			
			Dot d = queue.poll();
			int nextR = d.row + move[start][0];
			int nextC = d.col + move[start][1];
			
			if(nextR <0 || nextC < 0 || nextR >= N || nextC >= N) continue;
			if(visit[nextR][nextC]) continue;
			if(tempArr[nextR][nextC] != target) continue;
			
			visit[nextR][nextC] = true;
			queue.add(new Dot(nextR, nextC));
			result++;
		}
		return result;
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
