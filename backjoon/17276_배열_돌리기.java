//https://www.acmicpc.net/problem/17276 
import java.io.*;
import java.util.*;
/**
 * 문제에서 요구하는 대로 구현하기만 하면 되는 문제!
 * 각도 부분은 +360을 해서 음수를 양수로 바꿔주고, 45로 나눈 횟수만큼 회전시켜주었다.
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) + 360;
			d /= 45;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			while (d-- > 0)
				turn(map);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

	private static void turn(int[][] map) {
		int N = map.length;
		int[][] temp = new int[map.length][map.length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				temp[i][j] = map[i][j];
			}
		}
		// 1.
		for (int i = 0; i < N; i++) {
			map[i][N / 2] = temp[i][i];
		}
		// 2.
		for (int i = N - 1; i >= 0; i--) {
			map[i][N - i - 1] = temp[i][N / 2];
		}
		// 3.
		for (int i = 0; i < N; i++) {
			map[N/2][i] = temp[N - i - 1][i];
		}
		// 4.
		for (int i = 0; i < N; i++) {
			map[i][i] = temp[N/2][i];
		}

	}
}
