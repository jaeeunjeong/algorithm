//https://www.acmicpc.net/problem/2447
import java.io.*;
import java.util.*;

class Main {
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//N은 3의 거듭제곱
		//N*N의 정사각형
		//가운데 공백 테두리에 별이 하니씩 있는 패턴
		int N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				map[i][j] = ' ';
		recursive(0, 0, N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
		
	}
	
	public static void recursive(int x, int y, int N) {
		
		//base condition
		if(N==1) {
			map[x][y] = '*';
			return;
		}
		
		int size = N/3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;
				recursive(x+size*i, y+size*j,size);
			}
		}
	}
}
