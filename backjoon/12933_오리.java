
//https://www.acmicpc.net/problem/12933
import java.io.*;
import java.util.*;

/**
 * 구현 문제! 값이 크지를 않아서 그냥 구현해도 되고 알고리즘이 전혀 사용되지 않는다. 간과하기 쉬운 것은 크기가 절대 5의 배수가 아니라는
 * 점!
 * 
 * 나는 전부 탐색해주고, 마지막 값이 k로 떨어지지 않는다면 탐색을 종료하였다.
 * 또한 전부 확인된 건지를 알기 위해 boolean 배열을 선언하여 확인하였다. 
 * 
 * 무작정 꼼꼼하게만 구현하면 되는 문제....
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int length = str.length();
		int answer = 0;
		boolean[] marked = new boolean[length];
		char[] quack = "quack".toCharArray();
		for (int i = 0; i < length; i++) {
			if (marked[i] || str.charAt(i) != 'q')
				continue;
			int quackIdx = 0;
			for (int j = i; j < length; j++) {
				if (marked[j])
					continue;
				char quackChar = quack[quackIdx];
				char nowChar = str.charAt(j);
				if (quackChar == nowChar) {
					quackIdx = (quackIdx + 1) % 5;
					marked[j] = true;
				}
			}
			if (quackIdx == 0)
				answer++;
			else {
				answer = -1;
				break;
			}
		}
		for (boolean b : marked) {
			if (!b) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}
}
