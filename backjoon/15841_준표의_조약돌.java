
//https://www.acmicpc.net/problem/15841 
import java.io.*;
import java.util.*;

/*
 * 투 포인터 문제!
 * 검은돌은 일정 갯수를 넘으면 안 되고 흰 돌은 일정 갯수를 넘어야한다.
 * 포인터를 두개를 두는데 하나는 시작지점, 하나는 종료지점이다.
 * 종료지점을 값을 옮겨가며 흰돌과 검은돌의 갯수를 파악해간다.(right의 위치를 옮김)
 * 흰돌이 일정 갯수를 넘기면 answer의 값을 갱신하고,
 * 검은 돌이 일정 갯수를 넘기면 다음 검은 돌을 만날때까지 시작 위치를 옮겨준다.(left의 위치를 옮김)
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		char[] road = br.readLine().toCharArray();
		int left = 0;
		int right = 0;
		int answer = 0;
		int black = 0;
		int white = 0;

		while (left <= right && right < N) {
			char cur = road[right++];
			if (cur == 'B')
				black++;
			if (cur == 'W')
				white++;
			if (black > B) {
				for (int i = left; i < right; i++) {
					char now = road[i];
					if (now == 'B') {
						left = i + 1;
						black--;
						break;
					} else {
						white--;
					}
				}
			}
			if (white >= W) {
				answer = Math.max(answer, right - left);
			}
		}
		System.out.println(answer);
	}
}
