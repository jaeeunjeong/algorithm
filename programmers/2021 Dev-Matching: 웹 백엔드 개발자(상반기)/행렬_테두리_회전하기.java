import java.util.*;
/**
	1. 위치 정보와 숫자를 보관할 자료형(class Dot)을 만들고 자료형을 이용해서 재배치하는데 사용.
	2. 회전할 숫자과 그 위치 정보들을 Queue로 담아서 연결하여 사용.
*/
class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] map = new int[rows + 1][columns + 1];
		int idx = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = idx++;
			}
		}

		for (int j = 0; j < queries.length; j++) {
			int[] cur = queries[j];
			int startR = cur[0];
			int startC = cur[1];
			int endR = cur[2];
			int endC = cur[3];
			int min = Integer.MAX_VALUE;
			Queue<Dot> queue = new LinkedList<>();
			
			for (int i = startC; endC > i; i++) {
				queue.add(new Dot(startR, i, map[startR][i]));
			}
			for (int i = startR; endR > i; i++) {
				queue.add(new Dot(i, endC, map[i][endC]));
			}
			for (int i = endC; i > startC; i--) {
				queue.add(new Dot(endR, i, map[endR][i]));
			}
			for (int i = endR; i > startR - 1; i--) {
				queue.add(new Dot(i, startC, map[i][startC]));
			}
			
			Dot now = new Dot(startR - 1, startC, map[startR - 1][startC]);
			while (!queue.isEmpty()) {
				Dot curQueue = queue.poll();
				int nextR = curQueue.row;
				int nextC = curQueue.col;
				int number = now.number;
				
				now = curQueue;
				map[nextR][nextC] = number;
				min = Math.min(min, now.number);
			}
			answer[j] = min;
		}
		return answer;
	}
}

class Dot {
	int row;
	int col;
	int number;

	Dot(int row, int col, int number) {
		this.row = row;
		this.col = col;
		this.number = number;
	}
}
