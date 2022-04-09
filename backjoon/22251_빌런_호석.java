//https://www.acmicpc.net/submit/22251
import java.io.*;
import java.util.*;

/**
 * 되게 재밌는 문제였다.
 * 문제는 어려운거 같지 않은데 발상이 쉽지 않았다.
 * 어떤 값을 만들기 위해 1- N까지 LED 위치를 확인해가면서 풀이하면 되는 문제!
 * 자릿수를 만들어줄 메서드
 * 둘을 비교할 메서드 가 필요하다.
 * LED의 켜지고 꺼지는 위치를 배열로 만들고 각각의 위치들을 비교해가면서 정해진 숫자내에 만들 수 있는지 확인하면 된다.
 */
public class Main {
	static int[][] leds = { { 1, 1, 1, 0, 1, 1, 1 }, // 0
			{ 0, 0, 1, 0, 0, 0, 1 }, // 1
			{ 0, 1, 1, 1, 1, 1, 0 }, // 2
			{ 0, 1, 1, 1, 0, 1, 1 }, // 3
			{ 1, 0, 1, 1, 0, 0, 1 }, // 4
			{ 1, 1, 0, 1, 0, 1, 1 }, // 5
			{ 1, 1, 0, 1, 1, 1, 1 }, // 6
			{ 0, 1, 1, 0, 0, 0, 1 }, // 7
			{ 1, 1, 1, 1, 1, 1, 1 }, // 8
			{ 1, 1, 1, 1, 0, 1, 1 } // 9
	};
	static int[] xDigit;
	static int K, P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 최대값
		K = Integer.parseInt(st.nextToken()); // 자릿수
		P = Integer.parseInt(st.nextToken()); // 반전 갯수
		int X = Integer.parseInt(st.nextToken()); // 처음 값
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			xDigit = toDigit(X);
			if (i == X)
				continue;
			if (count(i, X))
				answer++;
		}
		System.out.println(answer);
	}

	public static boolean count(int now, int origin) {
		int[] curDigit = toDigit(now);
		int cnt = 0;
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < 7; j++) {
				if (leds[curDigit[i]][j] != leds[xDigit[i]][j])
					cnt++;
				if (cnt > P)
					return false;
			}
		}
		return true;
	}

	public static int[] toDigit(int number) {
		int[] result = new int[K];
		for (int i = K - 1; i >= 0; i--) {
			result[i] = number % 10;
			number /= 10;
		}
		return result;
	}
}
