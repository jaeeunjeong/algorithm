//https://programmers.co.kr/learn/courses/30/lessons/77886
import java.util.*;

/**
 * 단순한 문자열 문제인 줄 알았는데 stack을 이용한 복잡한 문제였다. 약간의 재귀적인 성질도 있는 거 같아서 stack의 특성을 이용해서
 * 새로운 값들에 대해 파악하며 110을 만들 수 있는 모든 경우를 제외한 문자열을 만든다.
 * 그 문자열의 마지막 0자리를 찾은 다음 원래의 문자열을 만든다. 
 * 그 후 마지막 0 자리에 110을 넣어준다. stack이 가지고 있는 특성을 잘 이해해야한다....
 * 
 * 자바에서 제공하는 라이브러리 사용해서 그나마 깔끔하게 코딩 완료
 */
class Solution {
	public String[] solution(String[] s) {
		String[] answer = new String[s.length];
		int answerIdx = 0;
		for (String str : s) {
			Stack<Character> stack = new Stack<>();
			StringBuffer sb = new StringBuffer();
			int cnt = 0;
			
			// 1. 110을 찾아준다. 
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (stack.size() > 1) {
					char b = stack.pop();
					char a = stack.pop();
					if (a == '1' && b == '1' && c == '0') {
						cnt++;
					} else {
						stack.push(a);
						stack.push(b);
						stack.push(c);
					}
				} else {
					stack.push(c);
				}
			}
			
			//2. 110을 제외한 문자열을 원래대로 만들어준다. stack이기 때문에  reverse를 꼭 해줘야함.
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
			
			//3. 제일 마지막에 0의 자리를 찾고 그 자리에 110을 넣어준다.
			int idx = sb.lastIndexOf("0") == -1 ? 0 : sb.lastIndexOf("0") + 1;
			while (cnt-- > 0) {
				sb.insert(idx, "110");
				idx += 3;
			}
			answer[answerIdx++] = sb.toString();
		}
		return answer;
	}
}
