//https://www.acmicpc.net/problem/2602
import java.io.*;
import java.util.*;

/**
 * 재귀를 이용하여 탐색해주되, 메모이제이션 기법을 이용하여 값을 저장해준다.
 * 돌다리 종류, 현재 돌다리 위치 , 두루마리 위치를 매개변수로 갖는 메서드를 만들어주었다.
 * 모든 탐색을 완료하면 1을 리턴하고 그 값을 더해주면서 답을 구한다.
 * -1로 초기화하는 이유는 계속해서 값이 확인될 것인데 한번 방문한 곳을 재방문하지 않기 위함이다.
 */
class Main {
	static int[][][] dp;
	static String str, devil, angel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// st = new StringTokenizer(br.readLine());
		str = br.readLine();
		devil = br.readLine();
		angel = br.readLine();
		dp = new int[2][100][20];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 20; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		int a = search(0, 0, 0);
		int b = search(1, 0, 0);
		System.out.println(a + b);
	}

	public static int search(int type, int cur, int cnt) {
		if (cnt == str.length()) {
			return 1;
		}

		if (dp[type][cur][cnt] > -1)
			return dp[type][cur][cnt];

		int answer = 0;
		for (int i = cur; i < devil.length(); i++) {
			if (type == 0) {
				if (str.charAt(cnt) == devil.charAt(i)) {
					answer += search(1, i + 1, cnt + 1);
				}
			} else {
				if (str.charAt(cnt) == angel.charAt(i)) {
					answer += search(0, i + 1, cnt + 1);
				}
			}
		}
		return dp[type][cur][cnt] = answer;
	}

	public static int recursion(int N, int r, int c) throws IOException {

		if (N == 0)
			return 0;
		int half = 1 << (N - 1);

		if (r < half && c < half)
			return recursion(N - 1, r, c);
		if (r < half && c >= half)
			return half * half + recursion(N - 1, r, c - half);
		if (r >= half && c < half)
			return half * half * 2 + recursion(N - 1, r - half, c);
		return half * half * 3 + recursion(N - 1, r - half, half);

	}
}
