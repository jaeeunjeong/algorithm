
//https://www.acmicpc.net/problem/1094 
import java.io.*;
import java.util.*;

/**
 * 2의 n승인 점을 이용하여 비트마스킹으로 풀이.
 * 부분집합을 이용!
 * shift 연산자를 이용해서 값을 구한다.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int answer = 0;
		for (int i = 0; i < 7; i++) {
			if ((X & (1 << i)) > 0) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
