//https://www.acmicpc.net/problem/2504
import java.io.*;
import java.util.*;

/**
 * 예외처리가 많이 필요해서 엄청 까다로웠던 문제.
 * 괄호 문제라서 일단 스택을 쓰고 봤는데 바로 앞 값과의 관계(연속해서 있는 지 확인)나,
 * 짝이 맞지 않아 적절하지 않다면 얼른 나와야하고 생각보다 고려해야할 사항이 많았던 문제
 * stack + 문자열
 **/
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		Stack<Character> stack = new Stack<>();
		int sum = 0;
		int cur = 1;
		String s = st.nextToken();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!stack.isEmpty() && ')' == c) {
				if (i > 0 && s.charAt(i - 1) == '(')
					sum += cur;
				else if (stack.peek() != '(') {
					sum = 0;
					break;
				}
				stack.pop();
				cur /= 2;
			} else if (!stack.isEmpty() && ']' == c) {
				if (i > 0 && s.charAt(i - 1) == '[')
					sum += cur;
				else if (stack.peek() != '[') {
					sum = 0;
					break;
				}
				stack.pop();
				cur /= 3;
			} else if ('(' == c) {
				stack.add(c);
				cur *= 2;
			} else if ('[' == c) {
				stack.add(c);
				cur *= 3;
			} else {
				sum = 0;
				break;
			}
		}
		if (!stack.isEmpty())
			sum = 0;
		System.out.println(sum);
	}

}
