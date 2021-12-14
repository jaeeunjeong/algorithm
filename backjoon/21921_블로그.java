
//https://www.acmicpc.net/problem/21921
import java.io.*;
import java.util.*;

/**
 * G3
 * 누적합, 슬라이딩윈도우
 * 슬라이딩윈도우라는 풀이를 분명하게 이해하고 풀어본 적은 첨인듯하다.
 * 값을 더해주고 빼주면서 구간에 대한 합을 구해준다.
 * 해당 값이 최대 값이면 카운트와 최대값을 갱신하고
 * 최대값과 동일하다면 카운트를 올려준다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
		}
		int sum = 0;
		for (int i = 0; i < X; i++) {
			sum += arr[i];
		}
		
		long answer =sum;
		int cnt = 1;

		for (int i = X; i < N; i++) {
			sum += arr[i];
			sum -= arr[i-X];
			if(answer < sum) {
				answer = sum;
				cnt = 1;
			}else if(answer == sum) cnt++;
		}

		if (answer == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(answer);
			System.out.println(cnt);
		}
	}
}
