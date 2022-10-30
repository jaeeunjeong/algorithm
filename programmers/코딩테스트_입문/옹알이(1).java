/*
* 완전 무지성으로 대충 풂...
*/
class Solution {
	public int solution(String[] babbling) {
		int answer = 0;
		String[] sample = new String[] { "aya", "ye", "woo", "ma" };
		for (String b : babbling) {
			for (String s : sample) {
				b = b.replace(s, "-");
			}
			b = b.replace("-", "");
			if (b.length() == 0)
				answer++;
		}
		return answer;
	}
}
