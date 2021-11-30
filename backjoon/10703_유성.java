//https://www.acmicpc.net/problem/10703
import java.io.*;
import java.util.*;

/**
 * X를 먼저 찾는다. 
 * X를 찾았다면 공간(.)의 길이를 확인해준다. 
 * 최소 길이를 찾아서 리턴한다.
 * 
 * 리턴받은 최소 길이를 바탕으로 땅이 아닌 곳부터 서로 맞교환 가능하다면 값을 바꿔준다.
 **/
class Main {
	static char[][] map;
	static int R, C;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 최소 거리 구하기.
		int min = minDistance();
		move(min);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void move(int min) {
		for (int i = 0; i < C; i++) {
			for (int j = R - 1; j >= 0; j--) {
				if (j + min < R && map[j][i] == 'X' && map[j + min][i] == '.') {
					char temp = map[j][i];
					map[j][i] = map[j + min][i];
					map[j + min][i] = temp;
				}
			}
		}
	}

	public static int minDistance() {
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < C; j++) {
			int cnt = Integer.MAX_VALUE;
			boolean flag = false;
			for (int i = 0; i < R; i++) {
				if (!flag && map[i][j] == 'X') {
					flag = true;
				}
				if (flag) {
					if (map[i][j] == 'X')
						cnt = 0;
					else if (map[i][j] == '#') {
						break;
					}
					cnt++;
				}
			}
			min = Math.min(cnt - 1, min);
		}
		return min;
	}
}
