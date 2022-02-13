//https://www.acmicpc.net/problem/13702
import java.io.*;
import java.util.*;

/**
 * 제일 큰 값과 제일 작은 값의 중간 값을 구한다. 이 임의의 중간 값은 분배할 수 있는 양이 된다.
 * 중간값을 기준으로 각각의 주전자들을 나누고 그 값들을 더하면 나눌 수 있는 친구 수가 된다.
 * 중간 값이 너무 커서 모든 친구들에게 줄 수 없다면 제일 큰 값을 중간 값 -1 값으로 바꿔주고,
 * 중간 값으로 모든 친구들에게 나눠줄 수 있다면 제일 작은 값을 중간 값 + 1로 바꿔서 줄수 있는 양 중 최대 값을 구해준다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		long min = 1;
		long max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long answer = 0;
		while(min <= max) {
			long mid = (min + max) /2;
			int result = 0;
			
			for(long a : arr) result += a/ mid;
			
			if(result >= K) {
				answer = mid;
				min = mid +1;
			}else {
				max = mid -1;
			}
		}
		
		System.out.println(answer);
		
	}
}
