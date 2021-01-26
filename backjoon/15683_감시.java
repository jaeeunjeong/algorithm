//https://www.acmicpc.net/problem/15683
import java.io.*;
import java.util.*;

class Main {

	static int[][] dir = {{1, 0}, {0, 1},{-1, 0},{0, -1}}; // 시계 방향
	static int[][] office = new int[10][10];//사무실 지도
	static int[][] cctvArea = new int[10][10];//cctv에 걸리는 영역
	static ArrayList<Dot> cctv = new ArrayList<Dot>();//cctv가 있는 영역
	static int N, M ;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//세로
		M = Integer.parseInt(st.nextToken());//가로
		int min = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int cur = Integer.parseInt(st.nextToken());
				office[i][j] = cur;
				if(cur != 0 && cur !=6) {
					cctv.add(new Dot(i, j));
				}
				if(cur == 0) min++;
			}
		}
		//4의 cctv.size()승을 의미.
		int testCaseCnt = 1 << (2*cctv.size());
		for (int index = 0; index < testCaseCnt; index++) {
			
			for (int i = 0; i < N; i++) {
				cctvArea[i] = Arrays.copyOf(office[i], M);//배열의 값만 복사하기 위함.
			}
				int brute = index;
				
				for (int i = 0; i < cctv.size(); i++) {
					//4진법으로 만들고 다음 4진법으로 만들기 위한 과정.
					int dir = brute %4;
					brute/=4;
					
					int row = cctv.get(i).row;
					int col = cctv.get(i).col;
					
					int type = office[row][col];

					if(type == 1) {
						upd(row, col, dir);
					}else if(type == 2) {
						upd(row, col, dir);
						upd(row, col, dir+2);
					}else if(type == 3) {
						upd(row, col, dir);
						upd(row, col, dir+1);
					}else if(type == 4) {
						upd(row, col, dir);
						upd(row, col, dir+1);
						upd(row, col, dir+2);
					}else if(type == 5) {
						upd(row, col, dir);
						upd(row, col, dir+1);
						upd(row, col, dir+2);
						upd(row, col, dir+3);
					}
					
			}
      
      //공간 찾기
      int temp = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
				  if (cctvArea[i][j]== 0) temp++;
			  }
		  }
      
      min = Math.min(min, temp);
      }
      
      System.out.println(min);
	}
	public static void updateData(int row, int col, int d) {
		d%=4;
		
		while(true) {
			row += dir[d][0];
			col += dir[d][1];
			
			if(row<0 || row >=N || col<0 || col >=M) return;
			if(cctvArea[row][col] == 6) return;
			if(cctvArea[row][col] != 0) continue;
			
			cctvArea[row][col] = 7;
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
