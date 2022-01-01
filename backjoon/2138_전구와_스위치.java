//https://www.acmicpc.net/problem/2138
import java.io.*;
import java.util.*;

/**
 *
 * 문제 이해만 하면 어렵지는 않은 문제
 * 
 * 1. 왼쪽에서부터 순서대로 이동하면서 풀면 된다. 이 문제는 순서가 중요하지 않은데 최소 절대 보장하기 때문이다. 어떤 순서대로 진행하던
 * 최소 값은 이미 정해져있기에 코딩에 필요한 순서대로 진행하면 된다.
 * 
 * 2. 첫번째 인덱스는 비교할 값이 없기에 스위치 값을 바꾸는 경우 두가지로 나눠서 풀이해줘야한다.
 * 
 * 3. 그 외는 이전 값이 같다면 값을 변경하지 않고 다르다면 변경하는 방식으로 풀이하면 된다.
 * 
 * 4. 제일 마지막 값은 검증하지 않기에 마지막에 검증을 통해서 일치하지 않는다면 제일 큰 값을 리턴해준다. -> 불일치를 의미.
 */
public class Main {
	static int N, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		String cur = br.readLine();
		String result = br.readLine();
		int answer = Integer.MAX_VALUE;
		char[] bulbs = new char[N];
		for (int i = 0; i < N; i++) {
			bulbs[i] = cur.charAt(i);
		}
		cnt = 0;
		push(bulbs, result);
		answer = Math.min(cnt, answer);
		bulbs = new char[N];
		for (int i = 0; i < N; i++) {
			bulbs[i] = cur.charAt(i);
		}
		bulbs[0] = bulbs[0] == '0' ? '1' : '0';
		bulbs[1] = bulbs[1] == '0' ? '1' : '0';
		cnt = 1;
		push(bulbs, result);
		answer = Math.min(cnt, answer);
		if (answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);
	}

	public static void push(char[] bulbs, String result) {
		for (int i = 1; i < N; i++) {
			if (bulbs[i - 1] == result.charAt(i - 1))
				continue;
			cnt++;
			for (int j = -1; j < 2; j++) {
				int idx = i + j;
				if (idx < N)
					bulbs[idx] = bulbs[idx] == '0' ? '1' : '0';
			}
		}
		if (bulbs[N - 1] != result.charAt(N - 1)) {
			cnt = Integer.MAX_VALUE;
		}
	}
}
