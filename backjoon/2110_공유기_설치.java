//https://www.acmicpc.net/problem/2110
import java.io.*;
import java.util.*;

/**
 * 값이 매우 큼으로 완전 탐색 불가함.
 * 
 * 2개 이상 설치될 것이므로 가운데가 제일 클 것이다.
 * 따라서 가운데 값을 기준으로 설치할 공유기들의 갯수(= 공유기 묶음 구간 갯수)를 파악하여 거리를 조정해준다.
 * 
 * 양 끝 값을 기준으로 최소/최대 거리를 지정한다.
 * 둘의 가운데 지점(mid)이 제일 클 값일 것이기에 그 값을 기준으로
 * 설치될 공유기가 더 필요하다면 mid 값을 줄여 공유기를 더 설치하고
 * 설치될 공유기가 많아서 줄여야한다면 mid 값을 늘려 공유기를 적게 설치하도록한다.
 * 
 * 문제의 정답은 최소한의 공유기로 최대의 거리를 알아내는 것이기에
 * 공유기를 줄일 때의 거리를 정답으로서 제출하면 된다.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int answer = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int start = 1;
		int end = arr[N - 1] - arr[0];
		while (start <= end) {
			int mid = (start + end) / 2;// 생각하는 최대 값(중간 값)
			int startDist = arr[0];
			int cnt = 1; // 구간 갯수 또는 설치될 공유기 수로 해석 가능.
			for (int i = 1; i < N; i++) {
				if (arr[i] - startDist >= mid) {
					cnt++;
					startDist = arr[i];
				}
			}

			if (cnt >= C) { // 공유기가 더 설치 되면 안 된다.
				answer = mid;
				start = mid + 1;
			} else //공유기가 더 설치 되어야 한다.
				end = mid - 1;
		}
		System.out.println(answer);
	}
}
