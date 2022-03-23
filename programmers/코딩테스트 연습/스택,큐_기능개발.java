//https://programmers.co.kr/learn/courses/30/lessons/42586
import java.util.*;
/**
 * 각각 기능들을 속도에 맞춰서 진행 상황을 체크해주고, Queue를 이용해서 배포를 관리한다.
 * Queue에는 인덱스 순서를 넣어줘서 앞의 것이 완료되면 다음 단계로 진행하도록 해준다.
 */
class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		List<Integer> list = new ArrayList();
		Queue<Integer> queue = new LinkedList();

		for (int i = 0; i < progresses.length; i++) {
			queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			// 배포
			int cnt = 0;
			while (progresses[queue.peek()] >= 100) {
				cnt++;
				queue.poll();
			}
			if (cnt > 0)
				list.add(cnt);

			// 진행속도 관리
			for (int i = 0; i < progresses.length; i++) {
				if (progresses[i] >= 100)
					continue;
				progresses[i] += speeds[i];
			}
		}

		//정답
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i);
		
		return answer;
	}
}
