//https://www.acmicpc.net/problem/2531 
import java.io.*;
import java.util.*;

/**
 * 슬라이딩윈도우
 * 
 * set으로 풀었다가 시간초과가 나왔다.
 * 
 * 배열을 이용해서 첫 방문하는 애들은 카운트를 추가하고, 갯수도 관리해주는 형식으로 풀이!
 * 
 * 쿠폰 초밥에서 특히!! 분기처리를 잘 해주어야한다.(쿠폰 초밥을 안 먹은 경우만 cnt를 추가해줘야하는 것을 주의해줘야한다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] marked = new int[d + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (marked[arr[i]] == 0)
				cnt++;
			marked[arr[i]]++;
		}
		int answer = cnt;
		for (int i = 1; i < N; i++) {
			if (answer <= cnt) {
				if (marked[c] == 0) {
					answer = cnt + 1;
				} else { 
					answer = cnt;
				}
			}
			int end = (i + k - 1) % N;
			if (marked[arr[end]] == 0)
				cnt++;
			marked[arr[end]]++;
			marked[arr[i - 1]]--;
			if (marked[arr[i - 1]] == 0)
				cnt--;
		}
		System.out.println(answer);
	}
}
