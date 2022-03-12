class Solution {
	public int[][] solution(int n, boolean clockwise) {
		int[][] answer = new int[n][n];
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[] curRs = new int[] { 0, 0, n - 1, n - 1 };
		int[] curCs = new int[] { 0, n - 1, n - 1, 0 };

		if (!clockwise) {
			dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
			curRs = new int[] { 0, n - 1, n - 1, 0 };
			curCs = new int[] { 0, 0, n - 1, n - 1 };
			for (int i = 0; i < 4; i++) {
				start(n, answer, curRs[i], curCs[i], dirs, i);
			}
		} else {
			for (int i = 0; i < 4; i++) {
				start(n, answer, curRs[i], curCs[i], dirs, i);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
		return answer;
	}

	public static void start(int n, int[][] answer, int nextR, int nextC, int[][] dirs, int startD) {
		int num = 1;
		int d = startD;
		int end = n - 1;
		while (end > 0) {
			for (int i = 0; i < end; i++) {
				answer[nextR][nextC] = num++;
				if (i == end - 1)
					d++;
				nextR = nextR + dirs[d % 4][0];
				nextC = nextC + dirs[d % 4][1];
			}
			end -= 2;
		}

		if (n % 2 == 1)
			answer[nextR][nextC] = num;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int num = 1;
		s.solution(num++, false);
		System.out.println();
		s.solution(num++, false);
		System.out.println();
		s.solution(num++, false);
		System.out.println();
		s.solution(num++, false);
		System.out.println();
		s.solution(num++, false);
		System.out.println();
		s.solution(num++, false);
		System.out.println();
	}
}
