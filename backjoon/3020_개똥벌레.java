// https://www.acmicpc.net/problem/3020
import java.io.*;
import java.util.*;

/**
 * 크기 별로 종유석과 석순의 갯수를 구한다.
 * 역순으로 구간합을 구한다. -> 4의 높이에서 5는 지나가지만 3의 높이는 지나가지 않기 때문임!
 * 현재의 높이를 기준으로 갯수들을 더하고 최소값과 최솟값의 갯수를 구한다.
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] upperArr = new int[H + 1];
		int[] lowerArr = new int[H + 1];
		for (int i = 0; i < N / 2; i++) {
			int lower = Integer.parseInt(br.readLine());
			int upper = Integer.parseInt(br.readLine());

			upperArr[upper]++;
			lowerArr[lower]++;
		}

		int min = Integer.MAX_VALUE;
		int[] result = new int[H + 1];
		for (int i = H - 1; i > 0; i--) {
			upperArr[i] += upperArr[i + 1];
			lowerArr[i] += lowerArr[i + 1];
		}

		for (int i = 1; i <= H; i++) {
			result[i] = upperArr[i] + lowerArr[H - i + 1];
			min = Math.min(result[i], min);
		}

		int cnt = 0;
		for (int i = 1; i <= H; i++) {
			if (result[i] == min) {
				cnt++;
			}
		}
		System.out.println(min + " " + cnt);
	}
}
