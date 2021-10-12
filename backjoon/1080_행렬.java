//https://www.acmicpc.net/problem/1080
import java.io.*;
import java.util.*;

/**
 * Silver 2
 * 알고리즘을 풀이하기 위해 특별한 스킬은 안 보이고 모든 경우를 확인해보면 되는 문제!
 * N과 M이 3x3이 되지 않아 switch를 못 하는 경우를 먼저 확인해줘야한다.
 * 이미 같다면 0을 출력해주고,  switch를 못한다면 -1를 출력한다.
 * 나머지는 (0,0)에서 돌아가면서 순차적으로 해주면 된다.
 * 순서는 별로 중요하지 않다. 왜냐면 순서에 관계없이 동일한 값을 갖게되기 때문이다.
 **/
class Main {
	static int[][] mapA, mapB;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		mapA = new int[N][M];
		mapB = new int[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				mapA[i][j] = str.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				mapB[i][j] = str.charAt(j)-'0';
			}
		}
		
		if(N < 3 || M < 3) {
			if(isSame(N, M)) {
				System.out.println(0);
				return;
			}
			System.out.println(-1);
			return;
		}
		
		for (int i = 0; i < N-2; i++) {
			for (int j = 0; j < M-2; j++) {
				if(mapA[i][j] == mapB[i][j]) continue;
				filp(i, j);
				cnt++;
			}
		}
		if(!isSame(N, M)) {
			cnt = -1;
		}
		System.out.println(cnt);
	}
	public static boolean isSame(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(mapA[i][j] != mapB[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void filp(int row, int col) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				mapA[row+i][col+j] = (mapA[row+i][col+j]+1)%2;
			}
		}
	}
}
