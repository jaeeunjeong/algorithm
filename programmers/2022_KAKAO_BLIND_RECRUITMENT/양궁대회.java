// https://programmers.co.kr/learn/courses/30/lessons/92342
/*
 * 백트래킹과 DFS로 풀이
*/
class Solution {
	static int N, max;
	static int[] apeach, rion, answer;

	public int[] solution(int n, int[] info) {
		answer = new int[] { -1 };
		N = n;
		rion = new int[11];
		apeach = info;
		max = Integer.MIN_VALUE;
		combi(0);

		return answer;
	}

	public static void combi(int idx) {
		if (idx == N) {
			int[] score = new int[2];// apeach 0, rion 1
			for (int i = 0; i < 11; i++) {
				if (apeach[i] == 0 && rion[i] == 0)
					continue;
				if (apeach[i] >= rion[i])
					score[0] += 10 - i;
				else
					score[1] += 10 - i;
			}
			if (score[0] < score[1] && (score[1] - score[0]) >= max) {
				answer = new int[11];
				max = Math.max(score[1] - score[0], max);
				for (int i = 0; i < 11; i++)
					answer[i] = rion[i];
			}
			return;
		}

		for (int i = 0; i < 11; i++) {
            if(rion[i] > apeach[i]) break;
			rion[i]++;
			combi(idx + 1);
			rion[i]--;
		}
	}
}
