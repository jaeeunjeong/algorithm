//https://www.acmicpc.net/problem/11501
import java.io.*;
import java.util.*;

/**
 * 뒤에서부터 탐색해서 제일 큰 값을 찾는다. 제일 큰 값보다 현재 값(인덱스 값이 작은 곳의 값)이 크다면 손해를 보는 것이고, 현재 값이
 * 더 작다면 이득을 보기에 차액을 더해준다.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			long answer = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = arr[N-1];
			
			for(int i = N-2 ; i >= 0; i--) {
				if(max > arr[i]) {
					answer += (max - arr[i]);
				}else {
					max = arr[i];
				}
			}
			System.out.println(answer);

		}
	}
}
