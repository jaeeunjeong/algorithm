//https://www.acmicpc.net/problem/1863
import java.io.*;
import java.util.*;

/**
 * stack을 이용해서 풀이하면 되는 문제. 
 * 구현 자체는 어렵지 않은데 마지막 값을 확인해주지 않아서 매우 애먹었다.
 * stack 문제는 마지막을 꼭꼭 잘 확인해주자.
 **/
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek() > y) {
				answer++;
				stack.pop();
			}
			if (!stack.isEmpty() && stack.peek() == y) {
				continue;
			}
				stack.add(y);
		}
		
		while (!stack.isEmpty() && stack.peek() > 0) {
			 answer++;
			stack.pop();
		}
		
		System.out.println(answer);

	}
}
