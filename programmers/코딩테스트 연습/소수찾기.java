//https://programmers.co.kr/learn/courses/30/lessons/12921
import java.util.*;

class Solution {
	public int solution(int n) {
		Set<Integer> set = new HashSet<>();
		int answer = 0;
		set.add(0);
		set.add(1);
		for (int i = 2; i <= n; i++) {
			if (set.contains(i))
				continue;
			for (int j = i + i; j <= n; j += i) {
				set.add(j);
			}
		}

		for (int i = 0; i <= n; i++) {
			if (!set.contains(i)) {
				answer++;
			}
		}
		return answer;
	}
}
