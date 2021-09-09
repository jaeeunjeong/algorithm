//https://programmers.co.kr/learn/courses/30/lessons/77484
import java.util.*;

class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		Set<Integer> set = new HashSet<>();

		// 1. 0을 제외한 숫자들로 당첨 여부 확인하기 (로또와 당첨 번호를 비교)
		int zero = 0;
		for (int i : lottos) {
			if (i == 0) {
				zero++;
			} else {
				set.add(i);
			}
		}
		int match = 0;
		for (int i : win_nums) {
			if (!set.contains(i))
				continue;
			match++;
		}

		// 최상의 경우 맞은 수가 2 이상이라면?
		answer[0] = match + zero > 1 ? 7 - match - zero : 6;
		// 최악의 경우
		answer[1] = match > 1 ? 7 - match : 6;

		return answer;
	}
}
