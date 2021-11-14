//https://www.acmicpc.net/problem/16935 
import java.io.*;
import java.util.*;

/**
 * 배열 파이팅...
 * 단순 구현이라고 생각하지만, 
 * 나에겐
 * 많은 연습이 필요한 부분임 ㅠㅠ
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (T-- > 0) {
			int cur = Integer.parseInt(st.nextToken());

			switch (cur) {
			case 1:
				map = one(map);
				break;
			case 2:
				map = two(map);
				break;
			case 3:
				map = three(map);
				break;
			case 4:
				map = four(map);
				break;
			case 5:
				map = five(map);
				break;

			default:
				map = six(map);
				break;
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				int cur = map[i][j];
				System.out.print(cur + " ");
			}
			System.out.println();
		}
	}

	public static int[][] six(int[][] map) {
		int rowLength = map.length;
		int colLength = map[0].length;
		int[][] result = new int[rowLength][colLength];

		int rowHalf = rowLength / 2;
		int colHalf = colLength / 2;
		// 4번에 3넣기
		for (int i = rowHalf; i < rowLength; i++) {
			int idx = 0;
			for (int j = colHalf; j < colLength; j++) {
				result[i][j] = map[i][idx++];
			}
		}

		// 3에다가 2넣기
		int idx = 0;
		for (int i = rowHalf; i < rowLength; i++) {
			for (int j = 0; j < colHalf; j++) {
				result[i][j] = map[idx][j];
			}
			idx++;
		}
		// 1번에 2변 넣기
		for (int i = 0; i < rowHalf; i++) {
			for (int j = 0; j < colHalf; j++) {
				result[i][j] = map[i][colHalf + j];
			}
		}

		// 2번 에 1 넣기
		for (int i = 0; i < rowHalf; i++) {
			for (int j = colHalf; j < colLength; j++) {
				result[i][j] = map[rowHalf + i][j];
			}
		}
		return result;
	}

	public static int[][] five(int[][] map) {
		int rowLength = map.length;
		int colLength = map[0].length;
		int[][] result = new int[rowLength][colLength];

		int rowHalf = rowLength / 2;
		int colHalf = colLength / 2;
		for (int i = 0; i < rowHalf; i++) {
			for (int j = 0; j < colHalf; j++) {
				result[i][colHalf + j] = map[i][j];
			}
		}
		for (int i = 0; i < rowHalf; i++) {
			for (int j = colHalf; j < colLength; j++) {
				result[rowHalf + i][j] = map[i][j];
			}
		}
		int idx = 0;
		for (int i = rowHalf; i < rowLength; i++) {
			idx = 0;
			for (int j = colHalf; j < colLength; j++) {
				result[i][idx++] = map[i][j];
			}
		}
		idx = 0;
		for (int i = rowHalf; i < rowLength; i++) {
			for (int j = 0; j < colHalf; j++) {
				result[idx][j] = map[i][j];
			}
			idx++;
		}
		return result;
	}

	public static int[][] four(int[][] map) {
		int rowLength = map.length;
		int colLength = map[0].length;

		int[][] result = new int[colLength][rowLength];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				result[colLength - j - 1][i] = map[i][j];
			}
		}

		return result;
	}

	public static int[][] three(int[][] map) {
		int rowLength = map.length - 1;
		int colLength = map[0].length;

		int[][] result = new int[colLength][rowLength + 1];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < colLength; j++) {
				result[j][rowLength] = map[i][j];
			}
			rowLength--;
		}

		return result;
	}

	public static int[][] two(int[][] map) {
		int rowLength = map.length;
		int colLength = map[0].length;

		int[][] result = new int[rowLength][colLength];
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				int curIdx = colLength - j - 1;
				result[i][curIdx] = map[i][j];
			}

		}
		return result;
	}

	public static int[][] one(int[][] map) {

		int rowLength = map.length;
		int colLength = map[0].length;

		int[][] result = new int[rowLength][colLength];

		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				int curIdx = rowLength - 1 - i;
				result[curIdx][j] = map[i][j];
			}
		}
		return result;
	}
}
