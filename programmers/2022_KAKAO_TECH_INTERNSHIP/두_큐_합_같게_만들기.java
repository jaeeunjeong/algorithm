// https://school.programmers.co.kr/learn/courses/30/lessons/118667
import java.util.*;
/*
 * 완전 Queue 문제!!
 * 최대 60만번 정도의 연산만 해서 그냥 풀어도 되는 건가 싶음...
 */
class Solution {
	public int solution(int[] _queue1, int[] _queue2) {
		int answer = 0;
		// 최소의 갯수로 넣고 빼면서 두 큐의 값을 같게 만들기
		int sum1 = 0;
		int sum2 = 0;
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();
		for(int i : _queue1) {
			sum1+= i;
			queue1.add(i);
		}
		
		for(int i : _queue2) {
			sum2+= i;
			queue2.add(i);
		}
		
		while(answer <= (_queue1.length << 2)) {
			if(sum1 < sum2) {
				int cur = queue2.poll();
				sum1 += cur;
				sum2 -= cur;
				queue1.add(cur);
			}else if(sum1 > sum2) {
				int cur = queue1.poll();
				sum1 -= cur;
				sum2 += cur;
				queue2.add(cur);
			}else {
				return answer;
			}
			answer++;
		}
		
		return -1;
	}

}
