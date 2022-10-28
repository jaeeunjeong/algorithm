// https://school.programmers.co.kr/learn/courses/30/lessons/131704
import java.util.*;
/**
 * stack이랑 분기처리해서 풀이함
 */
class Solution {
	public int solution(int[] order) {
		int answer = 0;
		Stack<Integer> stack = new Stack();

		int idx = 1; // 보조 컨테이너에 넣을 카운트
		for (int o : order) {
			
			// 기사님 순서와 기본 컨테이너 순서가 맞는 경우
			if (idx == o) {
				idx++;
				answer++;
				if (!stack.isEmpty() && stack.peek() == o)
					stack.pop();
				continue;
			}

			// 기사님 순서와 보조 컨테이너 순서가 맞는 경우
			if (!stack.isEmpty() && stack.peek() == o) {
				answer++;
				stack.pop();
				continue;
			}

			// 보조 컨테이너에 넣어서 순서 맞추기
			while (idx <= order.length && idx != o) {
				stack.add(idx++);
			}

			// 기사님 순서와 컨테이너 순서가 맞는 경우
			if (idx == o) {
				answer++;
				idx++;
				continue;
			}
			
			//더이상 보조 컨테이너에 넣을 수 없는 경우
			if (idx >= order.length)
				break;

		}

		return answer;
	}
}
