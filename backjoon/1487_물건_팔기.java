//https://www.acmicpc.net/problem/1487
import java.io.*;
import java.util.*;

/**
 * 구현 문제
 * 이익을 계산해줘야하기에 꼭 판매금액에서 배달 비용을 빼줘야 한다.
 * 조건에 맞게 분기 처리 해주면 된다.
 **/
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[][] price = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			price[i][0] = Integer.parseInt(st.nextToken());
			price[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			int result = 0;
			for (int j = 0; j < N; j++) {
				if (price[j][0] >= price[i][0] && price[i][0] >= price[j][1])
					result += (price[i][0] - price[j][1]);
			}
			if (result > max) {
				max = result;
				answer =  price[i][0];
			}
			if(result == max) answer = Math.min(answer, price[i][0]);
		}
		System.out.println(answer);
	}
}
