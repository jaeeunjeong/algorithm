//https://www.acmicpc.net/problem/1051
import java.io.*;
import java.util.*;

/**
 * 정사각형이기 때문에 가로 세로 중 짧은 것을 정해서 최대 정사각형 크기를 만들어준다.
 * 정사각형 크기 별로 각 꼭지점들만 돌아가며 값들이 동일한지 파악하고, 제일 큰 값을 리턴해준다
 **/
class Main {
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				int cur = s.charAt(j) - '0';
				map[i][j] = cur;
			}
		}

		int min = Math.min(N, M);
		int answer = Integer.MIN_VALUE;
		for (int size = 0; size < min; size++) {
		for (int r1 = 0; r1 < N - size; r1++) {
			for (int c1 = 0; c1 < M - size; c1++) {
					if (map[r1][c1] != map[r1][c1 + size] 
							|| map[r1][c1] != map[r1 + size][c1]
							|| map[r1][c1] != map[r1 + size][c1 + size]) continue;
					answer = Math.max(size, answer);
				}
			}
		}
		System.out.println((answer+1)*(answer+1));
	}
}
