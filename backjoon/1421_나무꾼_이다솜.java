//https://www.acmicpc.net/problem/1421
import java.io.*;
import java.util.*;

/**
 * 구현 문제인데 고려해야 할 사항이 꽤 있었다.
 * 값을 구할 때는 하나 하나 판단을 해줘야했다.
 * 1. 딱 떨어지는 경우가 있을 수 있고, 
 * 	-> 나의 경우엔 flag를 주어 안 남으면 불필요한 마지막 자름에 대한 비용이 없도록 더해주었다.
 * 2. 자르는 비용이 커서 손해를 입을 수도 있기 떄문.
 **/
class Main {
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			max = Math.max(temp, max);
		}
		
		long answer = 0;
		for (int i = 1; i <= max; i++) {
			long result = 0;
			for(int x : arr) {
				if(x < i) continue;
				int cnt =  x/ i;
				int rest = 0;
				if(x % i == 0) rest = 1;
				long sum = cnt* i * W - cnt*C + rest*C;
				if(sum > 0) result += sum;
			}
			answer = Math.max(result, answer);
		}
		
		System.out.println(answer);

	}
}
