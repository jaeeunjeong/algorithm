https://www.acmicpc.net/problem/10942
import java.io.*;
import java.util.*;

/**
 * DP 문제이긴 하는데 그냥 for문으로 비교해도 출력만 잘 되면 통과는 하는 문제.
 * 이 문제의 핵심을 한 문장으로 나타내면 
 * "펠린드롬이 되는 경우는 양 끝 글자 가 같고 그 사이 숫자가 펠린드롬이면 펠린드롬이다" 이다. 
 */
public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] palindrom = new boolean[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			//길이가 1인 경우
			palindrom[i][i] = true;
			//길이가 2인 경우
			if (i < N && (arr[i] == arr[i + 1]))
				palindrom[i][i + 1] = true;
		}

		//길이가 3 이상인 경우 -> 범위를 좁혀주면서 파악하고 싶어서 뒤에서부터 풀이.
		for (int i = N - 1; i > 0; i--) {
			for (int j = 2; j <= N; j++) {
				if (arr[i] == arr[j] && palindrom[i + 1][j - 1])
					palindrom[i][j] = true;
			}
		}

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(palindrom[s][e]? 1 : 0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int palin(int s, int e) {
		while (s < e) {
			if (arr[s++] != arr[e--])
				return 0;
		}
		return 1;
	}
}
