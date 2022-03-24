//https://programmers.co.kr/learn/courses/30/lessons/77486
import java.util.*;
/**
 * 트리 + DFS
 * 
 * 소개해준 사람을 배열로 관리하며 center까지 올라가면서 수수료를 떼주었다.
 * 소개해준 사람은 문자열로 주어져서 Map을 이용해서 관리했다.
 * 
 * 주의해야할 점은 계산 과정에서 10%의 나머지를 갖는다여서!!!
 * 이익에서 - 10%한 금액을 내 이익에 더해주면 된다.
 */
class Solution {
	static int[] refer;
	static int[] answer;
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		// 초기화 과정
		answer = new int[enroll.length];
		Map<String, Integer> dict = new HashMap<>();
		int idx = 0;
		for (String name : enroll)
			dict.put(name, idx++);
		refer = new int[idx];
		idx = 0;
		dict.put("-", -1);
		for (String person : referral) {
			int referPerson = dict.get(person);
			refer[idx++] = referPerson;
		}
		
		//연산 과정
		for (int i = 0; i < seller.length; i++) {
			String s = seller[i];
			int a = amount[i] * 100;
			int person = dict.get(s);
			root(person, a);
		}
		return answer;
	}

	public static void root(int idx, int money) {
		if (idx == -1)
			return;
		answer[idx] += money - (int) (money * 0.1);
		root(refer[idx], (int) (money * 0.1));
	}
}
