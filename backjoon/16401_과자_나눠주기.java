//https://www.acmicpc.net/problem/16401
import java.io.*;
import java.util.*;

/**
 * 중간 값을 구하고, 그 값을 기준으로 과자의 길이를 나눠서 몫을 구해주고 그 몫들을 더한다.
 * 그 몫이 조카 수보다 적다면 중간 값을 줄여주고, 
 * 몫이 조카 수와 같거나 크다면 중간 값을 늘려서 최대 길이를 찾아준다.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int start = 1;
		int end = 0;
		for (int i = 0; i < M; i++) {
			int cur = Integer.parseInt(st.nextToken());
			list.add(cur);
			end = Math.max(end, cur);
		}
		int answer = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				cnt += list.get(i) / mid;
			}
			if (cnt >= N) {
				answer = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
