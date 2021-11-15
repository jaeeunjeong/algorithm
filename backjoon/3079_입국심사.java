//https://www.acmicpc.net/problem/3079
import java.io.*;
import java.util.*;

/**
 * 처음에는 값이 매우 커서 dp인줄 알았고, 
 * 그 다음에는 현재 상황에서 최소 값을 전부 탐색하였지만 시간초과!(이때는 값이 크다는 것을 잊음)
 * 그래서 문제 유형을 보니 이분탐색.
 * 입국 심사에 필요한 최소 시간과 최대 시간을 구한다.
 * 그 가운데 값을 구한 후, 가운데 값을 이용해서 심사대가 심사할 수 있는 인원 수를 구한다.
 * 심사원이 심사할 수 있는 인원이 목표 인원보다 크면 시간을 줄이고 다시 탐색
 * 심사원이 심사할 수 있는 인원이 목표 인원보다 작다면 시간을 늘리고 다시 탐색
 * 이러한 과정을 통해 최소 값을 찾는다.
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] desk = new int[N];
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			desk[i] = temp;
			min = Math.min(temp, min);
			max = Math.max(temp, max);
		}

		max *= M;
		long mid = 0;
		long answer = 0;
		while (min <= max) {
			mid = (min + max) / 2;
			long people = 0;
			for (long time : desk) {
				people += (mid / time);
				if (people >= M)
					break;
			}
			if (people >= M) {
				max = mid - 1;
				answer = mid;
			} else
				min = mid + 1;
		}
		
		System.out.println(answer);

	}
}
