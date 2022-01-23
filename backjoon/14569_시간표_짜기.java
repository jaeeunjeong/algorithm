//https://www.acmicpc.net/problem/14569 
import java.io.*;
import java.util.*;
/**
 * 비트마스킹 문제!
 * 
 * 듣고 싶은 수업들을 먼저 비트마스킹을 이용하여 숫자로 만들어준다.
 * 그 후, 비어있는 시간표를 비트마스킹으로 만든다. 그렇게 하면 들은 상태가 되는 거니까 not연산을 이용하여 꺼진 상태로 만들어준다.
 * 이후 두 값을 &연산 하여 0이면 들을 수 있기에 카운트를 늘려준다.
 */
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		// 듣고 싶은 수업
		int N = Integer.parseInt(st.nextToken());
		long[] classes = new long[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			long cur = 0;
			int cnt = Integer.parseInt(st.nextToken());

			while (cnt-- > 0) {
				cur |= ((long) 1 << Integer.parseInt(st.nextToken()));
			}
			classes[i] = cur;
		}

		// 비어 있는 시간표
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			long cur = 0;

			while (cnt-- > 0) {
				cur |= ((long) 1 << Integer.parseInt(st.nextToken()));
			}

			//비어있는 시간표에 1이 되어 있어서 not 연산을 통해 0으로 바꿔준다.
			cur = ~cur;
			
			for (int j = 0; j < N; j++) {
				if ((cur & classes[j]) == 0)
					answer++;
			}

			System.out.println(answer);
		}
	}
}
