// https://www.acmicpc.net/problem/1911 
import java.io.*;
import java.util.*;

/**
 * 그리디 문제!
 * 
 * 널빤지의 끝점을 가지고, 풀이하는 것이 포인트!
 * 
 * 웅덩이의 시작값이 주어지면, 시작값이 널빤지 끝점보다 크다면 널빤지의 끝점을 시작점으로 바꿔준다.
 * 웅덩이의 끝값보다 널빤지의 끝점이 커질 때까지 널빤지 갯수를 늘려간다.
 * 
 * 주의 사항
 * 1. 웅덩이의 길이가 시작점은 포함하지 않고 끝점은 포함한다.
 * 2. 웅덩이의 경우 정렬이 되어있지 않아서 시작점을 기준으로 정렬을 해줘야한다.
 */
class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] road = new int[N][2];
    
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());
			road[i][1] = Integer.parseInt(st.nextToken());
		}
    
		Arrays.sort(road, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
    
		long answer = 0;
		int idx = 0;
		int end = 0;
    
		while (idx < N) {
			int curStart = road[idx][0] + 1;
			int curEnd = road[idx][1];
			end = Math.max(curStart, end);
			while (end <= curEnd) {
				end += M;
				answer++;
			}
			idx++;
		}
		System.out.println(answer);
	}
}
