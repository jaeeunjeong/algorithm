//https://programmers.co.kr/learn/courses/30/lessons/85002
import java.util.*;

class Solution {
	public int[] solution(int[] weights, String[] head2head) {
		int total = weights.length;
		player[] players = new player[total];
		int[] answer = new int[total];
		for (int i = 0; i < total; i++) {
			players[i] = new player();
			players[i].number = i;
			players[i].weight = weights[i];
			players[i].win = 0;
			int round = 0;
			for (int j = 0; j < total; j++) {
				if (i == j)
					continue;
				char cur = head2head[i].charAt(j);
				if (cur == 'N')
					continue;
				round++;
				if (cur == 'W') {
					players[i].win++;
					if (weights[j] > weights[i])
						players[i].toOverweightWin++;
				}
			}
			if (round == 0)
				continue;
			double temp = players[i].win == 0 ? 0 : (players[i].win * 100 / round * 100) * 100;
			players[i].win = temp;

		}
		Arrays.sort(players);
		for (int i = 0; i < total; i++) {
			answer[i] = players[i].number + 1;
		}
		return answer;
	}
}

class player implements Comparable<player> {
	int number;
	double win;
	int toOverweightWin;
	int weight;

	@Override
	public int compareTo(player o) {
		if (this.win == o.win) {
			if (this.toOverweightWin == o.toOverweightWin) {
				if (this.weight == o.weight) {
					return this.number - o.number;
				}
				return -(this.weight - o.weight);
			}
			return -(this.toOverweightWin - o.toOverweightWin);
		}
		return (int) -(this.win - o.win);
	}
}
