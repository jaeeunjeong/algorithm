//https://www.acmicpc.net/problem/1931 
import java.io.*;
import java.util.*;
/**
 * 사용 가능한 회의실 갯수를 찾으면 되는 문제
 * 회의실의 시작 시간과 종료 시간을 그래프로 나타내보면 겹치는 부분이 존재한다.
 * 겹치는 부분이 있다는 소리는 회의실을 다르게 사용해야한다는 것이고 우리가 원하는 회의실 갯수임을 알 수 있다.
 * 최대한 적은 수로 나타내야하기에 종료값을 기준으로 정렬해준다. -> 시작 값을 기준으로 하면 연달아 수업이 좀 어려움.
 * 정렬된 배열을 갖고 시작 시간과 종료 시간을 비교해준다.
 * 어떤 수업의 시작 시간보다 다른 종료 시간이 크다면 겹친다는 것으로 갯수 카운트를 증가시켜준다.
 * 이후 종료 시간도 갱신해준다.
 * 
 * 겹치는 부분을 통해 문제를 해결한다는 점에 유의하는 것이 중요하다고 생각된다.
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] times = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			times[i] = new int[] { start, end };
		}
		Arrays.sort(times, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		int answer = 0;
		int end = Integer.MIN_VALUE;
		for(int[] cur : times) {
			int start = cur[0];
			if(start >= end) {
				end = cur[1];
				answer++;
			}
		}
		System.out.println(answer);
	}
}
