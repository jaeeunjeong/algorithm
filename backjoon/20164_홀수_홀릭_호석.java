//https://www.acmicpc.net/problem/20164
import java.io.*;
import java.util.*;

/**
 * 재귀를 이용해서 풀이.
 * 
 * 이 문제 포인트 1. 값 나누기. 2. 홀수 파악하기.
 * 
 * 나눠주기전에 먼저 파악한다.
 * 
 * 3군데로 나누는 거는 for문 2개 이용해서 두 가지 경우로 나누어서 계산을 해준다.
 * 이후 값이 10보다 작으면 리턴 처리해서 값을 나타낸다.
 * 
 * 글자수가 2인 경우에는 불가능하기때문에 따로 분기처리해서 처리해준다.
 */
public class Main {
	static int max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
    recursion(br.readLine(), 0);
		System.out.println(min + " " + max);
	}

	public static void recursion(String data, int cnt) {
		// 홀수 갯수 세기
		for (char c : data.toCharArray()) {
			int number = c - '0';
			if (number % 2 == 1)
				cnt++;
		}

		if (Integer.parseInt(data) < 10) {
			max = Math.max(max, cnt);
			min = Math.min(min, cnt);
			return;
		}

		int length = data.length();
		if (length == 2) {
			data = String.valueOf(data.charAt(0) + data.charAt(1) - '0' - '0');
			recursion(data, cnt);
		} else {
			for (int i = 1; i < length - 1; i++) {
				for (int j = i + 1; j < length; j++) {
					int left = Integer.parseInt(data.substring(0, i));
					int center = Integer.parseInt(data.substring(i, j));
					int right = Integer.parseInt(data.substring(j));
					int result = left + center + right;
					recursion(String.valueOf(result), cnt);
				}
			}
		}
	}
}
