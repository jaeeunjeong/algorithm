//https://www.acmicpc.net/problem/1057 
import java.io.*;
import java.util.*;

/**
 * 거의 수학 문제
 * 현재 위치에서 +1을 한 후 /2를 하면 다음 라운드의 내 위치가 된다.
 * 이를 이용해서 풀이하면 됨.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());

		int answer = 0;
		while (N / 2 > 0) {
			answer++;

			K = (K + 1) / 2;
			I = (I + 1) / 2;

			if (K == I)
				break;
		}
		if(N == 0) answer = -1;

		System.out.println(answer);
	}

}
