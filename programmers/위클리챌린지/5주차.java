//https://programmers.co.kr/learn/courses/30/lessons/84512
class Solution {
	static int cnt, answer;
	static String str = "AEIOU";
	static boolean isDone;

	public int solution(String word) {
		answer = -1;
		cnt = 0;
		isDone = false;
		combi(0, word, "");
		System.out.println(answer);
		return answer;
	}

	public static void combi(int cnt, String word, String cur) {

		if (cnt < 6) {
			if (!isDone)
				answer++;
            //System.out.println(cur);
			if (cur.equals(word)) {
				isDone = true;
				return;
			}

		} else
			return;

		if (isDone) {
			return;
		}
		for (int i = 0; i < 5; i++) {
			combi(cnt + 1, word, cur.concat(String.valueOf(str.charAt(i))));
		}
	}
}
