//https://www.acmicpc.net/problem/9935 
import java.io.*;
import java.util.*;

/**
 * stack 프레임워크가 인덱스 기능을 제공하는 줄 알았다면 더 빨리 풀었을 것 같은 문제...
 * 스택이 폭탄문자열보다 커졌다면, 폭탄 문자열 길이만큼 재탐색해줘서 풀면 된다!
 */
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = br.readLine();
		String bomb = br.readLine();

		int length = bomb.length();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			stack.push(ch);

			if (stack.size() >= length) {
				boolean flag = true;
				for (int j = 0; j < length; j++) {
					int idx = stack.size() - length + j;
					if (stack.get(idx) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < length; j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		for (char c : stack)
			sb.append(c);
		String answer = sb.length() == 0 ? "FRULA" : sb.toString();
		System.out.println(answer);
	}
}
