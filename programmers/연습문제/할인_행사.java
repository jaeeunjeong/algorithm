import java.util.*;
/*
 * 맵이랑 배열이용해서 구현함
*/
class Solution {
	static int[] target;

	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		int[] count = new int[number.length];
		Map<String, Integer> dict = new HashMap<>();
        
		int idx = 0;
		target = new int[number.length];
		for (String w : want) {
			dict.put(w, idx);
			target[idx] = number[idx++];
		}

		for (int i = 0; i < 10; i++) {
			String cur = discount[i];
			if (dict.containsKey(cur))
				count[dict.get(cur)]++;
		}
		answer += verify(count) ? 1 : 0;

		for (int i = 10; i < discount.length; i++) {
			String cur = discount[i];
			if (dict.containsKey(cur))
				count[dict.get(cur)]++;

			String prev = discount[i - 10];
			if (dict.containsKey(prev))
				count[dict.get(prev)]--;

			answer += verify(count) ? 1 : 0;
		}

		return answer;
	}

	private static boolean verify(int[] count) {
		int result = 0;

		for (int i = 0; i < count.length; i++) {
			if (count[i] >= target[i]) {
				result++;
			}
		}
        
		return result == count.length ? true : false;
	}
}
