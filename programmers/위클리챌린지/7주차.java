//https://programmers.co.kr/learn/courses/30/lessons/86048
/**
 * Set을 이용하여 풀이
 * set을 방이라고 생각하고 방에 없으면 퇴실할 상태라고 판단하였다.(Line 18)
 * 	-> 퇴실 상태가 아니라면 퇴실 상태를 만들기 위해 계속해서 방에 사람들을 넣어준다. (Line 18-19)
 * 퇴실하면 방에 남아있는 사람들은 입실해있는 사람들은 퇴실할 사람을 만난 것이기에 값을 1씩 증가해주었다. (Line 24)
 * 퇴실할 사람의 경우 방에 남아있는 사람들을 만난 것이기에 방의 인원수(set의 size)를 추가로 더해주었다.(Line 27) 
**/

import java.util.*;

class Solution {
	public int[] solution(int[] enter, int[] leave) {
		int[] answer = new int[enter.length];
		Set<Integer> set = new HashSet<>();
		int index = 0;
		for (int l = 0; l < leave.length; l++) {
			
			while (!set.contains(leave[l]) && index < enter.length) {
				set.add(enter[index++]);
			}

			set.remove(leave[l]);
			for (int i = 1; i <= enter.length; i++) {
				if (set.contains(i)) {
					answer[i - 1]++;
				}
			}
			answer[leave[l] - 1] += set.size();
		}
		return answer;
	}
}
